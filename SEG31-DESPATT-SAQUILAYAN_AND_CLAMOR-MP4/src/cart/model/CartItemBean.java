package cart.model;

public class CartItemBean {
	private String productName;
	private String productPrice;
	private String count;
	private String productImgPath;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getProductImgPath() {
		return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}
	
	public CartItemBean(String productName, String productPrice, String count, String productImgPath) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.count = count;
		this.productImgPath = productImgPath;
	}
	
	public CartItemBean() {
	}
	
	
}
