package product.model.StrawberryCupcake;


import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Cupcake.Cupcake;

public class StrawberryCupcake extends Product implements ProductPrototype{
	
	
	//CLONING
	@Override
	public StrawberryCupcake clone() {
		return new StrawberryCupcake();
	}

	@Override
	public int productTypeID() {
		return 2;
	}

	@Deprecated
	@Override
	public int productId() {
		return 0;
	}

	@Override
	public String productName() {
		return "Strawberry Cupcake";
	}

	@Override
	public String imgPath() {
		return "images/products/strawberry-cupcake.jpg";
	}

	@Override
	public String productInfo() {
		return "Strawberry Cupcake for everyone!";
	}

	@Override
	public double productPrice() {
		return 25.00;
	}


	@Override
	public ProductType productType() {
		return new Cupcake();
	}
	
	@Override
	public int quantity() {
		return 20;
	}
}
