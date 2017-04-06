/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freeware Sys
 */
public class controlData
{
    private Object[] obj = null;
    private ResultSet rs = null;
    private DefaultTableModel table = null;
    private connect c;
    private DefaultComboBoxModel mdl = null;
 
    
    public controlData()
    {
        c = new connect();
    }
    
    public DefaultTableModel fillSchedule()
    {
        table = new DefaultTableModel();
        try 
        {
            rs = c.getSt().executeQuery("SELECT * FROM `flight`");
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
        } 
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        
        return table;
    }
    
    public DefaultTableModel fillTable(String query)
    {
        table = new DefaultTableModel();
        try 
        {
            rs = c.getSt().executeQuery(query);
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
        } 
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return table;
    }
    
    public void Refresh(String date)
    {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        try 
        {
            ArrayList<String> queries = new ArrayList<String>();
            rs= c.getSt().executeQuery("SELECT * FROM `flight`");
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
   
    public DefaultComboBoxModel fillComboBox(String[] s)
    {
        mdl = new DefaultComboBoxModel();
        for(int i= 0; i< s.length;i++)
        {
            mdl.addElement(s[i]);
        }
        return mdl;
    }
    
    public boolean validateInput(int[] d, String[] i) 
    { 
        boolean message = false; 
        for(int z = 0; z < i.length; z++) 
        { 
            if(i[z].equals("") || i[z].equals(0)) 
            { 
                message = true; 
            } 
        } 
        if (!message)  
        { 
            if (d[0] < Integer.parseInt(i[i.length - 1].substring(0,4))) { 
                message = true; 
            } else if (d[0] == Integer.parseInt(i[i.length - 1].substring(0,4))) { 
                if (d[1] < Integer.parseInt(i[i.length - 1].substring(5,7))) { 
                    message = true; 
                } else if (d[1] == Integer.parseInt(i[i.length - 1].substring(5,7))) { 
                    if (d[2] < Integer.parseInt(i[i.length - 1].substring(8,10))) { 
                        message = true; 
                    } 
                } 
            } 
        } 
        return message; 
    }
    
    public connect getC()
    {
        return c;
    }
    
}
