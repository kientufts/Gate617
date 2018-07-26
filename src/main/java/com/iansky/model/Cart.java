package com.iansky.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;

	private Cart(){
		cartItems = new HashMap<>();
		grandTotal = 0;
	}

	public Cart(String cartId){
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item){
		String pId = item.getProduct().getpId();
		if(cartItems.containsKey(pId)){
			// if item is already added to the cart, just update the quantity
			CartItem existingCartItem = cartItems.get(pId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(pId, existingCartItem);
		} else {
			// if item is not in the cart, add it
			cartItems.put(pId, item);
		}

		updateGrandTotal();
	}

	public void removeCartItem(CartItem item){
		// remove item in cart by id
		String pId = item.getProduct().getpId();
		cartItems.remove(pId);

		updateGrandTotal();
	}

	public void updateGrandTotal(){
		grandTotal = 0;
		for(CartItem item: cartItems.values()){
			grandTotal += item.getTotalPrice();
		}
	}
}
