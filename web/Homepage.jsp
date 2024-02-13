

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Glow Stick Central</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/homepage.css">
    </head>
    <body>
        
        <%
            String username = (String) session.getAttribute("username");
            
        %>
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <h3 class="masthead-brand">Glow Stick Central</h3>
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link active" href="Homepage.jsp">Home</a>
                        <a class="nav-link" href="GlowstickServlet">Shop</a>
                        <%
                            if (username == null) {
                        %>
                        <a class="nav-link" href="Login.jsp">Login</a>
                        <%
                            } else {
                        %>
                        <a class="nav-link" href="LogoutServlet">Logout</a>
                        <%
                            }
                        %>
                        <a class="nav-link" href="Cart.jsp">Cart</a>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">
                <h1 class="cover-heading">Welcome to <em>Glow Stick Central!</em></h1>
                <p class="lead">Here at Glow Stick Central, we have glowing review. Check out our wide selection of vibrant glow sticks</p>
                <p class="lead">
                    <a href="GlowstickServlet" class="btn btn-lg btn-secondary">View Glow Sticks</a>
                </p>
            </main>

            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <p> <a href="https://getbootstrap.com/"></a>,  <a href="https://twitter.com/mdo"></a>.</p>
                </div>
            </footer>
        </div>
<%-- Example of adding to cart form/button in product pages --%>
<form action="CartServlet" method="post">
    <input type="hidden" name="action" value="addToCart"/>
    <input type="hidden" name="productId" value="${product.id}"/>
    <input type="submit" value="Add to Cart"/>
</form>

    </body>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
