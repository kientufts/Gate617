package com.iansky.controller;

import com.iansky.model.Product;
import com.iansky.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/productList")
	public String getProducts(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);

		return "product-list";
	}

	@RequestMapping("/viewProduct/{pId}")
	public String viewProduct(@PathVariable int pId, Model model) throws IOException{
		Product product = productService.getProductById(pId);
		model.addAttribute("product", product);

		return "view-product";
	}
}
