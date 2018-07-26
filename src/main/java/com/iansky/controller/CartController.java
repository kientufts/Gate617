package com.iansky.controller;

import com.iansky.dao.CartDao;
import com.iansky.dao.ProductDao;
import com.iansky.model.Cart;
import com.iansky.model.CartItem;
import com.iansky.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable("cartId") String cardId){
		return cartDao.read(cardId);
	}

	@RequestMapping(value = "/{cardId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable("cardId") String cardId, @RequestBody Cart cart){
		cartDao.update(cardId, cart);
	}

	@RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cardId") String cardId){
		cartDao.delete(cardId);
	}

	@RequestMapping(value = "/add/{pId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable("pId") String pId, HttpServletRequest request){
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		if (cart == null){
			cart = cartDao.create(new Cart(sessionId));
		}

		Product product = productDao.getProductById(pId);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}

		cart.addCartItem(new CartItem(product));

		cartDao.update(sessionId, cart);
	}

	@RequestMapping(value = "/remove/{pId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("pId") String pId, HttpServletRequest request){
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		if (cart == null){
			cart = cartDao.create(new Cart(sessionId));
		}

		Product product = productDao.getProductById(pId);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}

		cart.removeCartItem(new CartItem(product));

		cartDao.update(sessionId, cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your status")
	public void handleClientError(Exception ex){}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
	public void handleServerError(Exception ex){}
}
