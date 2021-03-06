package productType.model;

import java.io.Serializable;
import java.util.Set;

import packaging.model.Wrapper;
import product.model.Product;


public abstract class ProductType implements Serializable, ProductTypeItem{
	
	private static final long serialVersionUID = 3318159181770952359L;

   public abstract Wrapper wrapper();

}
