package product.model.ChurroSticks;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Pastry.Pastry;

public class ChurroSticks extends Product implements ProductPrototype{
	
	
	//CLONING
	@Override
	public ChurroSticks clone() {
		return new ChurroSticks();
	}

	@Override
	public int productTypeID() {
		return 3;
	}

	@Deprecated
	@Override
	public int productId() {
		return 0;
	}

	
	@Override
	public String productName() {
		return "Churro Sticks";
	}

	@Override
	public String imgPath() {
		return "images/products/churro-sticks.jpg";
	}

	@Override
	public String productInfo() {
		return "A pastry originating in Spain, that is basically "
				+ "fried dough extruded through a fluted tube, resulting in a star "
				+ "shaped stick that is cut to a desired length. ";
	}

	@Override
	public double productPrice() {
		return 15.00;
	}

	@Override
	public boolean isAvailable() {
		return false;
	}

	@Override
	public ProductType productType() {
		return new Pastry();
	}
	
	@Override
	public int quantity() {
		return 0;
	}
	
}
