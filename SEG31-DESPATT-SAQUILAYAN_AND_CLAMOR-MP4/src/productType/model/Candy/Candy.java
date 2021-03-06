package productType.model.Candy;

import application.utility.ProductPrototype;
import packaging.model.CandyWrapper;
import packaging.model.Wrapper;
import productType.model.ProductType;
import productType.model.ProductTypeItem;

public class Candy extends ProductType implements ProductPrototype, ProductTypeItem{
	
	
	@Override
    public Candy clone() {
        return new Candy();
    }

	@Override
	public int productTypeId() {
		return 1;
	}

	@Override
	public String productTypeName() {
		return "Candy";	
	}

	@Override
	public Wrapper wrapper() {
		return (Wrapper) new CandyWrapper();
	}
    
 
    
}
