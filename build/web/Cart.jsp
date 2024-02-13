

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Glow stick Store - Shopping Cart</title>
    </head>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Glowstick"%>
<%@ page import="java.util.*" %>
<%@ page import="Models.Cart" %>
<%@ page import="Models.CartItem" %>
    <body>
        <h1>Your Glow stick Shopping Cart</h1>
            <%
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
        cart = new Cart(); // Consider redirecting or displaying a message if the cart is empty
        session.setAttribute("cart", cart);
    }
%>

</table>
    </body>
</html>
