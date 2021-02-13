package product.model.productType;

import java.io.Serializable;
import java.util.Set;




import product.model.Product;


public abstract class ProductType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3318159181770952359L;


	int productTypeId;
	

	String productTypeName; 
	
	
    
    public abstract int getProductTypeId();
	public abstract String getProductTypeName();
	
	public abstract void setProductTypeId();
	public abstract void setProductTypeName();
}
