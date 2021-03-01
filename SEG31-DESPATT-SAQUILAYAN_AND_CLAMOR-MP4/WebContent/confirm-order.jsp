<%@page import="cart.model.CartItemBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "application.utility.SingletonDB" %>
<%!	
	String displayAllUrl = "display-products.action?selectedProductType=All";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheets/bootstrap4-bubblegum.min.css">
    <link rel="stylesheet" href="stylesheets/stylesheet.min.css">
    <link rel="icon" href="images/icon/favicon.png" type="image/png">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <title>Sweetx</title>
</head>

<body>
    <header>
        <nav class="navbar fixed-top navbar-expand-md ht-tm-element navbar-dark bg-danger">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <img src="images/icon/Sweetx.png">
            <a class="navbar-brand" href="#!">Sweetx</a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-md-0">
                    <li class="nav-item active" id="home">
                        <a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                       <a class="submit nav-link" href="<%=displayAllUrl%>">Browse Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#product-cart">Cart</a>
                    </li>
                </ul>
                <form action='search-product.action' method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group ui-widget">
                        <input class="form-control mr-sm-2 typeahead tt-query" type="text" name="searchInput"
                            autocomplete="off" placeholder="Enter Something!">
                        <button type="submit" class="ht-tm-element btn btn-warning">Search</button>
                    </div>
                </form>
            </div>
        </nav>
    </header>
    
   	<%-- GETS THE CART COMPONENT --%>
	<jsp:include page="view/cart-component.jsp"/>
    
    
   	<%-- CONFIRM ORDER COMPONENT --%>
    <main>
        <section class="confirm-order">
            <div class="row d-flex justify-content-center">
                <div class="container fluid m-sm-5">
                    <div class="card ">
                        <div class="card-body">
                            <div class="d-flex flex-wrap align-content-center">

                                <h4>Your order is as follows: </h4>
								
                                <table class="table table-borderless">
                                    <thead>
                                        <tr class="d-flex flex-wrap align-content-start">
                                            <th style="margin-right: 16rem;"></th>
                                            <th style="margin-right: 9rem;">Product</th>
                                            <th style="margin-left: 5rem;">Price</th>
                                            <th style="margin-left: 10rem;">Count</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%for(CartItemBean cartItem: SingletonDB.getCartItems()){ %>
                                        <tr class="d-flex align-items-center">
                                            <th>
                                                <img src="<%=cartItem.getProductImgPath()%>" style="width: 8rem;
                                                height: 8rem;" alt="NOT FOUND">
                                            </th>
                                            <th scope="row" style="margin-left: 5rem;"><%=cartItem.getProductName() %></th>
                                            <td style="margin-left: 12rem;"><%=cartItem.getProductPrice() %></td>
                                            <td style="margin-left: 9rem;"><%=cartItem.getCount() %></td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>

                                <div class="row">
                                    <div class="col">
                                        <span style="margin-left: 45rem;">Total Price: P <%=session.getAttribute("totalPrice") %> </span>
                                    </div>
                                </div>

                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col">
                                            <button type="button" class="btn btn-warning"
                                                style="margin-left: 45rem;">Cancel
                                            </button>
                                            <button type="button" class="btn btn-danger ml-3">Proceed
                                                Order</button>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main> 
    
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/bloodhound.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script>
    <script src="javascript/assets/cart.js"></script>
    <script src="javascript/assets/product-list.js"></script>
    <script src="javascript/assets/autocomplete.js"></script>
</html>