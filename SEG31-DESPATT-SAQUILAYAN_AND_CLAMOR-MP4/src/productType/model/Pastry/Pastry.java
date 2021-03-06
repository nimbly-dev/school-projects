package productType.model.Pastry;

import application.utility.ProductPrototype;
import packaging.model.PastryWrapper;
import packaging.model.Wrapper;
import productType.model.ProductType;
import productType.model.ProductTypeItem;
import productType.model.Cupcake.Cupcake;

public class Pastry extends ProductType implements ProductPrototype, ProductTypeItem{
	
	
	
    @Override
    public Pastry clone() {
        return new Pastry();
    }

	@Override
	public int productTypeId() {
		return 3;
	}

	@Override
	public String productTypeName() {
		return "Pastry";
	}

	@Override
	public Wrapper wrapper() {
		return (Wrapper) new PastryWrapper();
	}
}
