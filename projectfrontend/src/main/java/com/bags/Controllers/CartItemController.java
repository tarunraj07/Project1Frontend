package com.bags.Controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bags.dao.CartItemDao;
import com.bags.dao.CustomerDao;
import com.bags.dao.PaymentModeDao;
import com.bags.dao.PlaceOrderHistoryDao;
import com.bags.dao.ProductDao;
import com.bags.email.Email;
import com.bags.model.CartItem;
import com.bags.model.PaymentMode;
import com.bags.model.PlaceOrderHistory;
import com.bags.model.Product;
import com.bags.model.User;

@Controller
public class CartItemController {
	@Autowired
	private ProductDao productDaoImpl;
	@Autowired
	private CustomerDao customerDaoImpl;
	@Autowired
	private CartItemDao cartItemDaoImpl;
	@Autowired
	private PlaceOrderHistoryDao placeOrderHistoryDaoImpl;
	@Autowired
	private PaymentModeDao paymentModeDaoImpl;
	
	@RequestMapping(value="/cart/addtocart")
	public String addToCart(@RequestParam int productId,@RequestParam int requestedQuantity, HttpSession sesison,@AuthenticationPrincipal  Principal principal ){
		String email=principal.getName();//Email id of the logged in user
		List<CartItem> cartItems=cartItemDaoImpl.getCartItem(email);
		Product product=productDaoImpl.getId(productId);
		int totalQnt=0;
		int prodQnt=product.getQuantity();
		for(CartItem cartItem:cartItems){
			if(cartItem.getProduct().getId()==productId){
				if(cartItem.getQuantity()!=0) {
					System.out.println("inside total quantity "+cartItem.getQuantity()+" product "+prodQnt);
					totalQnt=cartItem.getQuantity();
					prodQnt+=totalQnt;
					prodQnt-=requestedQuantity;System.out.println("inside total quantity "+totalQnt+" "+cartItem.getQuantity()+" product "+prodQnt);
					cartItem.setQuantity(requestedQuantity);
					cartItem.setTotalPrice(requestedQuantity * product.getPrice() );
					cartItemDaoImpl.saveOrUpdateCartItem(cartItem);//update					
					product.setQuantity(prodQnt);
					productDaoImpl.updateProduct(product);
					return "redirect:/cart/purchasedetails";
				}
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity * product.getPrice() );
				cartItemDaoImpl.saveOrUpdateCartItem(cartItem);//update
				prodQnt-=requestedQuantity;
				product.setQuantity(prodQnt);				
				return "redirect:/cart/purchasedetails";
			}
		}
		
		
		CartItem cartItem=new CartItem();
		
