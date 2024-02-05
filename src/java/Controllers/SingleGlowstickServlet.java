
package Controllers;

import Models.Glowstick;
import Service.GlowstickService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SingleGlowstickServlet", urlPatterns = {"/SingleGlowstickServlet"})
public class SingleGlowstickServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        GlowstickService gServ = new GlowstickService();
        
        
        String glowstickIDString = request.getParameter("glowstickID");
        
        
        int glowstickID = Integer.parseInt(glowstickIDString);
        
     
        Glowstick glowstick = gServ.getGlowstickByID(glowstickID);
     
        
        request.setAttribute("singleGlowstick", glowstick);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("SingleGlowstick.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
