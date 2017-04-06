/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freeware Sys
 */
public class FlightInfo 
{
    private String ID;
    public FlightInfo(){}
    
    public String[] gatherInfo()
    {
        String fNum="",airline="",etd="",eta="",destination=""
                ,origin="",date="",price="",year="",month="",date1="";
        String[] type = {"flight number", "airline", "etd", "eta"
                        , "destination", "origin", "date", "Price"};
        String[] rawvalue = {fNum,airline,etd,eta,
                    destination,origin,date,price};
        String[] passvalue = {fNum,airline,etd,eta,
                    destination,origin,year,month,date1,price};
        try {
            connect con = new connect();
            Statement st = con.getSt();
            String command = "SELECT * FROM flight WHERE `Flight ID` ='" + ID + "'";
            ResultSet rs;
            rs = st.executeQuery(command);
            
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
        } 
        catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        
        return passvalue;
    }

    public void setID(String ID) 
    {
        this.ID = ID;
    }
    
    
    
}
