<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "application.utility.SingletonDB" %>
<%@ page import = "product.model.DisplayProductBean" %>
<div class="row">
    <div class="d-inline-flex flex-wrap justify-content-between">
        <!-- PRODUCTS DISPLAY HERE -->
        <%
        for (DisplayProductBean product : SingletonDB.getProductList(
                (String) request.getParameter("selectedProductType"))) {
    	%>
        <%if (product.getAvailibility() == true){ %>
        <div class="col mt-5">
            <div class="card" style="width: 18rem;">
                <img src="<%= product.getImgPath() %>" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><%=product.getProductName() %></h5>
                    <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
                    <h4>Price: <%= product.getProductPrice() %></h4>
                    <form action='display-single-product.action' method='POST'>
                        <input type="hidden" name="selectedProduct" value="<%= product.getProductName() %>">
                        <button type="submit" class="btn btn-danger mt-2">Take a look</button>
     					<!-- ADD TO CART BUTTON -->
                        <button type="button" 
                        onclick='addToCart(this)'
                        class="btn btn-warning mt-2" 
                        data-productname="<%=product.getProductName() %>"
                        data-productprice="<%=product.getProductPrice()%>"
                        data-productimgpath="<%=product.getImgPath()%>">
                        Add to cart
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <%}else{ %>
        <div class="col mt-5">
            <div class="card" style="width: 18rem;">
                <img src="<%= product.getImgPath() %>" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><%=product.getProductName() %></h5>
                    <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
                    <h4>Price: <%= product.getProductPrice() %></h4>
                </div>
            </div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>