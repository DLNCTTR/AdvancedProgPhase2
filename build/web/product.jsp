

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Glowstick"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
       
    <%
        ArrayList<Glowstick> glowstickList = (ArrayList) request.getAttribute("glowstickList");
    %>

    <header>
        <div class="collapse bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-4">
                        <h4 class="text-white">Navigation</h4>
                        <p class="text-muted"></p>
                    </div>
                    <div class="col-sm-4 offset-md-1 py-4">
                        <h4 class="text-white"></h4>
                        <ul class="list-unstyled">
                            <li><a href="Homepage.jsp" class="text-white">Home</a></li>
                            <li><a href="Login.jsp" class="text-white">Login</a></li>
                            <li><a href="Cart.jsp" class="text-white">Cart</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="navbar navbar-dark bg-dark box-shadow">
            <div class="container d-flex justify-content-between">
                <a href="#" class="navbar-brand d-flex align-items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path></path><circle cx="12" cy="13" r="4"></circle></svg>
                    <strong>Navigation</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </div>
    </header>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Glow stick collection</h1>
                <p class="lead text-muted"> Any type to fit your glow stick needs.</p>
                <p>
                  
                </p>
            </div>
        </section>

        <div class="album py-5 bg-dark text-light">
            <div class="container">
                <!-- gonna do a for loop here to show all our movies -->
                <div class="row">
                    <%
                        for (Glowstick glowstick : glowstickList) {
                    %>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow bg-secondary">
                            <img class="card-img-top" src="Images/<%= glowstick.getImage()%>" alt="Card image cap" width="300" height="350">
                            <div class="card-body">
                                <p class="card-text"><%= glowstick.getGlowstickID()%></p>
                                <h1 class="card-text"><%= glowstick.getName()%></h1>
                                <p class="card-text"><%= glowstick.getDescription()%></p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                       <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="SingleGlowstickServlet?glowstickID=<%= glowstick.getGlowstickID()%>">View Glowstick</a></div>
                                    </div>
                                    <small class="text-muted">Colour: <%= glowstick.getColour()%></small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%
                        }
                    %>
                    </main>
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%-- Example of adding to cart form/button in product pages --%>
<form action="CartServlet" method="post">
    <input type="hidden" name="action" value="addToCart"/>
    <input type="hidden" name="productId" value="${product.id}"/>
    <input type="submit" value="Add to Cart"/>
</form>
    </body> 
</html>
