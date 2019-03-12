package com.bags.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bags.dao.CategoryDao;
import com.bags.model.Category;

@Controller
public class HomeController {
	@Autowired
	private CategoryDao categoryDaoImpl;
	
	@RequestMapping(value= {"/","/homePage"})
	public String homePage(HttpSession session){
		System.out.println("Home Controller: Home Page");
		List<Category> list=categoryDaoImpl.getAllProducts();
		session.setAttribute("catList", list);
		return "homePage";
	}
	
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		System.out.println("Home Controller: aboutUs Page");
		return "aboutUs";
	}
	
	/*@RequestMapping("/login")
	public String login(@RequestParam(required=false)String error,Model model){		
		System.out.println("inside the login");
		return "login";		
	}*/
	
	@RequestMapping("/login")
	public String login(@RequestParam(required=false)String error,Model model){		
		System.out.println("inside the login");
		if(error!=null)
			model.addAttribute("error","Invalid username/password");		
		return "login";		
	}
	
	@RequestMapping("/contactUs")
	public String contactUs(){
		System.out.println("Home Controller: contactUs Page");
		return "contactUs";
	}
	
	@RequestMapping("/loginerror")
	public String loginError() {
		System.out.println("Login error");
		return "loginError";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("Logout successfully");
		return "homePage";
	}
	
	@RequestMapping("/loginSuccess")
	public String loginSuccess() {
		System.out.println("login success");
		return "homePage";
	}
	
}
