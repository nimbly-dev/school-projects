package product.model.PuffedDanishPastry;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Pastry.Pastry;

public class PuffedDanishPastry extends Product implements ProductPrototype{
	
	
	
	//CLONING
	@Override
	public PuffedDanishPastry clone() {
		return new PuffedDanishPastry();
	}

	@Override
	public int productTypeID() {
		return 3;
	}

	@Override
	public int productId() {
		return 0;
	}

	@Override
	public String productName() {
		return "Puffed Pastry Cream Bread";
	}

	@Override
	public String imgPath() {
		return "images/products/puff-sweetflatbread-pastry.jpg";
	}

	@Override
	public String productInfo() {
		return "These cream cheese danish are a light and flaky pastry topped "
				+ "with a sweet cream cheese filling and fruit."
				+ " An easy yet elegant breakfast option!";
	}

	@Override
	public double productPrice() {
		return 75.00;
	}


	@Override
	public ProductType productType() {
		return new Pastry();
	}
	
	@Override
	public int quantity() {
		return 20;
	}
}
