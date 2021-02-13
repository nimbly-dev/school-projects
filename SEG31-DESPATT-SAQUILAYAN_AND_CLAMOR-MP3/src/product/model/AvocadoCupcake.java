package product.model;

import product.model.productType.ProductType;
import product.utility.ProductClone;

public class AvocadoCupcake extends Product implements ProductClone{

	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 1;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Avocado Cupcake";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 10000;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/avocado-biscuit-cupcake.PNG";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = true;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "Avocado and coconut oil give these simple and "
				+ "delicious Avocado Cupcakes with Whipped Avocado "
				+ "Cream a healthier upgrade – making them perfect for "
				+ "a celebratory dessert AND breakfast – or maybe that’s just for me?!";
	}
	@Override
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
	//Getters
	@Override
	public int getProductId() {
		return productId;
	}
	
	@Override
	public String getProductName() {
		return productName;	
	}
	@Override
	public double getProductPrice() {
		return productPrice;
	}
	@Override
	public String getImgPath() {
		return imgPath;
	}
	@Override
	public boolean getAvailibility() {
		return isAvailable;
	}
	@Override
	public String getProductInfo() {
		return productInfo;
	}
	@Override
	public ProductType getProductType() {
		return productType;
	}

	
	//CLONING
	@Override
	public ProductClone clone() {
		return new AvocadoCupcake();
	}
	
	
	
	

}
