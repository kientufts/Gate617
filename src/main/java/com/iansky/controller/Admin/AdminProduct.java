package com.iansky.controller.Admin;

import com.iansky.model.Product;
import com.iansky.service.ProductService;
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

@Controller
@RequestMapping("/admin")
public class AdminProduct {

	private Path path;

	@Autowired
	private ProductService productService;

	@RequestMapping("/product/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setpCategory("Jeans");
		product.setpCondition("New");
		product.setpStatus("Active");

		model.addAttribute("product", product);

		return "add-product";
	}

	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
								 HttpServletRequest request){
		if(bindingResult.hasErrors()){
			return "add-product";
		}

		productService.addProduct(product);

		MultipartFile pImage = product.getpImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getpId() + ".png");

		if(pImage != null && !pImage.isEmpty()){
			try {
				pImage.transferTo(new File(path.toString()));
			} catch (Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id,  Model model){
		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "edit-product";
	}

	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
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
			} catch (Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		productService.editProduct(product);

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model, HttpServletRequest request){
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}

		Product product = productService.getProductById(id);
		productService.deleteProduct(product);

		return "redirect:/admin/productInventory";
	}
}
