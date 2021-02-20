package product.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{

//	private static final long serialVersionUID = 7109732604573845831L;
	public ProductNotFoundException(String message){
		super(message);
	}
	
}
