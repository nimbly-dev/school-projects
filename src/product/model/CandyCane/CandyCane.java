package product.model.CandyCane;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class CandyCane extends Product implements ProductPrototype{

	
	//CLONING
	@Override
	public CandyCane clone() {
		return new CandyCane();
	}

	@Override
	public int productTypeID() {
		return 0;
	}

	@Deprecated
	@Override
	public int productId() {
		return 0;
	}

	@Override
	public String productName() {
		return "Candy Cane";
	}

	@Override
	public String imgPath() {
		return "images/products/candy-cane.jpg";
	}

	@Override
	public String productInfo() {
		return "A candy cane is a cane-shaped stick candy often "
				+ "associated with Christmastide, as well as Saint Nicholas Day. "
				+ "It is traditionally white with red stripes and flavored with peppermint, "
				+ "but they also come in a variety of other flavors and colors.";
	}

	@Override
	public double productPrice() {
		return 10.00;
	}

	@Override
	public boolean isAvailable() {
		return false;
	}

	@Override
	public ProductType productType() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
