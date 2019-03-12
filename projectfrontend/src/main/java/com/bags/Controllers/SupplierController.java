package com.bags.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bags.dao.SupplierDao;
import com.bags.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDaoImpl;

	@RequestMapping(value="/all/getAllSuppliers")
	public ModelAndView getAllSupplier() {
		System.out.println("Supplier Controller get all supplier page");
		List<Supplier> supplier=supplierDaoImpl.listSupplier();
		return new ModelAndView("getAllSup","supList",supplier);
	}
	
	@RequestMapping(value="/admin/saveSup")
	public ModelAndView saveSupplier() {
		System.out.println("Supplier Controller save supplier page");
		return new ModelAndView("supplierForm","command",new Supplier());
	}
	
	@RequestMapping(value="/admin/saveSupplier")
	public String saveSup(@ModelAttribute("supplier") Supplier supplier) {
		System.out.println("Supplier Controller inserting a supplier into db page");
		supplierDaoImpl.addSupplier(supplier);
		return "redirect:/all/getAllSuppliers";
	}
	
	@RequestMapping(value="/all/getSupplier/{id}")
	public ModelAndView getSup(@PathVariable("id") int id) {
		System.out.println("Supplier Controller get supplier by id");
		Supplier sup=supplierDaoImpl.getSupplier(id);
		return new ModelAndView("displaySup","list",sup);
	}
	
	@RequestMapping(value="/admin/deleteSupplier/{id}")
	public String deleteSup(@PathVariable("id") int id) {
		System.out.println("Supplier Controller delete supplier page");
		supplierDaoImpl.deleteSupplier(id);
		return "redirect:/all/getAllSuppliers";
	}
	
	@RequestMapping(value="/admin/updateSupplier/{id}")
	public ModelAndView updateSup(@PathVariable("id") int id,Model model) {
		System.out.println("Supplier Controller update supplier page");
		Supplier sup=supplierDaoImpl.getSupplier(id);
		return new ModelAndView("supUpdateForm","command",sup);
	}
	
	@RequestMapping(value="/admin/supUpdateForm")
	public String UpdateSupform(@ModelAttribute("supplier") Supplier sup,Model model) {
		System.out.println("Supplier Controller supplier udpate form page");
		supplierDaoImpl.updateSupplier(sup);
		return "redirect:/all/getAllSuppliers";
	}
}
