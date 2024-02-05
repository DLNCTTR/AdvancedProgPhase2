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
// Place in com.yourapp.controllers.CartServlet.java

// Initialize the cart in a filter or listener or at the start of your servlet

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve glowstick cart items from session
        List<Glowstick> glowstickCart = (List<Glowstick>) request.getSession().getAttribute("glowstickCart");

        // Forward to JSP for rendering
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle add-to-cart logic for glowsticks
        String colour = request.getParameter("colour");
        String size = request.getParameter("size");

        // Fetch glowstick details from database using GlowstickDAO
        GlowsticksDAO glowstickDAO = new GlowsticksDAO();
        Glowstick glowstick;
        glowstick = glowstickDAO.getGlowstickByColourAndSize(colour, size);

        // Retrieve glowstick cart from session
        List<Glowstick> glowstickCart = (List<Glowstick>) request.getSession().getAttribute("glowstickCart");

        // Add glowstick to cart
        glowstickCart.add(glowstick);

        // Update session attribute
        request.getSession().setAttribute("glowstickCart", glowstickCart);

        // Redirect back to the glowstick cart page
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}



