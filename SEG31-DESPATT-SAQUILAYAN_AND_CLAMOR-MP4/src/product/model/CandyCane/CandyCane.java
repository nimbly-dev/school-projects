package product.model.CandyCane;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class CandyCane extends Product implements ProductPrototype{

	//SETTERS
	@Override
	public void setProductId(int productId) {
//		this.productId = 2;
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
		this.productName = productName;
//		this.productName = "Candy Cane";
	}	
	@Override
	public void setProductPrice(double productPrice) {
//		 this.productPrice = 5000;
		 this.productPrice = productPrice;
	}
	@Override
	public void setImgPath(String imgPath) {
//		this.imgPath = "images/products/candy-cane.jpg";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailable) {
//		this.isAvailable = false;
		this.isAvailable = isAvailable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		this.productInfo = "A candy cane is a cane-shaped stick candy often "
//				+ "associated with Christmastide, as well as Saint Nicholas Day. "
//				+ "It is traditionally white with red stripes and flavored with peppermint, "
//				+ "but they also come in a variety of other flavors and colors.";
		this.productInfo = productInfo;
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
	
	//CLONING
	@Override
	public CandyCane clone() {
		return new CandyCane();
	}
	

}
