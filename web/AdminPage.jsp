<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.User" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="java.util.Iterator" %>


<div>
    <h2>All Users:</h2>
    <%    
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getAllUsers();
        
        for (User user : users) {
    %>
        <form action="AdminPageServlet" method="post">
            <input type="hidden" name="userID" value="<%= user.getId() %>">
            <p>ID: <%= user.getId()%>, Username/Email: <%= user.getEmail() %>, User Type: <%= user.getType() %></p>
            
            <!-- Add form elements for actions -->
            <label>Disable User: <input type="checkbox" name="disableUser"></label>
            <label>New Password: <input type="password" name="newPassword"></label>
            <label>New User Type: <input type="text" name="newUserType"></label>
            
            <input type="submit" name="updateUser" value="Update">
        </form>
            <hr>
    <%
        }
    %>
</div>

<div>
    <h2>Add New User</h2>
    <h6>(Not Functioning Yet)</h6>
    <!-- Add form for adding new user -->
    <form action="AdminPageServlet" method="post">
        <label>Username: <input type="text" name="newUsername"></label>
        <label>Password: <input type="password" name="newPassword"></label>
        <label>User Type: <input type="text" name="newUserType"></label>
        <input type="submit" name="addUser" value="Add User">
    </form>
</div>

<script>
    function printText(message) {
        console.log(message);
    }
</script>
