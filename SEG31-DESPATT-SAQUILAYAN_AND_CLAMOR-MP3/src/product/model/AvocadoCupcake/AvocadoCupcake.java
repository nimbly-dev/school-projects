package product.model.AvocadoCupcake;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class AvocadoCupcake extends Product implements ProductPrototype{

	//Setters
	@Override
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
		this.productName = productName;
//		productName = "Avocado Cupcake";
	}	
	@Override
	public void setProductPrice(double productPrice) {
//		 productPrice = 10000;
		this.productPrice = productPrice;
	}
	@Override
	public void setImgPath(String imgPath) {
//		imgPath = "images/products/avocado-biscuit-cupcake.PNG";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailable) {
//		isAvailable = true;
		this.isAvailable = isAvailable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		productInfo = "Avocado and coconut oil give these simple and "
//				+ "delicious Avocado Cupcakes with Whipped Avocado "
//				+ "Cream a healthier upgrade – making them perfect for "
//				+ "a celebratory dessert AND breakfast – or maybe that’s just for me?!";
		this.productInfo = productInfo;
	}
	@Override
	public void setProductType(ProductType productType){
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
    public AvocadoCupcake clone() {
        return new AvocadoCupcake();
    }
	

}
