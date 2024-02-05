/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BEmerson
 */
public class DBManager {
    
    String framework = "derbyclient";
    String protocol = "jdbc:derby://localhost:1527/";

    
    public Connection getConnection(){
        Connection conn = null;
        
        ClientDriver derbyClient = new ClientDriver();
        
        try {
            Properties props = new Properties(); // connection properties
//            props.put("user", "dbuser");
//            props.put("password", "dbpassword");
            
            String dbName = "glowstickshop"; // the name of the database

            conn = derbyClient.connect(protocol + dbName
                    + ";create=true", props);
            
            System.out.println("Connected to database " + dbName);

            // We want to control transactions manually. Autocommit is on by
            // default in JDBC.
            conn.setAutoCommit(false);  
        } catch (SQLException sqle) {
            printSQLException(sqle);
        }
        return conn;
    }
    
   
    public static void main(String[] args) {
        new DBManager().doConnectionTest();
    }
    
     void doConnectionTest(){
         Connection conn = getConnection();
         if (conn != null){
             System.out.println("Connection Established \n");
             try {
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
    }
     
    public static void printSQLException(SQLException e) {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null) {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    } 
}
