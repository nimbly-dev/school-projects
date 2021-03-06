<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Search result for <%= request.getAttribute("searchInput") %> </title>
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
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                       <a class="nav-link" href="<%=displayAllUrl%>">Browse Product<span class="sr-only">(current)</span>s</a>
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
	
	
	
	<%-- GETS THE CART MODAL COMPONENT --%>
    <jsp:include page="view/cart-component.jsp"/>
	
	
    <main>
        <section class="result-container">
            <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <h5>Result for: <%= request.getAttribute("searchInput") %></h5>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex justify-content-center">
                        <div class="row">
						
                            <%if (request.getAttribute("productExist") == "FOUND"){ %>
                            <div class="col mt-3">
                                <div class="card" style="width: 18rem;">
                                    <img src='${requestScope.searchResult.getProductImgPath()}' class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">${requestScope.searchResult.getProductName()}</h5>
                                        <h4>Php ${requestScope.searchResult.getProductPrice() }</h4>
                                        <%-- Check if Product is available --%>
                                        <%if (request.getAttribute("isAvailable") == "true"){ %>
                                        <span class="ht-tm-element badge badge-pill badge-primary"> Available</span>
                                        <%}else{%>
                                        <span class="ht-tm-element badge badge-pill badge-warning"> Not Available</span>
                                        <% } %>
                                        <%if (request.getAttribute("isAvailable") == "true"){ %>
                                        <form action='display-single-product.action' method='GET'>
                                            <p>
                                                <input type="hidden"
                                                    value="${requestScope.searchResult.getProductName()}"
                                                    name='selectedProduct'>
                                                <button type="submit" class="btn btn-danger mt-2">Take a look</button>
                                            </p>
                                        </form>
                                        <%}else{ %>
                                        <p>
                                            <button disabled type="button" class="btn btn-danger mt-2">Take a
                                                look</button>
                                        </p>
                                        <%} %>
                                    </div>
                                </div>
                            </div>
                            <%}else{ %>
                            <h6>NO RESULT</h6>
                            <%} %>

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
    <script src="javascript/assets/autocomplete.js"></script>
</body>

</html>