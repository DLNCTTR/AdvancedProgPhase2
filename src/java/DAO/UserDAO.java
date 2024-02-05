/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.User;
import Utils.DBManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BEmerson
 */
public class UserDAO {

    //This classis responsible for loading and selecting data
    public User getUserByEmail(String email) {
        User user = new User();

        DBManager mngr = new DBManager();
        Connection conn = mngr.getConnection();

        System.out.println("[SELECTING USER DATA]");
        String query = "SELECT user_id, email, first_name, last_name, password, user_type from users WHERE email=" + "'" + email + "'";
        System.out.println(query);
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id= rs.getInt("user_id");
                String userEmail = rs.getString("email");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userType = rs.getString("user_type");
                user.setId(id);
                user.setEmail(userEmail);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPassword(password);
                user.setType(userType);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("User Retreived\n");
        System.out.println(user);
        return user;
    }
    
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        DBManager mngr = new DBManager();
        Connection conn = mngr.getConnection();

        System.out.println("[SELECTING ALL USER DATA]");
        String query = "SELECT user_id, email, first_name, last_name, password, user_type FROM users";
        System.out.println(query);

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getString("user_type"));

                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }

        System.out.println("All Users Retrieved\n");
        return users;
    }
}
