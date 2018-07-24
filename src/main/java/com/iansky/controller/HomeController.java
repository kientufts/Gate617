package com.iansky.controller;

import com.iansky.dao.ProductDao;
import com.iansky.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(){
		return "home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model){
		List<Product> productList = productDao.getAllProducts();
		model.addAttribute("products", productList);

		return "product-list";
	}

	@RequestMapping("/productList/viewProduct/{pId}")
	public String viewProduct(@PathVariable String pId, Model model) {
		Product product = productDao.getProductById(pId);
		model.addAttribute(product);
		return "view-product";
	}

	@RequestMapping("/admin")
	public String adminPage(){
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);

		return  "product-inventory";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model){
		Product product = new Product();
		product.setpCategory("Jean");
		product.setpCondition("new");
		product.setpStatus("active");

		model.addAttribute("product", product);
		return "add-product";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product){
		productDao.addProduct(product);

		return "redirect:/admin/productInventory";
	}
}
