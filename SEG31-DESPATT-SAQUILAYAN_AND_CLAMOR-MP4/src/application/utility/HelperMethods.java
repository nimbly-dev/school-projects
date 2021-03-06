package application.utility;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import application.utility.SingletonDB;
import product.model.Facade;

public class HelperMethods implements Facade{
	
	/**
	 * HELPER METHODS
	 * */
	
	//CreditCard Validation returns true if credit Card is valid

	
	private boolean luhnAlgorithmCreditCardChecker(String cardNo) {
		int nDigits = cardNo.length();
		 
	    int nSum = 0;
	    boolean isSecond = false;
	    for (int i = nDigits - 1; i >= 0; i--) {
	 
	        int d = cardNo.charAt(i) - '0';
	 
	        if (isSecond == true)
	            d = d * 2;
	 
	        // We add two digits to handle
	        // cases that make two digits 
	        // after doubling
	        nSum += d / 10;
	        nSum += d % 10;
	 
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}



	@Override
	public void PDFfunctions(String emailPDF, String shippingAddressPDF, String fullNamePDF, String emailSender, String passwordSender) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean checkCardLuhn(String cardNo) {
		return luhnAlgorithmCreditCardChecker(cardNo);
		
	}



	

	
	

	
}
