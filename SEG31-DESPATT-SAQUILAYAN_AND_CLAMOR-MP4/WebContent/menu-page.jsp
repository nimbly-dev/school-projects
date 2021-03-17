<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	String displayAllUrl = "display-products.action?selectedProductType=All";
%>
<%@ page import = "application.utility.SingletonDB" %>
<%@ page import = "product.model.DisplayProductBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheets/bootstrap4-bubblegum.min.css">
    <link rel="stylesheet" href="stylesheets/stylesheet.min.css">
    <link rel="icon" href="images/icon/favicon.png" type="image/png">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
<title>This will be the menu page for the website</title>
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
                       <a class="submit nav-link" href="menu-page.jsp">Our Bundles</a>
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
               
            </div>
        </nav>
    </header>
    <!--   process-cart.action?clickedCancelOrder=placeholder -->
   <main>
        <section class="product-list">
       
		 <div class="row">
		    <div class="d-inline-flex flex-wrap justify-content-between">
		   		<div class="col mt-5">
		            <div class="card" style="width: 18rem;">
		                <img src="images/products/assorted-cupcakes.jpg" class="card-img-top" alt="...">
		                <div class="card-body">
		                    <h5 class="card-title">Assorted Cupcake</h5>
		                    <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
		                    <h4>Price: 250</h4>
		                    <form action='process-bundled-order.action?clickedCancelOrder=false' method='POST'>
		                    	<input type="hidden" name="selectedBundle" value="orderAllCupcakeBundle">
		                        <input type="hidden" name="totalPrice" value="200">
		                        <input type="hidden" name="totalQuantity" value="9">
		     					<!-- ADD TO CART BUTTON -->
		                        <button type="submit" 
		                        onclick='orderMenuAllCupcake()'s
		                        class="btn btn-warning mt-2">
		                        Add to cart
		                        </button>
		                        <h5 class="card-title">An Assortment of our delicious cupcakes. Three of each.</h5>
		                        
		                    	</form>
		               		 </div>
		           		 </div>
		       		</div>
		   		 </div>
		   </div>
  
        </section>
    </main>
    
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/bloodhound.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script>
  	<script src="javascript/assets/cart.js"></script>
    <script src="javascript/assets/autocomplete.js"></script>
    

</body>
</html>