package productType.model.Cupcake;

import application.utility.ProductPrototype;
import packaging.model.CupcakeWrapper;
import packaging.model.Wrapper;
import productType.model.ProductType;
import productType.model.ProductTypeItem;

public class Cupcake extends ProductType implements ProductPrototype, ProductTypeItem{

	
    @Override
    public Cupcake clone() {
        return new Cupcake();
    }

	@Override
	public int productTypeId() {
		return 2;
	}

	@Override
	public String productTypeName() {
		return "Candy";
	}

	@Override
	public Wrapper wrapper() {
		return (Wrapper) new CupcakeWrapper();
	}
}
