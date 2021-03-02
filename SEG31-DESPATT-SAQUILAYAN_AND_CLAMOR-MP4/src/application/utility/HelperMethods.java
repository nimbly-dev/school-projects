package application.utility;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import application.utility.SingletonDB;

public class HelperMethods {
	
	/**
	 * HELPER METHODS
	 * */
	public static void productListToJson(String userPath) {
		Gson gson = new Gson();
		try {
			FileWriter fileWriter = new FileWriter(userPath);
			gson.toJson(SingletonDB.getAllProducts(), fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//CreditCard Validation returns true if credit Card is valid
	public static boolean luhnAlgorithmCreditCardChecker(String cardNo){
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
	
	
}
