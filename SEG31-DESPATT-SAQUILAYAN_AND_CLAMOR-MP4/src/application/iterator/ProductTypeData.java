package application.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import packaging.model.Wrapper;
import productType.model.DisplayProductTypeBean;
import productType.model.Candy.Candy;
import productType.model.Cupcake.Cupcake;
import productType.model.Pastry.Pastry;

public class ProductTypeData implements ProductIterator{
	ArrayList<DisplayProductTypeBean> productTypeData;
	
	public ProductTypeData(){
		productTypeData = new ArrayList<DisplayProductTypeBean>();
		
		//Declaration of Product and ProductType Class
		Candy candyProductType = new Candy().clone();
		Cupcake cupcakeProductType = new Cupcake().clone();
		Pastry pastryProductType = new Pastry().clone();
		
		
		//ID- 1
		addProductType(candyProductType.productTypeId(), candyProductType.productTypeName(), candyProductType.wrapper().wrap());
		
		//ID- 2
		addProductType(cupcakeProductType.productTypeId(), cupcakeProductType.productTypeName(), cupcakeProductType.wrapper().wrap());
		
		//ID- 3
		addProductType(pastryProductType.productTypeId(), pastryProductType.productTypeName(), pastryProductType.wrapper().wrap());

	}
	
	public void addProductType(int productTypeID, String productTypeName, String wrap) {
		DisplayProductTypeBean productType = new DisplayProductTypeBean(productTypeID, productTypeName, wrap);
		productTypeData.add(productType);
	}

	public Iterator createIterator() {
		return productTypeData.iterator();
	}
}
