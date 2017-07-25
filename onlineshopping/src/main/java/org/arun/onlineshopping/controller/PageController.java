package org.arun.onlineshopping.controller;

import org.arun.shoppingbackend.dto.*;

import org.arun.shoppingbackend.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Online Shopping");
		//passing the categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickedHome",true);
		return mv;
	}
	//load all products
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//passing the categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickedAllProducts",true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable ("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//categorydao to get single product
		Category category= null;
		category= categoryDAO.get(id);		
		mv.addObject("title", category.getName());
		//passing the categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userClickedCategoryProducts",true);
		return mv;
	}


	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickedAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickedContact",true);
		return mv;
	}

}
