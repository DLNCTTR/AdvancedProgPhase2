
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "GlowstickServlet", urlPatterns = {"/GlowstickServlet"})
public class GlowstickServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        GlowstickService gServ = new GlowstickService();
        
        
        ArrayList<Glowstick> glowstickList = new ArrayList();
        
        
        glowstickList = gServ.getAllGlowsticks();
        
        
        request.setAttribute("glowstickList", glowstickList);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
