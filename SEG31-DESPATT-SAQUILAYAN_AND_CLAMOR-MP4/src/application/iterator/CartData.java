package application.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import application.utility.SingletonDB;
import cart.model.CartItemBean;

public class CartData implements ProductIterator{
	ArrayList<CartItemBean> cartData;
	
	
	private void addCartItem(String productName, String productPrice, int count, String productImgPath) {
		CartItemBean cartItem = new CartItemBean(productName,productPrice,count,productImgPath);
		cartData.add(cartItem);
	}
	
	public CartData() {
		cartData = new ArrayList<CartItemBean>();
		
		for(CartItemBean cartItem: SingletonDB.getCartItems()){ 
			addCartItem(cartItem.getProductName(), cartItem.getProductPrice(), cartItem.getCount(), cartItem.getProductImgPath());
		}
	}
	
	@Override
	public Iterator createIterator() {
		return cartData.iterator();
	}

}
