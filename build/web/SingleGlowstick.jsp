

<%@page import="Models.Glowstick"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%

        Glowstick glowstick = (Glowstick) request.getAttribute("singleGlowstick");

    %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= glowstick.getName()%></title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>

    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Item Description</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="Homepage.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <a href="Cart.jsp" class="bi-cart-fill me-1"></a>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="Images/<%= glowstick.getImage()%>" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">Glow Stick ID: <%= glowstick.getGlowstickID()%></div>
                        <h1 class="display-5 fw-bolder"><%= glowstick.getName()%></h1>
                        <div class="fs-5 mb-5">
                            <span><strong>Price:</strong> €<%= glowstick.getPrice()%></span><br>
                            <span><strong>Duration:</strong> <%= glowstick.getDuration()%> mins</span><br>
                            <span><strong>Colour:</strong> <%= glowstick.getColour()%></span><br>
                            <span><strong>Size:</strong> <%= glowstick.getSize()%></span><br>
                            <span><strong>Type:</strong> <%= glowstick.getType()%></span>
                        </div>
                        <p class="lead"><%= glowstick.getDescription()%></p>
                        <div class="d-flex">
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                               
                                <%-- Example of adding to cart form/button in product pages --%>
<form action="CartServlet" method="post">
    <input type="hidden" name="action" value="addToCart"/>
    <input type="hidden" name="productId" value="${product.id}"/>
    <input type="submit" value="Add to Cart"/>
</form>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<%-- Example of adding to cart form/button in product pages --%>

        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
