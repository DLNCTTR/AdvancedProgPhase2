/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.UserDAO;
import Models.User;
import Service.UserService;
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

/**
 *
 * @author 117776119
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Create variables for name and password and assign value of the "name" and "password" entered in the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) { // check if the values entered are empty
            request.getRequestDispatcher("Login.jsp").forward(request, response);// if they are, go back to the login page
        } else { //if they are not empty (i.e. the user entered a username and password)

            UserService uServ = new UserService(); //creating an object of the UserDAO class (i.e. getting access to the UserDAO class)
            User user = uServ.loginUser(username, password);//uses the loginUser method from Service class

            if (user == null) {
               
                request.setAttribute("incorrectLogin", "A user with that email and password was not found");// this is a custom message we cab show 
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// if fail to find user then reload page and show a message saying why
                rd.forward(request, response);
                
            } else {
                
                HttpSession session = request.getSession(); //calls session

                long userID = user.getId();
                String userType = user.getType();
  
                if ("admin".equals(userType)) {// checks if the user is an admin
           
                    session.setAttribute("userID", userID);
                    session.setAttribute("username", username);
      
                    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPage.jsp");// change this to be an admin page potentially
                    dispatcher.forward(request, response);
                    
                } else if ("user".equals(userType)) { // checks if the user is normal user
                   
                    session.setAttribute("userID", userID);
                    session.setAttribute("username", username);
                
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }
}
