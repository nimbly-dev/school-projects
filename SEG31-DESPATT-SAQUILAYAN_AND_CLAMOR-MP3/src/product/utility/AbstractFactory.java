package product.utility;

import product.model.productType.ProductType;
import product.exceptions.ProductNotFoundException;
import product.model.Product;

public interface AbstractFactory {
	
	ProductType getProductTypeName(String productInput);
//	Product searchProduct(String searchInput) throws ProductNotFoundException;
}
