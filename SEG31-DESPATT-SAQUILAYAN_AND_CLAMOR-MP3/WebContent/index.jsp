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
	
    <main>
        <div id="carousel-landingPage" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="10000">
                    <img src="images/carousel/colorful-marshmellows.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item" data-interval="2000">
                    <img src="images/carousel/sweet-cupcake.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="images/carousel/donuts.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carousel-landingPage" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel-landingPage" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="ht-tm-element jumbotron m-sm-5">
            <h1 class="display-3">This never gets more Sweeter!</h1>
            <p class="lead">Our store has cupcakes, candies, pastries, shakes, and many more
                to satisfy your sweet cravings
            </p>
            <hr class="my-4">
            <p>We hope you like our products! Click this button to see our Merchandise</p>
            <p class="lead">
                <a class="btn btn-danger" href="product-list.jsp" role="button">Crave for Sweets!</a>
            </p>
        </div>

    </main>


<!-- CART Modal -->
<section class="product-cart">
    <div class="modal" id="product-cart" tabindex="-1" role="dialog" aria-labelledby="product-cart"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalCenteredLabel">TODO CART</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col d-inline-flex">
                            <h5 class="ml-2">Product </h5>
                            <h5 style="margin-left: 13rem;">Quantity </h5>
                            <h5 style="margin-left: 3rem;">Price </h5>
                        </div>
                    </div>
                    <div class="row">
                        <!-- USER CART DATA IS HERE -->
                        <div class="col mt-1 mb-2 d-inline-flex">
                            <img src="images/products/puff-sweetflatbread-pastry.jpg" class="img-thumbnail cart-img"
                                alt="...">
                            <h6 class="d-flex align-self-end ml-3 font-weight-bold">Puffed Danish Pastry</h6>
                            <input class="d-flex align-self-end ml-3" min="1" type="number" style="width: 5rem;">
                            <h6 class="d-flex align-self-end ml-5">P 200</h6>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="row">
                            <div class="col d-inline-flex">
                                <h5 style="margin-right: 10rem;">TOTAL: ₱ 600</h5>
                                <button type="button" class="btn btn-secondary mr-1"
                                    data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary ml-1">Submit</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/bloodhound.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script>
    <script src="javascript/assets/product-list.js"></script>
    <script src="javascript/assets/autocomplete.js"></script>
</body>

</html>