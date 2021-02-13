package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.exceptions.ProductNotFoundException;
import product.model.*;
import product.model.productType.ProductType;
import product.utility.*;
import product.view.DisplayProducts;

public class SinglePageDisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = null;
		String selectedProductName = request.getParameter("selectedProduct");
		System.out.println(selectedProductName);
		try {
			Product prototype = (Product) Factory.getProduct(selectedProductName.toUpperCase());
			ProductClone productType =  ProductTypeFactory.getProductType(selectedProductName);
			
			
			prototype.setProductType((ProductType) productType);
			DisplayProducts.viewProductDetails((Product) prototype);
			
			System.out.println(prototype.getProductType().getProductTypeName());
			
			request.setAttribute("displayDetails", prototype);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("single-page.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {// Throws an ProductNotFoundException if product failed to load
			System.out.println("NULL POINTER, PRODUCT DID NOT DISPLAYED");
			 
			request.setAttribute("displayDetails", null);
			RequestDispatcher dispatcher = request.getRequestDispatcher("single-page.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
