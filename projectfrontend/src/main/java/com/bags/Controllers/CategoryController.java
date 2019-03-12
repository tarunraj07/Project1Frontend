package com.bags.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bags.dao.CategoryDao;
import com.bags.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDaoImpl;
	
	//Display all category
	@RequestMapping(value="/all/getAllCategories")
	public ModelAndView getCategory() {
		System.out.println("Category Controller get all categories page");
		List<Category> list=categoryDaoImpl.getAllProducts();
		return new ModelAndView("getAllCategory","catList",list);
	}
	
	//Display by id
	@RequestMapping(value="/all/getCategory/{cid}")
	public ModelAndView getCatId(@PathVariable("cid") int id) {
		System.out.println("Category Controller get category page");
		Category cat=categoryDaoImpl.getIdProducts(id);
		return new ModelAndView("getCategory","cat",cat);
	}
	
	//Delete category page
	@RequestMapping(value="/admin/delCategory/{cid}")
	public String delCat(@PathVariable("cid") int id) {
		System.out.println("Category Controller delete category page");
		categoryDaoImpl.deleteCategory(id);
		return "redirect:/all/getAllCategories";
	}
	
	//Add form category page
	@RequestMapping(value="/admin/saveCat")
	public ModelAndView addCat() {
		System.out.println("Category Controller add form page");
		return new ModelAndView("catAddForm","command",new Category());
	}
	
	//Adding to DB
	@RequestMapping(value="/admin/saveCategory")
	public String addCategory(@ModelAttribute("category") Category category,Model model) {
		System.out.println("Category Controller add category page");
		categoryDaoImpl.saveCategory(category);
		return "redirect:/all/getAllCategories";
	}
	
	//Updating form page
	@RequestMapping(value="/admin/updateCategory/{cid}")
	public ModelAndView updateCat(@PathVariable("cid") int id) {
		System.out.println("Category Controller update form page");
		Category cat=categoryDaoImpl.getIdProducts(id);
		return new ModelAndView("catUpdateForm","command",cat);
	}
	
	//Updating to DB
	@RequestMapping(value="/admin/updateCat")
	public String updateCategory(@ModelAttribute("category") Category category) {
		System.out.println("Category Controller update page");
		categoryDaoImpl.updateCategory(category);
		return "redirect:/all/getAllCategories";
	}
}
