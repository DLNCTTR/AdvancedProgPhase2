/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author dylan
 */
import DAO.GlowsticksDAO;
import Models.Cart;
import Models.Glowstick;
import Service.GlowstickService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
// Place in com.yourapp.controllers.CartServlet.java

// Initialize the cart in a filter or listener or at the start of your servlet

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Example logic to handle adding a glowstick to the cart
        String action = request.getParameter("action");
        if ("addToCart".equals(action)) {
            // Replace with actual logic to retrieve the glowstick based on request parameters
            GlowsticksDAO glowstickDAO = new GlowsticksDAO();
            String colour = request.getParameter("colour");
            String size = request.getParameter("size");
            Glowstick glowstick = glowstickDAO.getGlowstickByColourAndSize(colour, size);

            if (glowstick != null) {
                CartItem newItem = new CartItem(glowstick, 1); // Assume 1 quantity for simplicity
                cart.addItem(newItem);
            }
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }
}


    }   
}




