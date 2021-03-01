package productType.model;

import java.io.Serializable;
import java.util.Set;




import product.model.Product;


public abstract class ProductType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3318159181770952359L;


	protected int productTypeId;
	

	protected String productTypeName; 
	
	
    
	public abstract int getProductTypeId();
	public abstract String getProductTypeName();
	
	public abstract void setProductTypeId(int productTypeId);
	public abstract void setProductTypeName(String productTypeName);
}
