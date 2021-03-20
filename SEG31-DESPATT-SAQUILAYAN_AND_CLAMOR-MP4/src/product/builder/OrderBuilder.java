package product.builder;

import product.model.AvocadoCupcake.AvocadoCupcake;
import product.model.EnglishSausage.EnglishSausage;
import product.model.JellyBeans.JellyBeans;
import product.model.PuffedDanishPastry.PuffedDanishPastry;
import product.model.StrawberryCupcake.StrawberryCupcake;
import product.model.ValentineCupcake.ValentineCupcake;

public class OrderBuilder {
	
	
	/**
	 * BUNDLE NAME = All Cupcake Bundle
	 * TOTAL QTY = 9
	 * TOTAL PRICE = 200
	 * */
	public Order prepareAllCupcakeOrder() {
		AvocadoCupcake avocadoCupcake = new AvocadoCupcake();
		avocadoCupcake.setCount(3);
		ValentineCupcake valentineCupcake = new ValentineCupcake();
		valentineCupcake.setCount(3);
		StrawberryCupcake strawberryCupcake = new StrawberryCupcake();
		strawberryCupcake.setCount(3);
		Order order = new Order();
		order.addItem(avocadoCupcake);
		order.addItem(valentineCupcake);
		order.addItem(strawberryCupcake);
		
		return order;
	}
	
	/**
	 * BUNDLE NAME = All Pastry Bundle
	 * TOTAL QTY = 10
	 * TOTAL PRICE = 499
	 * */
	public Order prepareAllPastryOrder() {
		Order order = new Order();
		PuffedDanishPastry puffedDanishPastry = new PuffedDanishPastry();
		puffedDanishPastry.setCount(5);
		EnglishSausage englishSausage = new EnglishSausage();
		englishSausage.setCount(5);
		order.addItem(puffedDanishPastry);
		order.addItem(englishSausage);
		
		return order;
	}
	
	/**
	 * BUNDLE NAME = Jelly Beans Mania Bundle
	 * TOTAL QTY = 10
	 * TOTAL PRICE = 99	
	 * */
	public Order prepareJellyBeansMania() {
		Order order = new Order();
		JellyBeans jellyBeans = new JellyBeans();
		jellyBeans.setCount(10);
		order.addItem(jellyBeans);
		
		return order;
	}
}
