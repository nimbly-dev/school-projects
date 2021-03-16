package product.model.JellyBeans;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Candy.Candy;

public class JellyBeans extends Product implements ProductPrototype{
	
	
	int count = 20;
	//CLONING
	@Override
	public JellyBeans clone() {
		return new JellyBeans();
	}

	@Override
	public int productTypeID() {
		return 1;
	}

	@Deprecated
	@Override
	public int productId() {
		return 0;
	}

	@Override
	public String productName() {
		return "Jelly Beans";
	}

	@Override
	public String imgPath() {
		return "images/products/jelly-beans.jpg";
	}

	@Override
	public String productInfo() {
		return "Jelly beans are small bean-shaped sugar candies with soft candy shells and thick gel interiors "
				+ ". The confection is primarily made of "
				+ "sugar and sold in a wide variety of colors and flavors.";
	}

	@Override
	public double productPrice() {
		return 15.00;
	}

	@Override
	public ProductType productType() {
		return new Candy();
	}

	@Override
	public int quantity() {
		return count;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
		
	}

	
}
