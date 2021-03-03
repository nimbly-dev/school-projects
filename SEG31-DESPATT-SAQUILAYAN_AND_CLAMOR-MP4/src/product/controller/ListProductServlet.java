package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedTypeOfProduct = request.getParameter("selectedProductType");
	
		try {
			if(selectedTypeOfProduct.equals("Candy")){
				request.setAttribute("selectedProductSort", "Candy");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=Candy");
				dispatcher.forward(request, response);
			}else if(selectedTypeOfProduct.equals("Cupcake")){
				request.setAttribute("selectedProductSort", "Cupcake");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=Cupcake");
				dispatcher.forward(request, response);
			}else if(selectedTypeOfProduct.equals("Pastry")){
				request.setAttribute("selectedProductSort", "Pastry");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=Pastry");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("selectedProductSort", "All");;
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=All");
				dispatcher.forward(request, response);
			}
		}catch(NullPointerException npe) {
			npe.getStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
