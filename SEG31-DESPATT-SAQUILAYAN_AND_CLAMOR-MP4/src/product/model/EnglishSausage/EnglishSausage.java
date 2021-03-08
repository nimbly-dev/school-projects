package product.model.EnglishSausage;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Pastry.Pastry;

public class EnglishSausage extends Product implements ProductPrototype{

	
	//CLONING
	@Override
	public EnglishSausage clone() {
		return new EnglishSausage();
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
		return "English Sausage";
	}

	@Override
	public String imgPath() {
		return "images/products/English-Sausage.jpg";
	}

	@Override
	public String productInfo() {
		return "Savory pork sausage wrapped in puff pastry, "
				+ "baked to golden brown perfection. This sausage rolls recipe is the perfect"
				+ "make-ahead appetizer, sausage rolls are delicious served hot or cold. ";
	}

	@Override
	public double productPrice() {
		return 60.00;
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
