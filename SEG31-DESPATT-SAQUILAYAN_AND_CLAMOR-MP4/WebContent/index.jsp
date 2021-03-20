<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	String displayAllUrl = "display-products.action?selectedProductType=All";
	String currentPage = "index";
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="stylesheets/landing_page.min.css">

  <script src="https://kit.fontawesome.com/dec412c784.js" crossorigin="anonymous"></script>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
  <title>SweetX</title>
</head>

<body>
  <%-- GETS THE CART COMPONENT --%>
  <jsp:include page="view/cart-component.jsp" />


  <!-- NAVBAR -->
  <section id="title">
    <div class="container-fluid">
      <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand navbar-title" href="#">SweetX</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
          aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">

          <ul class="navbar-nav ms-auto">
            <li class="nav-item">

              <a class="nav-link" href="#search-function">Browse Products</a>

            </li>

            <li class="nav-item">
              <a class="nav-link" href="menu-page.jsp">Our Bundles!</a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- Title -->
      <div class="row">
        <div class="col-lg-6 title-quote">
          <h1 class="h1-title">Things just got a whole lot tastier!</h1>
          <button type="button" onclick="location.href='<%=displayAllUrl%>'"
            class="btn btn-light btn-lg btn-order">Order
            Now!</button>
        </div>
        <div class="col-lg-6">
          <img class="title-image" src="images/landing_page/cupcake.png" alt="header-photo">
        </div>
      </div>

    </div>

  </section>

  <!-- carousel -->
  <div class="container-fluid features-container">
    <h2 class="feature-quote">Select from a multitude of desserts!</h2>

    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">

          <a href="#"><img class="testimonial-image" src="images/landing_page/churros.png" alt="dog-profile"></a>

        </div>
        <div class="carousel-item">

          <a href="#"><img class="testimonial-image" src="images/landing_page/valentine-cupcake.jpg"
              alt="lady-profile"></a>

        </div>

        <div class="carousel-item">

          <a href="#"><img class="testimonial-image" src="images/landing_page/pancakes.jpg" alt="lady-profile"></a>

        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

  </div>





  <section id="search-function">
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-12 col-md-10 col-lg-8">
          <form class="card card-sm" action='search-product.action' method="POST">
            <div class="card-body row no-gutters align-items-center search-border">
              <div class="col-auto">
                <i class="fas fa-search h4 text-body"></i>
              </div>
              <!--end of col-->
              <div class="col">
                <input class="form-control form-control-lg form-control-borderless" type="search" name="searchInput"
                  autocomplete="off" placeholder="Search topics or keywords">
              </div>
              <!--end of col-->
              <div class="col-auto">
                <button class="btn btn-danger btn-lg search-button" type="submit">Search</button>
              </div>
              <!--end of col-->
            </div>
          </form>
        </div>
        <!--end of col-->
      </div>
    </div>

    <footer id="footer">
      <i class="fab fa-twitter footer-icon"></i>
      <i class="fab fa-facebook-f footer-icon"></i>
      <i class="fab fa-instagram footer-icon"></i>
      <i class="fas fa-envelope footer-icon"></i>
    </footer>
  </section>


</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="javascript/assets/cart.js"></script>
<script src="javascript/assets/product-list.js"></script>
<script src="javascript/assets/autocomplete.js"></script>

</html>