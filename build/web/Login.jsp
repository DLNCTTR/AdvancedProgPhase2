

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en" dir="ltr">
    <head>

        <meta chartset="utf-8">
        <title>Login Form</title>
        <link rel="stylesheet" href="css/Login.css">
    </head>

    <body>
        
        <%
        
            String errorLogin = (String) request.getAttribute("incorrectLogin");
        
        %>
        <div class="center">
            <h1>Login</h1>
            <form action =" LoginServlet" method="post">
                <div class="txt_field">
                    <input type="text" name="username"  >
                    <label>Username</label>
                </div>
                <div class="txt_field">
                    <input type="password" name ="password" >
                    <label>Password</label>
                </div>
                <% 
                    if (errorLogin != null) {
                %>
                <p><%= errorLogin%></p>
                <%
                    }
                %>
                <div class = float-container>
                    <div class="float-child">    
                        <input id="LoginButton" type ="submit" value="Login">
                    </div>
                    <div class="float-child">
                        <a href="Homepage.jsp">Homepage</a>
                    </div>
                </div>


        </div>

<%-- Example of adding to cart form/button in product pages --%>
<form action="CartServlet" method="post">
    <input type="hidden" name="action" value="addToCart"/>
    <input type="hidden" name="productId" value="${product.id}"/>
    <input type="submit" value="Add to Cart"/>
</form>


    </body>
</html>
