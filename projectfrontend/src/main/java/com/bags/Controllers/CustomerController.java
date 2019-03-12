package com.bags.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bags.dao.CustomerDao;
import com.bags.email.Email;
import com.bags.model.Customer;
import com.bags.model.User;

@Controller
public class CustomerController {
	@Autowired
private CustomerDao customerDao;
	
/*	@RequestMapping("/login")
	public String login(@RequestParam(required=false)String error,Model model){		
		System.out.println("inside the login");
		model.addAttribute("user", new User());
		return "login";		
	}*/
	
	@RequestMapping(value="/registrationform")
	public ModelAndView getRegistrationForm(){
		return new ModelAndView("registrationForm","customer",new Customer());
	}
	@RequestMapping(value="/all/register")
	public String registerCustomer(@ModelAttribute(name="customer") Customer customer,Model model){
		if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
			model.addAttribute("error","Email Id already Exists.. please enter different email address");
			return "registrationform";
		}
	   	customerDao.registerCustomer(customer);
	   	String FROM="generatorstory@gmail.com", PASSWORD="storygenauto", TO=customer.getUser().getEmail().trim(), SUBJECT="bags DEVEOPS!", MESSAGE="Hi "+customer.getFirstname()+" "+customer.getLastname()+"! Thank you for Shoping and supporting us.";
	   	Email mail = new Email(FROM, PASSWORD);
		boolean result=mail.sendSimpleMail(FROM, TO, SUBJECT, MESSAGE);
		if(result)
			System.out.println("Mail sent successfully!");
		else
			System.out.println("Mail not sent");
	   	return "login";
	}
}