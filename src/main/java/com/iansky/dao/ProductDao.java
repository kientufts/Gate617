package com.iansky.dao;

import com.iansky.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	private List<Product> productList;

	public List<Product> getProductList(){

		Product product = new Product();
		product.setpName("White Jean");
		product.setpCategory("Jean");
		product.setpDescription("This is in new arrival");
		product.setpPrice(56);
		product.setpCondition("new");
		product.setpStatus("Active");
		product.setpUnitInStock(12);
		product.setpManufacturer("Uniqlo");

		productList = new ArrayList<Product>();
		productList.add(product);

		Product product2 = new Product();
		product2.setpName("Black Pant");
		product2.setpCategory("Pant");
		product2.setpDescription("This is in old model");
		product2.setpPrice(50);
		product2.setpCondition("used");
		product2.setpStatus("Active");
		product2.setpUnitInStock(3);
		product2.setpManufacturer("Zara");
		productList.add(product2);

		Product product3 = new Product();
		product3.setpName("Black Hoodie");
		product3.setpCategory("Hoodie");
		product3.setpDescription("This is a sale one");
		product3.setpPrice(30);
		product3.setpCondition("new");
		product3.setpStatus("Active");
		product3.setpUnitInStock(5);
		product3.setpManufacturer("H&M");
		productList.add(product3);

		return  productList;
	}
}
