package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import application.utility.ProductTypeFactory;
import application.utility.SingletonDB;
import product.exceptions.ProductNotFoundException;
import product.model.*;
import productType.model.*;


public class SearchProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Initialize Product object	
		String searchInput = request.getParameter("searchInput");
		
		//Create Helper Variables
		boolean isAvailableInBoolean = false;
		String isAvailableInString = "";
		String isProductExist = "";
		
		try {
			DisplayProductBean product = SingletonDB.getProduct(searchInput);
			ProductType productType =  SingletonDB.getProductType(product.getProductTypeID());
			
			product.setProductType(productType);
			
			//Convert Boolean to String
			isAvailableInBoolean = product.getAvailibility();
			isAvailableInString = convertToString(isAvailableInBoolean);
			
			
			//Create request Scope variables
			isProductExist = "FOUND";
			request.setAttribute("productExist", isProductExist);
			request.setAttribute("searchInput", searchInput);
			request.setAttribute("searchResult", product);
			request.setAttribute("isAvailable", isAvailableInString);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("search-result.jsp");
			dispatcher.forward(request, response);
		} catch (NullPointerException | ProductNotFoundException e) { //Throws an product not found exception if there is no result
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
