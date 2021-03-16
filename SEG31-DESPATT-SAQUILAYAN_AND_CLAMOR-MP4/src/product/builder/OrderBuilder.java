package product.builder;

import product.model.DisplayProductBean;
import product.model.AvocadoCupcake.AvocadoCupcake;
import product.model.CandyCane.CandyCane;
import product.model.ChurroSticks.ChurroSticks;
import product.model.EnglishSausage.EnglishSausage;
import product.model.JellyBeans.JellyBeans;
import product.model.PuffedDanishPastry.PuffedDanishPastry;
import product.model.StrawberryCupcake.StrawberryCupcake;
import product.model.ValentineCupcake.ValentineCupcake;

public class OrderBuilder {
	
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
	
	public Order prepareAllPastryOrder() {
		Order order = new Order();
		order.addItem(new PuffedDanishPastry());
		order.addItem(new EnglishSausage());
		order.addItem(new ChurroSticks());
		
		return order;
	}
	
	public Order prepareAllCandyOrder() {
		Order order = new Order();
		order.addItem(new CandyCane());
		order.addItem(new JellyBeans());
		
		return order;
	}
}
