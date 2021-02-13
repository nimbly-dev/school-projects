package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.exceptions.ProductNotFoundException;
import product.model.*;
import product.view.*;
import product.model.productType.*;

import product.utility.Factory;
import product.utility.ProductTypeFactory;
import product.utility.SingletonDB;
import product.utility.ProductClone;


public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SingletonDB.initializeTablesAndConstraints();
		SingletonDB.populateDb();
		//Initialize Product object	
		String searchInput = request.getParameter("searchInput");

		
		
		//Create Helper Variables
		boolean isAvailableInBoolean = false;
		String isAvailableInString = "";
		String isProductExist = "";
		
		
		try {
//			product = (Product) new Factory().searchProduct(searchInput.toUpperCase());
//			ProductType productType = new ProductTypeFactory().getProductTypeName(searchInput);
			
			Product prototype = (Product) Factory.getProduct(searchInput.toUpperCase());
			ProductClone productType =  ProductTypeFactory.getProductType(searchInput);
			
			
			prototype.setProductType((ProductType) productType);
//			product.setProductType(productType);
			
			DisplayProducts.viewProductDetails((Product) prototype);
			
			
//			System.out.println("FOUND " + product.getProductName());
			//Convert Boolean to String
			isAvailableInBoolean = prototype.getAvailibility();
			isAvailableInString = convertToString(isAvailableInBoolean);
			
			//Create request Scope variables
			isProductExist = "FOUND";
			request.setAttribute("productExist", isProductExist);
			request.setAttribute("searchInput", searchInput);
			request.setAttribute("searchResult", prototype);
			request.setAttribute("isAvailable", isAvailableInString);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("search-result.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) { //Throws an product not found exception if there is no result

			System.out.println("PRODUCT NOT FOUND");
			request.setAttribute("productExist", isProductExist);
			isProductExist = "NOT_FOUND";
			
			request.setAttribute("searchInput", searchInput);
			RequestDispatcher dispatcher = request.getRequestDispatcher("search-result.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
		

	}
	
	
	public String convertToString(boolean toBeConverted) {
		if(toBeConverted == true) {return "true";} else{return "false";}
	}
	

}
