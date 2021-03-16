package product.model.ValentineCupcake;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class ValentineCupcake extends Product implements ProductPrototype{
	
	int count = 20;
	
	//CLONING
	@Override
	public ValentineCupcake clone() {
		return new ValentineCupcake();
	}

	@Override
	public int productTypeID() {
		return 2;
	}

	@Override
	public int productId() {
		return 0;
	}

	@Override
	public String productName() {
		return "Valentine Cupcake";
	}

	@Override
	public String imgPath() {
		return "images/products/valentine-cupcake.jpg";
	}

	@Override
	public String productInfo() {
		return "Valentine themed Cupcake for loved ones!";
	}

	@Override
	public double productPrice() {
		return 30.00;
	}

	@Override
	public ProductType productType() {
		return null;
	}
	
	@Override
	public int quantity() {
		return count;
	}

	@Override
	public void setCount(int count) {
		// TODO Auto-generated method stub
		this.count = count;
	}


}
