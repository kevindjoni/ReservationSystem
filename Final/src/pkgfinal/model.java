/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Alexander Jo
 */
public class model
{
    private connect c;
    public model () 
    {
        c = new connect();
    }
    
    public boolean isUsernameExist(String user)
    {
        ResultSet rs;
        try {
            String temp;
            rs = c.executeQuery("SELECT * FROM `user`");
            while (rs.next()) {
                temp = rs.getString("username");
                if (temp.equals(user)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("errror query");
        }
        return false;
    }
    // checking the existence of input user and pass in the database
    public boolean loginSuccess(String username, String password)
    {
        boolean message = false;
        try {
            ResultSet rs;
            rs = c.getSt().executeQuery("SELECT * FROM `user` WHERE `Username` = '" + username + "'");
            if (rs.next()) {
                String tempPass = rs.getString("password");
                
                if (password.equals(tempPass)) {
                    message = true;
                }
            }
            
            
            
            return message;
        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    // q must be a querry
    public DefaultTableModel modelTable(String q)
    {
        DefaultTableModel table = new DefaultTableModel();
        try {
            Object[] obj;
            ResultSet rs = c.getSt().executeQuery(q);
            ResultSetMetaData data = rs.getMetaData();
            int num = data.getColumnCount();
            for(int i = 0 ; i < num ; i++)
            {
                table.addColumn(data.getColumnLabel(i + 1));
            }
            while(rs.next())
            {
                obj = new Object[num];
                for(int i = 0; i < num; i++)
                {
                    obj[i] = rs.getObject(i+1);
                }
                table.addRow(obj);
            }
            return table;
        } catch (SQLException ex) {
            System.out.println("model error");
        }
        return table;
    }
    
    public ArrayList<String> gatherInfo(String ID)
    {
        ArrayList<String> allValue = new ArrayList<>();
        String fNum="",airline="",etd="",eta="",destination=""
                ,origin="",date="",price="",year="",month="",date1="";
        String[] type = {"flight number", "airline", "etd", "eta"
                        , "destination", "origin", "date", "Price"};
        String[] rawvalue = {fNum,airline,etd,eta,
                    destination,origin,date,price};
        String[] passvalue = {fNum,airline,etd,eta,
                    destination,origin,year,month,date1,price};
        try {
            String command = "SELECT * FROM flight WHERE `Flight ID` ='" + ID + "'";
            ResultSet rs;
            rs = c.getSt().executeQuery(command);
            
            while (rs.next()) 
            {
                
                for(int z=0; z< type.length; z++)
                {
                    rawvalue[z] = rs.getString(type[z]);
                }
            }
            for (int k = 0; k < passvalue.length ; k++) 
            {
                if(k>=6 && k<=8)
                {
                    String s= rawvalue[6];
                    String year1=s.substring(0,4);
                    String month1=s.substring(5,7);
                    String day1=s.substring(8,10);
                    passvalue[k] = year1; k++;
                    passvalue[k] = month1; k++;
                    passvalue[k] = day1;
                }
                else if(k>8)
                {
                    passvalue[k] = rawvalue[k-2];
                }
                else
                {
                    passvalue[k] = rawvalue[k];
                }
                
            }
            for(int m=0;m< passvalue.length;m++)
            {
                allValue.add(passvalue[m]);
            }
                
        } 
        catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        
        return allValue;
    }
    
    public void addData(String q)
    {
        try {
            c.getSt().executeUpdate(q);
            System.out.println("adding successful");
        } catch (SQLException ex) {
            System.out.println("error adding");
        }
    }
    
    public boolean isCodeExist(int a)
    {
        boolean message = false;
        try {
            String query = "SELECT COUNT(*) FROM `transactions` WHERE `Booking Code` = '" + a + "'";
            ResultSet rs;
            rs = c.getSt().executeQuery(query);
            if(rs.next())
            {
                message = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    public void Refresh(String date) // delete expired flight
    {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        ResultSet rs;
        try 
        {
            ArrayList<String> queries = new ArrayList<String>();
            String command = "SELECT * FROM `flight`";
            rs = c.getSt().executeQuery(command);
            while(rs.next())
            {
                boolean count=false;
                String date1= rs.getString("date");
                int datey=Integer.parseInt(date1.substring(0, 4));
                int datem=Integer.parseInt(date1.substring(5, 7));
                int dated=Integer.parseInt(date1.substring(8, 10));
                int id=rs.getInt("Flight ID");
                if(datey<year)
                {
                    count=true;
                }
                else if(datey==year)
                {
                    if(datem<month)
                    {
                        count=true;
                    }
                    else if(datem==month)
                    {
                        if(dated<day)
                        {
                            count=true;
                        }
                    }
                }
                if(count==true)
                {
                    queries.add("DELETE FROM `flight` WHERE `Flight ID`='"+id+"'");
                }
            }
            for(int i = 0; i < queries.size() ; ++i)
            {
                c.getSt().executeUpdate(queries.get(i));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR! : " + ex);
        } 
    }
    
    public void addFlight(String[] i)
    {
        try {
            c.getSt().executeUpdate("INSERT INTO `flight` (`Flight ID`, `flight number`, `airline`, `etd`, `eta`, `seats left`, "
                    + "`destination`, `origin`,`date`,`price`) VALUES "
                    + "(NULL, '" + i[6] + "', '" + i[0] + "', '" + i[1] + "', '" + i[2] + "', '" + i[5] + "', '" + i[3] + "', "
                    + "'" + i[4] + "','" + i[8] + "','" + i[7] + "');");
        } catch (SQLException ex) {
            Logger.getLogger(addTable_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateFlight(String[] i, int eRow)
    {
        try {
            c.getSt().executeUpdate("UPDATE `flight` SET `flight number`='" + i[7] + "', `airline`='" + i[0] + "', "
                    + "`eta`='" + i[1] + "', `etd`='" + i[2] + "', `destination`='" + i[3] + "',`origin`='" + i[4] + "', `seats left`='" + i[5] + "' "
                    + "WHERE `Flight ID`='" + eRow + "'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update Error");
        }
    }
    
    public boolean addUser(String user, String pass) // username sign up
    {
        ResultSet rs;
        boolean added = false;
        try {
            c.getSt().executeUpdate("INSERT INTO `user` (`username`,`password`) VALUES ('" + user + "','" + pass + "')");
            added = true;

        } catch (SQLException ex) {
            System.out.println("Insert Username failed");
        }
        return added;
    }
    public boolean checkSimilarUsername(String user)
    {
        ResultSet rs;
        boolean found = false;
        try {
            String temp;
            rs = c.getSt().executeQuery("SELECT * FROM `user`");
            while (rs.next()) {
                temp = rs.getString("username");
                if (temp.equals(user)) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("query error");
        }
        return found;
    }
    
    public boolean deleteData(int id)
    {
        boolean deleted = false;
        
        try {
            c.getSt().executeUpdate("DELETE FROM `user` WHERE `ID` = '" + id + "'");
            deleted = true;
        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deleted;
    }
    public void updateUser(String u, String p, int target)
    {
        try {
            c.getSt().executeUpdate("UPDATE `user` SET `username`='" + u + "', `password`='" + p + "' WHERE `ID`='" + target + "'");
        } catch (SQLException ex) {
            Logger.getLogger(edituser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
