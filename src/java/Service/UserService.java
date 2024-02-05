
package Service;

import DAO.UserDAO;
import Models.User;


public class UserService {
    
     public User loginUser(String email, String password) { 
       
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email); 
        if (user == null) { 
            return null;
        } else if (user.getEmail() == null) {
            return null;
        } else { 

            if (user.getPassword().equals(password)) { 
                return user;
            }
        }
        return null;
    }
     
public void addUser(User user) {
}

   
}
