<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	String sortAll = "display-products.action?selectedProductType=All";
	String sortCupcake = "display-products.action?selectedProductType=Cupcake";
	String sortPastry = "display-products.action?selectedProductType=Pastry";
	String sortCandy = "display-products.action?selectedProductType=Candy";
%>
   <!-- BREADCRUMB PRODUCT SORTING COMPONENT  -->
   <div class="row">
       <div class='col'>
           <nav aria-label="breadcrumb ">
               <ol class="breadcrumb">
                   
                   <%if(request.getAttribute("selectedProductSort").equals("All")) { %>
                   	<li class="breadcrumb-item active" aria-current="page">All</li>
                    <li class="breadcrumb-item"><a href="<%=sortCupcake%>">Cupcake</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortPastry%>">Pastry</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortCandy%>">Candy</a></li>
                   
                   <%}else if(request.getAttribute("selectedProductSort").equals("Cupcake")){ %>
                   	<li class="breadcrumb-item active"><a href="<%=sortAll%>">All</a></li>
                    <li class="breadcrumb-item" aria-current="page">Cupcake</li>
                    <li class="breadcrumb-item"><a href="<%=sortPastry%>">Pastry</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortCandy%>">Candy</a></li>
                   
                   <%}else if(request.getAttribute("selectedProductSort").equals("Pastry")){%>
                   	<li class="breadcrumb-item active"><a href="<%=sortAll%>">All</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortCupcake%>">Cupcake</a></li>
                    <li class="breadcrumb-item" aria-current="page">Pastry</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortCandy%>">Candy</a></li>
                   
                   <%}else if(request.getAttribute("selectedProductSort").equals("Candy")){%>
                   	<li class="breadcrumb-item active"><a href="<%=sortAll%>">All</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortCupcake%>">Cupcake</a></li>
                    <li class="breadcrumb-item"><a href="<%=sortPastry%>">Pastry</a></li>
                    <li class="breadcrumb-item" aria-current="page">Candy</li>
                   
                   <%}%>
               </ol>
           </nav>
       </div>
   </div>