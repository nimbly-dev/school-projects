package product.model;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;

public interface Facade {
	
	
	//generate and Mail PDF receipt
	public void PDFfunctions();
	
	
	//check if card is valid
	public boolean checkCardLuhn(String cardNo);
	
}