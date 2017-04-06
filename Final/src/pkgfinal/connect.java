/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas Bryan
 */
public class connect 
{
    private Connection conn;
    private Statement st;
    public connect()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/airportsystem","root","");
            this.st=conn.createStatement();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR! : "+ex);
        }
    }
    
    public ResultSet executeQuery(String query)
    {
        try
        {
            ResultSet rs = st.executeQuery(query);
            return rs;
        }
        catch (SQLException ex)
        {
            System.out.println("Info: " + ex);
        }
        return null;
    }
    public void disconnect()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error disconnecting");
        }
    }
    
    public Statement getSt()
    {
        return st;
    }
}
