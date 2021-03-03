package application.utility;

import java.sql.Connection;

import product.exceptions.ProductNotFoundException;
import product.model.Product;
import productType.model.DisplayProductTypeBean;
import productType.model.ProductType;

public interface AbstractFactory {
	ProductType getProductTypeName(String productInput);
    Connection getConnectionObject(String searchInput)throws ProductNotFoundException;
}
