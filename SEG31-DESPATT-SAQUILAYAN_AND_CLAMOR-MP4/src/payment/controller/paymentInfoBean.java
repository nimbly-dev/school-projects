package payment.controller;

public class PaymentInfoBean {
	
	String name;
	String email;
	String shipping;
	String totalPrice;
	
	
	
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	
	public PaymentInfoBean(String name, String email, String shipping, String totalPrice) {
		this.name = name;
		this.email = email;
		this.shipping = shipping;
		this.totalPrice = totalPrice;
	}
	
	
	
	public PaymentInfoBean() {
		
	}
	

}
