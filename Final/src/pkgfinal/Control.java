package pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NicDjon.Co
 */
public class Control
{
    private connect c;
    private String username;
    private String password;
    private ResultSet rs;
    
    public Control()
    {
        c = new connect();
    }
    public Control(String u, String p)
    {
        c = new connect();
        username = u;
        password = p;
        
    }
    
    
    public boolean loginSuccess()
    {
        boolean message = false;
        
        try {
            rs= c.getSt().executeQuery("SELECT * FROM `user` WHERE `Username` = '"+username+"'");
            if(rs.next())
            {
                String tempPass = rs.getString("password");
            
                if(password.equals(tempPass))
                {
                    message = true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Query Error");
        }
        
        return message;
    }
    
    public boolean isAdmin()
    {
        boolean message;
        
        message = username.equalsIgnoreCase("admin");
        
        
        return message;
    }
    
    
    // put setter and getter method below here
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public connect getC()
    {
        return c;
    }
}
