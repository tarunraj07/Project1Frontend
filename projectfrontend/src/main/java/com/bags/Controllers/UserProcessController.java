package com.bags.Controllers;
/*package com.bags.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bags.dao.UserProcessDao;
import com.bags.model.UserProcess;

@Controller
public class UserProcessController {
	
	@Autowired
	private UserProcessDao userProcessDaoImpl;
	
	@RequestMapping("/userReg")
	public ModelAndView userReg(){
		System.out.println("Home Controller: User Registration Page");
		return new ModelAndView("Reg","command",new UserProcess());
	}
	
	@RequestMapping("/userLog")
	public ModelAndView userLog() {
		System.out.println("Home Controller: User Login Page");
		return new ModelAndView("login","command",new UserProcess());
	}

	@RequestMapping(value="register",method=RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("userProcess") UserProcess up) {	
		ModelAndView mv=new ModelAndView("homePage");
		return mv;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView getUser(@ModelAttribute(name="userProcess") UserProcess up, BindingResult rs, Model model ) {
		userProcessDaoImpl.saveUserProcess(up);
		ModelAndView mv=new ModelAndView("homePage","msg",new UserProcess());
		return mv;
	}
	
	@RequestMapping(value="Login",method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("userProcess") UserProcess up) {
		ModelAndView mv=new ModelAndView("homePage");
		return mv;
	}
	
	@RequestMapping(value="Login",method=RequestMethod.POST)
	public ModelAndView getLoginUser(@ModelAttribute("userProcess") UserProcess up) {
		boolean log=userProcessDaoImpl.loginUserProcess(up);
		if(log=false) {
			return new ModelAndView("userLog");}
		else {
			ModelAndView mv=new ModelAndView("homePage");
		return mv;}
	}
	
	@RequestMapping("/all/getAllUsers")
	public ModelAndView getAllUsers() {
		System.out.println("getAllUsers");
		List<UserProcess> userpro=userProcessDaoImpl.getId(1);		
		return new ModelAndView("userProcess","up",userpro);
	}
	
	@RequestMapping("/call")
	public String touser()
	{
		UserProcess up=new UserProcess();
		up.setName("xyz");
		up.setUsername("xyzzyx");
		up.setEmailid("xyz@abc");
		up.setNumber("321456");
		up.setPassword("abcd");
		userProcessDaoImpl.saveUserProcess(up);
		System.out.println("Successfully added");	
		return "homePage";
	}
	public void saveUser(UserProcess userPro) {
		userProcessDaoImpl.saveUserProcess(userPro);
		System.out.println("Successfully added");
	}
}
*/