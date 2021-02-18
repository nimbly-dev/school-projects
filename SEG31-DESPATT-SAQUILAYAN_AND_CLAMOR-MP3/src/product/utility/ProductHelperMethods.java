package product.utility;

import java.io.FileWriter;
import java.io.IOException;

import product.utility.SingletonDB;

import com.google.gson.Gson;

public class ProductHelperMethods {
	
	/*CLIENT SIDE Array Product List to JSON file Format
	 *
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
}
