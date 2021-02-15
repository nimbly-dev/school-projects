<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page autoFlush="true"  import = "product.utility.SingletonDB" %>
<%@ page autoFlush="true" import = "product.view.DisplayProductBean" %>

<%! 
	//Servlet URLs for product sorting
	String displayAllUrl = "product-list.jsp?selectedProductType=All";
	String displayCupcakeUrl = "product-list.jsp?selectedProductType=Cupcake";
	String displayCandyUrl = "product-list.jsp?selectedProductType=Candy";
	String displayPastryUrl = "product-list.jsp?selectedProductType=Pastry";
	
	//Helper Boolean variables for UI
	boolean isSelectedAll = false;
	boolean isSelectedCupcake = false;
	boolean isSelectedCandy = false;
	boolean isSelectedPastry = false;
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
    <title>Product List</title>
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
                    <li class="nav-item" id="home">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="product-list.jsp">Browse Products<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">Cart</a>
                    </li>
                </ul>
                <form action='search-product.action' method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group">
                        <input class="form-control mr-sm-2 typeahead tt-query" autocomplete="off" type="text"
                            name="searchInput" placeholder="Find some sweets!">
                        <button type="submit" class="ht-tm-element btn btn-warning">Search</button>
                    </div>
                </form>
            </div>
        </nav>
    </header>

    <main>
        <section class="product-list">
            <div class="contrainer fluid m-sm-5 ">
            
                <div class="card">
                
                    <div class="card-body">
                    
                        <div class="row">
                            <div class='col'>
                                <nav aria-label="breadcrumb ">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item active" aria-current="page">All</li>
                                        <li class="breadcrumb-item"><a href="#WIP">Cupcake</a></li>
                                        <li class="breadcrumb-item"><a href="#WIP">Pastry</a></li>
                                        <li class="breadcrumb-item"><a href="#WIP">Candy</a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>

                        <div class="row">
	                        <div class="d-inline-flex flex-wrap justify-content-between">
		                    <!-- PRODUCTS DISPLAY HERE -->
		                    <%
		                    	for (DisplayProductBean product : SingletonDB.displayAllProducts()) {
		                    %>
		                        <%if (product.isAvailable() == true){ %>
		                        <div class="col mt-5">
			                        <div class="card" style="width: 18rem;">
			                        <img src="<%= product.getImgPath() %>" class="card-img-top" alt="...">
				                        <div class="card-body">
				                            <h5 class="card-title"><%=product.getProductName() %></h5>
				                            <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
				                            <h4>Price: <%= product.getProductPrice() %></h4>
				                            <form action='display-single-product.action' method='POST'>
				                                <input type="hidden" name="selectedProduct" value="<%= product.getProductName() %>" >
				                                <button type="submit" class="btn btn-danger mt-2">Take a look</button>
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
					                            <form action='display-single-product.action' method='POST'>
					                                <input type="hidden"  name='selectedProduct' value='<%= product.getProductName() %>' >
					                                <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
					                            </form>
					                        </div>
			                    		</div>
			                    	</div>
			              	        <%} %>
			              	   <%} %>
		                     </div>
                         </div>
                         <!-- END OF INNER CARD BODY -->
                     </div>
                     <!-- END OF INNER CARD  -->
                </div>
            </div>
        </section>
    </main>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/bloodhound.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script>
  	
    <script src="javascript/assets/autocomplete.js"></script>
</body>

</html>