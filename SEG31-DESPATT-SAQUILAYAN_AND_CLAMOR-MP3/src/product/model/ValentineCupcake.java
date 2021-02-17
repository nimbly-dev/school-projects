package product.model;

import product.model.productType.ProductType;
import product.utility.ProductClone;

public class ValentineCupcake extends Product implements ProductClone{
	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 1;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Valentine Cupcake";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 123;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/valentine-cupcake.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = false;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "Valentine themed  Cupcake for loved ones!";
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
	
	@Override
	public ProductClone clone() {
		return new ValentineCupcake();
	}
}
