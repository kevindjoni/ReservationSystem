/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas Bryan
 */
public class Final 
{
    public static void main(String[] args)
    {
        /*
        Statement st = null;
        connect a = new connect();
        st = a.getSt();*/
        Login login = new Login();
        login.setVisible(true);
    }
    
}
