package payment.controller;

public class paymentInfoBean {
	
	String name;
	String email;
	String shipping;
	
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
	
	public paymentInfoBean(String name, String email, String shipping) {
		this.name = name;
		this.email = email;
		this.shipping = shipping;
	}
	
	public paymentInfoBean() {
		
	}
	

}