		User user=cartItemDaoImpl.getUser(email);
		cartItem.setProduct(product);
		cartItem.setQuantity(requestedQuantity);
		cartItem.setUser(user);
		cartItem.setTotalPrice(requestedQuantity * product.getPrice());
		cartItemDaoImpl.saveOrUpdateCartItem(cartItem);//insert
		prodQnt-=requestedQuantity;
		product.setQuantity(prodQnt);
		productDaoImpl.updateProduct(product);
		return "redirect:/cart/purchasedetails";
	}
	@RequestMapping(value="/cart/purchasedetails")
	public String getPurchaseDetails(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDaoImpl.getCartItem(email);
		model.addAttribute("cartItems",cartItems);
		session.setAttribute("cartSize",cartItems.size() );
		return "cart";
	}
	
	@RequestMapping(value="/paymentMode/{totalPrice}")
	public String paymentMode(@PathVariable int totalPrice, Model model) {
		model.addAttribute("paymentMode",new PaymentMode());	
		model.addAttribute(totalPrice);
		return "paymentMode";
	}
	
	@RequestMapping(value="/cart/placeOrder/{totalPrice}")
	public String placeOrder(@PathVariable int totalPrice, @AuthenticationPrincipal Principal principal, Model m) {
		int id=0;
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDaoImpl.getCartItem(email);
		PlaceOrderHistory placeOrderHistory=new PlaceOrderHistory();
		User user=customerDaoImpl.getById(email);
		String FROM="generatorstory@gmail.com", PASSWORD="storygenauto", TO=email.trim(), SUBJECT="bags DEVEOPS!", MESSAGE="Hi "+user.getCustomer().getFirstname()+"! Thank you for Shoping and supporting us.";
		System.out.println("user name "+user.getEmail()+" "+user.getCustomer().getBillingaddress().getCity());
		for(CartItem cartItem:cartItems){			
			Product product=productDaoImpl.getId(cartItem.getProduct().getId());
			placeOrderHistory.setPlacedOnDate(new Date());
			placeOrderHistory.setProduct(product);
			placeOrderHistory.setUser(user);
			placeOrderHistory.setTotalPrice(totalPrice);
			placeOrderHistory.setQuantity(cartItem.getQuantity());
			placeOrderHistoryDaoImpl.addPlaceOrderHistory(placeOrderHistory);			
			cartItemDaoImpl.removeCartItem(cartItem.getItemId());
		}
		Email mail = new Email(FROM, PASSWORD);
		boolean result=mail.sendSimpleMail(FROM, TO, SUBJECT, MESSAGE);
		if(result)
			System.out.println("Mail sent successfully!");
		else
			System.out.println("Mail not sent");
		m.addAttribute("cartItems",cartItems);
		m.addAttribute("user",user);		
		return "placedOrder";
	}
	@RequestMapping(value="/placeOrderHistory")
	public String placeOrderHistory(@AuthenticationPrincipal Principal principal,Model m) {
		String email=principal.getName();
		List<PlaceOrderHistory>placeOrderHistory=placeOrderHistoryDaoImpl.getAllPlaceOrderHistory(email);
		m.addAttribute("poh",placeOrderHistory);
		return "placeOrderHistory";
	}
	
	@RequestMapping(value="/cart/deletecartitem/{itemId}")// cart/**  ROLE_USER
	public String removeCartItem(@PathVariable int itemId, @AuthenticationPrincipal Principal principal){	
		String email=principal.getName();
		CartItem cartItems=cartItemDaoImpl.getCartItemId(itemId);
		int totalQnt=cartItems.getQuantity(),prodQnt=cartItems.getProduct().getQuantity();
		prodQnt+=totalQnt;
		Product product=productDaoImpl.getId(cartItems.getProduct().getId());
		product.setQuantity(prodQnt);
		productDaoImpl.updateProduct(product);
		cartItemDaoImpl.removeCartItem(itemId);
		return "redirect:/cart/purchasedetails";
	}
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDaoImpl.getCartItem(email);
		int totalQnt=0,prodQnt=0;
		for(CartItem cartItem:cartItems){
			Product product=productDaoImpl.getId(cartItem.getProduct().getId());
			prodQnt=cartItem.getProduct().getQuantity();
			totalQnt=cartItem.getQuantity();
			prodQnt+=totalQnt;
			product.setQuantity(prodQnt);
			productDaoImpl.updateProduct(product);
			cartItemDaoImpl.removeCartItem(cartItem.getItemId());
		}
		return "redirect:/cart/purchasedetails";
	}
	
	@RequestMapping(value="/paymentModeDebitCard")
	public String paymentModeDebitCard(@ModelAttribute PaymentMode paymentMode, Model m, @RequestParam int totalPrice) {
		System.out.println("inside the debit card payment mode method "+totalPrice+" "+paymentMode);
		String user_num=paymentMode.getDigi16(),admin_num="123456789123567";
		String user_cvv=paymentMode.getCvv(),user_cardHolder=paymentMode.getBankHolderName();
		int user_month=paymentMode.getMonth(),user_year=paymentMode.getYear();
		PaymentMode userPayment=paymentModeDaoImpl.getPayment(user_num);
		if(userPayment==null) {
			m.addAttribute("error","Please insert the valid 16 digit number!");
			m.addAttribute(totalPrice);
			return "paymentMode";
		}			
		PaymentMode adminPayment=paymentModeDaoImpl.getPayment(admin_num);
		double user_bal=userPayment.getBalance(),tempuserbal=user_bal,admin_bal=adminPayment.getBalance();
		if(user_cvv.equals(userPayment.getCvv()) && user_cardHolder.equals(userPayment.getBankHolderName()) && user_month==userPayment.getMonth() && user_year==userPayment.getYear()) {
			if(user_bal>=totalPrice) {
				user_bal-=totalPrice;
				admin_bal+=totalPrice;
				System.out.println("admin and user digi16 "+adminPayment.getDigi16()+" "+userPayment.getDigi16());
				System.out.println("Admin bal and User bal "+admin_bal +" " +user_bal+" "+tempuserbal);
				adminPayment.setBalance(admin_bal);
				paymentMode.setBalance(user_bal);
				System.out.println("admin and user digi16 "+adminPayment.getDigi16()+" "+userPayment.getDigi16()+" admin bal and user bal "+admin_bal+" "+user_bal);
				System.out.println("/*/*/*/ Updting admin balance "+paymentModeDaoImpl.updatePayment(adminPayment));
				System.out.println("/*/*/*/ Updating user balance "+paymentModeDaoImpl.updatePayment(paymentMode));
				return "redirect:/cart/placeOrder/"+totalPrice;
			}else {
				m.addAttribute("error","Insufficient balance, Please try again with some other account!");
				return "cart";
			}
		}
		m.addAttribute("error", "Entered worng details! try again");
		return "cart";
	}
}
