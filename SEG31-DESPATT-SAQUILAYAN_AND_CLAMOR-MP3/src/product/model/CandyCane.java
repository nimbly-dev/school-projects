package product.model;

import product.model.productType.ProductType;

public class CandyCane extends Product{

	//SETTERS
	@Override
	public void setProductId() {
		this.productId = 2;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Candy Cane";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 5000;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/candy-cane.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = false;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "A candy cane is a cane-shaped stick candy often "
				+ "associated with Christmastide, as well as Saint Nicholas Day. "
				+ "It is traditionally white with red stripes and flavored with peppermint, "
				+ "but they also come in a variety of other flavors and colors.";
	}
	@Override
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	//GETTERS
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
	

}
