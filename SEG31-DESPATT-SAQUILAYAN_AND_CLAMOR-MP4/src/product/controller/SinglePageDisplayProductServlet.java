package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.utility.*;
import product.exceptions.ProductNotFoundException;
import product.model.*;
import productType.model.ProductType;

public class SinglePageDisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String selectedProductName = request.getParameter("selectedProduct");
		System.out.println(selectedProductName);
		try {
			DisplayProductBean product = SingletonDB.getProduct(selectedProductName);
			ProductType productType = SingletonDB.getProductType(product.getProductTypeID());
			
			product.setProductType(productType);
			
			System.out.println("PRODUCT TYPE: " + product.getProductType());
			System.out.println("PRODUCT TYPE NAME: " + product.getProductType().getProductTypeName());
			request.setAttribute("displayDetails", product);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("single-page.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {// Throws an ProductNotFoundException if product failed to load
			System.out.println("NULL POINTER, PRODUCT DID NOT DISPLAYED");
			 
			request.setAttribute("displayDetails", null);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
