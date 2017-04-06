package pkgfinal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NicDjon.Co
 */
public class Control
{
    private model m;
    public Control()
    {
        m = new model();
    }

    // control the login page
    // the username should not be empty
    public boolean tryLogin(String u, String p)
    {
        // true means success
        // false means failed
        boolean message = false;
        
        if(!u.equals("") || !p.equals(""))
        {
            // try to check the existence of username and password 
            // in the database
            message = m.loginSuccess(u,p);
        }
        
        
        
        return message;
    }     
    
    // if true it will direct to scheduleTable
    // if false it will direct to scheduleTable_Staff
    public boolean isAdmin(String username)
    {
        boolean message;
        
        message = username.equalsIgnoreCase("admin");
        
        
        return message;
    }
    
    public DefaultTableModel fillTable(boolean i, String c)
    {
        DefaultTableModel mdl = new DefaultTableModel();
        if(i)
        {
            mdl = m.modelTable(c);
        }
        return mdl;
    }
    
    public ArrayList<String> gatherInfo(int ID)
    {
        ArrayList<String> temp = new ArrayList<>();
        if(ID >=0)
        {
            temp = m.gatherInfo(Integer.toString(ID));
        }
        return temp;
    }
    
    // name =  name of the booker
    // info =  all flight info
    // ticket = # of seats purchased
    public void addTransaction(int ticket, String name, int id)
    {
        int lowNo = 100000000; 
        int highNo = 999999999;
        if(id>=0 && ticket >0 && !name.equals(""))
        {
            Random r = new Random();
            int code;
            code = showRandomInteger(lowNo, highNo, r);
//            String command1 = "INSERT INTO `transactions` (`Booking Code`, `Number of Tickets`, `Booking Name`, `Flight ID`) VALUES ('" + code + "', '"
//                        + ticket + "', '" + name + "', '" + id + "')";
            String command1 = "INSERT INTO `transactions` (`Booking Code`, `Number of Tickets`, `Booking Name`, `Flight ID`) VALUES ('"+code+"', '"
                    +ticket+"', '"+name+"', '"+id+"')";
            m.addData(command1);
        }
        else
        {
            System.out.println("information not complete");
        }
    }
    
    public boolean validateUsername(String user, String pass) // username sign up
    {
        boolean success = false;
        if(!user.equals("") && !pass.equals(""))
        {
            success = !m.isUsernameExist(user);
           
        }
        return success;
    }
    
    private int showRandomInteger(int aStart, int aEnd, Random aRandom) 
    {
        int randomNumber = 0;
        boolean flag = true;
        
        while (flag) 
        {
            //get the range, casting to long to avoid overflow problems
            long range = (long) aEnd - (long) aStart + 1;
            // compute a fraction of the range, 0 <= frac < range
            long fraction = (long) (range * aRandom.nextDouble());
            randomNumber = (int) (fraction + aStart);
            flag = !m.isCodeExist(randomNumber);
            // true means repeat the generating
            // false means good to go
        }
        return randomNumber;
    }
    
    public void tryRefresh(boolean log, String date)
    {
        if(log)
        {
            m.Refresh(date);
        }
    }
    
    public DefaultComboBoxModel fillComboBox(String[] s) // fill combobox    
    {
        DefaultComboBoxModel mdlCombo;
        mdlCombo = new DefaultComboBoxModel();
        for(int i= 0; i< s.length;i++)
        {
            mdlCombo.addElement(s[i]);
        }
        return mdlCombo;
    }
    
    public boolean validateInput(int[] d, String[] i) // flight input add validation
    { 
        boolean message = false; 
        for(int z = 0; z < i.length; z++) 
        { 
            if(i[z].equals("") || i[z].equals("0")) 
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
    
    public void tryAddFlight(String[] i)
    {
        m.addFlight(i);
    }
    public void tryUpdateFlight(String[] i, int num)
    {
        m.updateFlight(i, num);
    }
    public boolean tryAddUser(String user, String pass)
    {
        boolean success = false;
        if(!user.equals("") && !pass.equals(""))
        {
            if(!m.checkSimilarUsername(user))
            {
                success = m.addUser(user, pass);
            }
        }
        return success;
    }
    public boolean tryDelete(boolean log, int id)
    {
        boolean success = false;
        if(log)
        {
            m.deleteData(id);
            success = true;
        }
        return success;
    }
    public void tryUpdateUser(String user, String pass,int target)
    {
        m.updateUser(user,pass,target);
    }
}
