<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%!
	String displayAllUrl = "product-list.jsp?selectedProductType=All";
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheets/bootstrap4-bubblegum.min.css">
    <link rel="stylesheet" href="stylesheets/stylesheet.min.css">
    <link rel="icon" href="images/icon/favicon.png" type="image/png">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <title>Index</title>
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
                        <a class="nav-link" href="#home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <form id="sortProducts">
                            <input type="hidden" value="All" id="displayProductType" />
                            <a class="nav-link" href="product-list.jsp">Browse Products</a>
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">Cart</a>
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