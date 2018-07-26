package com.iansky.controller;

import com.iansky.dao.ProductDao;
import com.iansky.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;

	private Path path;

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
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
								 HttpServletRequest request){
		if(bindingResult.hasErrors()){
			return "add-product";
		}
		productDao.addProduct(product);
		MultipartFile pImage = product.getpImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getpId() + ".png");

		if(pImage != null && !pImage.isEmpty()){
			try {
				pImage.transferTo(new File(path.toString()));
			} catch (Exception ex){
				throw new RuntimeException("Product image saving failed");
			}
		}

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/productInventory/deleteProduct/{pId}")
	public String deleteProduct(@PathVariable String pId, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + pId + ".png");

		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}

		productDao.deleteProduct(pId);

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/productInventory/editProduct/{pId}")
	public String editProduct(@PathVariable String pId, Model model){
		Product product = productDao.getProductById(pId);
		model.addAttribute(product);
		return "edit-product";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
							  HttpServletRequest request){
		if(bindingResult.hasErrors()){
			return "edit-product";
		}
		MultipartFile pImage = product.getpImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getpId() + ".png");
		if(pImage != null && !pImage.isEmpty()){
			try {
				pImage.transferTo(new File(path.toString()));
			} catch (Exception ex)
			{
				throw new RuntimeException("Product image saving fail", ex);
			}
		}
		productDao.editProduct(product);
		return "redirect:/admin/productInventory";
	}
}
