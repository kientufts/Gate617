package com.iansky.dao;

import com.iansky.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

	private Map<String, Cart> listOfCarts;

	public CartDaoImpl(){
		listOfCarts = new HashMap<>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())){
			throw new IllegalArgumentException(String.format("A cart with Id(%) is already exist", cart.getCartId()));
		}

		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot update. The cart with Id(%) does not exist", cart
					.getCartId()));
		}

		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot delete the cart. A cart with Id(%) does not exist",
					cartId));
		}

		listOfCarts.remove(cartId);
	}
}
