package com.bags.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bags.dao.ProductDao;
import com.bags.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDaoImpl;

	@RequestMapping(value = "/admin/saveProd")
	public String saveProd(Model model) {
		System.out.println("Product Controller: Save Product Page");
		model.addAttribute("product", new Product());
		model.addAttribute("categories", productDaoImpl.getAllCategories());
		System.out.println("Product Controller: Disaply All Products Page");
		List<Product> list = productDaoImpl.getAllProduct();
		model.addAttribute("prodList",list);
		return "prodForm";
	}

	@RequestMapping(value = "/all/getProducts/{id}")
	public ModelAndView getProdId(@PathVariable("id") int id, Model model) {
		System.out.println("Product Controller: Dispaly Product By Id Page");
		Product product = productDaoImpl.getId(id);
		return new ModelAndView("prodDetails", "prodlist", product);
	}

	@RequestMapping(value = "/admin/deleteProduct/{id}")
	public String deleteProduc(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("Product Controller: Delete Product By Id Page");
		productDaoImpl.deleteProduct(id);
		String rootContext = request.getServletContext().getRealPath("/");
		Path path = Paths.get(rootContext + "/resources/images/" + id + ".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/all/getAllProducts";
	}

	@RequestMapping(value = "/admin/udpateProduct/{id}")
	public String updateProd(@PathVariable("id") int id, Model model) {
		System.out.println("Product Controller: Update Product By Id Page");
		Product list = productDaoImpl.getId(id);
		model.addAttribute("product",list);
		model.addAttribute("categories",productDaoImpl.getAllCategories());
		return "prodUpdateForm";
	}
	
	@RequestMapping("/all/getAllProductsDisplay")
	public ModelAndView displayProducts() {
		System.out.println("Product Controller: Disaply All Products Page");
		List<Product> list = productDaoImpl.getAllProduct();
		/*model.addAttribute("cat", new Category());*/
		return new ModelAndView("allProducts", "prodList", list);
	}

	@RequestMapping(value = "/all/getAllProducts")
	public ModelAndView getProd(Model model) {
		System.out.println("Product Controller: Disaply All Products Page");
		List<Product> list = productDaoImpl.getAllProduct();
		/*model.addAttribute("cat", new Category());*/
		return new ModelAndView("allProd", "prodList", list);
	}

	/*@RequestMapping(value = "/admin/InsertProd")
	public String insertPro(@ModelAttribute("product") Product pro) {
		System.out.println("id:" + pro.getId());
		productDaoImpl.saveProduct(pro);
		return "redirect:/all/getAllProducts";
	}*/

	// handler method to get new product object
	@RequestMapping(value = "/admin/InsertProd")
	public String saveOrUpdateProduct(@Valid @ModelAttribute(name = "product") Product product, BindingResult result,
			Model model, HttpServletRequest request) {// input from jsp pages
		if (result.hasErrors()) {
			model.addAttribute("categories", productDaoImpl.getAllCategories());
			if (product.getId() == 0)// insert
				return "prodForm";
			else
				return "prodUpdateForm";
		}
		System.out.println("Product Id in SaveProduct method " + product.getId());
		String rootContext = request.getServletContext().getRealPath("/");
		/*String rootContext="F:/bagsECLIPSE/bags_OXYGEN/FrontEndProject/src/main/webapp/";*/
		// ........ project1frontend
		System.out.println("RootContext: "+rootContext);

		productDaoImpl.saveProduct(product);

		Path paths = Paths.get(rootContext + "/resources/images/" + product.getId() + ".png");
		MultipartFile productImage = product.getImage();
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(paths.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/all/getAllProducts";
	}

	@RequestMapping(value = "/admin/UpdateForm")
	public String updatepro(@ModelAttribute("product") Product pro) {
		System.out.println("Producut Controller product update");
		productDaoImpl.updateProduct(pro);
		return "redirect:/all/getAllProducts";
	}
}
