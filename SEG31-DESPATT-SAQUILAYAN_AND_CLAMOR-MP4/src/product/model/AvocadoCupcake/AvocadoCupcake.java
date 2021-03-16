package product.model.AvocadoCupcake;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;
import productType.model.Cupcake.Cupcake;

public class AvocadoCupcake extends Product implements ProductPrototype{
	
	int count = 20;
	
	@Override
    public AvocadoCupcake clone() {
        return new AvocadoCupcake();
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
		return "Avocado Cupcake";
	}

	@Override
	public String imgPath() {
		return "images/products/avocado-biscuit-cupcake.PNG";
	}

	@Override
	public String productInfo() {
		return "Avocado and coconut oil give these simple and "
				+ "delicious Avocado Cupcakes with Whipped Avocado "
				+ "Cream a healthier upgrade – making them perfect for "
				+ "a celebratory dessert AND breakfast – or maybe that’s just for me?!";
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
		return count;
	}

	@Override
	public void setCount(int count) {
		
		this.count = count;
		
	}

	
	
}
