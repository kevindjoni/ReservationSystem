/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import com.mysql.jdbc.StringUtils;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Freeware Sys
 */
public class editTable_Admin extends javax.swing.JFrame {

    private int eRow;           //  edited row
    private String flightnum;
    private String airline;
    private String etd;
    private String eta;
    private int seats;
    private String des;
    private String ori;
    private String cmonth;
    private String cyear;
    private String cday;
    private int price;
    private int curry;
    private int currm;
    private int currd;
    private String updatey;
    private String updatem;
    private String updated;
    private Statement st;
    private scheduleTable t;
    private DefaultComboBoxModel mdl;
    /**
     * Creates new form editTable_Admin
     */
    public editTable_Admin() {
        initComponents();
    }
    public editTable_Admin(ArrayList<String> a, controlData cd)
    {
        addTable_Admin table = new addTable_Admin();
        mdl=new DefaultComboBoxModel();
        Airline.setModel(cd.fillComboBox(table.getAirline()));
        h1.setModel(cd.fillComboBox(table.getHours()));
        h2.setModel(cd.fillComboBox(table.getHours()));
        m1.setModel(cd.fillComboBox(table.getMinutes()));
        m2.setModel(cd.fillComboBox(table.getMinutes()));
        Airline.setSelectedItem(a.get(0));
        h1.setSelectedItem(a.get(3).substring(0,2));
        m1.setSelectedItem(a.get(3).substring(3,5));
        h2.setSelectedItem(a.get(4).substring(0,2));
        m2.setSelectedItem(a.get(4).substring(3,5));
        seatnum.setValue(a.get(5));
        destination.setText(a.get(6));
        origin.setText(a.get(7));
        year.setSelectedItem(a.get(8).substring(0,4));
        month.setSelectedItem(a.get(8).substring(5,7));
        date.setSelectedItem(a.get(8).substring(8,10));
        cd.Refresh(a.get(8));
        priceUpdate.setValue(a.get(9));
    }
    
    
//    public void Refresh()
//    {
//        DefaultComboBoxModel y=new DefaultComboBoxModel();
//        DefaultComboBoxModel b=new DefaultComboBoxModel();
//        DefaultComboBoxModel d=new DefaultComboBoxModel();
//        String[] year1 = {
//                            "2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027"
//                         };
//        String[] month1 = {
//                            "01","02","03","04","05","06","07","08","09","10",
//                            "11","12"
//                         };
//        for(int i=0;i<year1.length;i++)
//        {
//            y.addElement(year1[i]);
//        }
//        for(int i=0;i<month1.length;i++)
//        {
//            b.addElement(month1[i]);
//        }
//        year.setModel(y);
//        month.setModel(b);
//        if(cmonth!=null)
//        {
//            month.setSelectedItem(cmonth);
//        }
//        if(cyear!=null)
//        {
//            year.setSelectedItem(cyear);
//        }
//        String[] day1=null;
//        if(month.getSelectedItem().equals("02")&&(year.getSelectedItem().equals("2017")||year.getSelectedItem().equals("2018")||
//                year.getSelectedItem().equals("2019")||year.getSelectedItem().equals("2021")||year.getSelectedItem().equals("2022")||
//                year.getSelectedItem().equals("2023")||year.getSelectedItem().equals("2025")||year.getSelectedItem().equals("2026")||
//                year.getSelectedItem().equals("2027")))
//        {
//            String[] day = {
//                            "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23","24", "25","26","27","28"
//                        };
//            day1=day;
//        }
//        else  if((((String) year.getSelectedItem()).equals("2020") || ((String)year.getSelectedItem()).equals("2024"))&& ((String)month.getSelectedItem()).equals("02"))
//        {
//            String[] day = {
//                            "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23","24", "25","26","27","28","29"
//                        };
//            day1=day;
//        }
//        else if(month.getSelectedItem().equals("01")||month.getSelectedItem().equals("03")||
//                month.getSelectedItem().equals("05")||month.getSelectedItem().equals("07")||
//                month.getSelectedItem().equals("08")||month.getSelectedItem().equals("10")||
//                month.getSelectedItem().equals("12"))
//        {
//            String[] day = {
//                            "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23","24", "25","26","27","28","29","30","31"
//                        };
//            day1=day;
//        }
//        else
//        {
//            String[] day = {
//                            "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23","24", "25","26","27","28","29","30"
//                        };
//            day1=day;
//        }
//        for(int i=0;i<day1.length;i++)
//        {
//            d.addElement(day1[i]);
//        }
//        date.setModel(d);
//        if(cday!=null)
//        {
//            date.setSelectedItem(cday);
//        }
//    }

//    public editTable_Admin(int temp,String flightnum,String airline,String etd,
//            String eta,int seats,String des,String ori,Statement st,scheduleTable t, 
//            int curry,int currm, int currd, int price, String updatey, String updatem, String updated) 
//    {
//        initComponents();
//        eRow = temp;
//        destination.setEditable(false);
//        origin.setEditable(false);
//        this.flightnum=flightnum;
//        this.airline=airline;
//        this.etd=etd;
//        this.eta=eta;
//        this.seats=seats;
//        this.des=des;
//        this.ori=ori;
//        this.st=st;
//        this.t=t;
//        this.price=price;
//        this.curry=curry;
//        this.currm=currm;
//        this.currd=currd;
//        this.updatey=updatey;
//        this.updatem=updatem;
//        this.updated=updated;
//        DefaultComboBoxModel mdl=new DefaultComboBoxModel();
//        String[] airlines = {"Garuda Indonesia" , "Lufthansa" , "China Airlines" , "Singapore Airlines", "Emirates", "Etihad", "Air Asia", "Cathay Pacific", "Lion Air", "Japan Airlines", "All Nippon Airlines"};
//        for(int j = 0; j < airlines.length; j++)
//        {
//            mdl.addElement(airlines[j]);
//        }
//        Airline.setModel(mdl);
//        DefaultComboBoxModel h=new DefaultComboBoxModel();
//        DefaultComboBoxModel m=new DefaultComboBoxModel();
//        DefaultComboBoxModel h3=new DefaultComboBoxModel();
//        DefaultComboBoxModel m3=new DefaultComboBoxModel();
//        String[] hours = {
//                            "00", "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23"
//                         };
//        String[] minutes = {
//                            "00", "01","02","03","04","05","06","07","08","09","10",
//                            "11","12","13","14","15","16","17","18","19","20",
//                            "21","22","23","24", "25","26","27","28","29","30",
//                            "31","32","33","34","35","36","37","38","39","40",
//                            "41","42","43","44","45","46","47","48","49","50",
//                            "51","52","53","54","55","56","57","58","59"
//        };
//        for(int i=0;i<hours.length;i++)
//        {
//            h.addElement(hours[i]);
//            h3.addElement(hours[i]);
//        }
//        for(int i=0;i<minutes.length;i++)
//        {
//            m.addElement(minutes[i]);
//            m3.addElement(minutes[i]);
//        }
//        h1.setModel(h);
//        h2.setModel(h3);
//        m1.setModel(m);
//        m2.setModel(m3);
//        flightNum.setText(flightnum);
//        Airline.setSelectedItem(airline);
//        String hour=etd.substring(0,2);
//        String minute=etd.substring(3,5);
//        String hour1=eta.substring(0,2);
//        String minute1=eta.substring(3,5);
//        h1.setSelectedItem(hour);
//        m1.setSelectedItem(minute);
//        h2.setSelectedItem(hour1);
//        m2.setSelectedItem(minute1);
//        seatnum.setValue(seats);
//        destination.setText(des);
//        origin.setText(ori);
//        cyear=updatey;
//        cmonth=updatem;
//        cday=updated;
//        this.Refresh();
//        priceUpdate.setValue(price);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Airline = new javax.swing.JComboBox<>();
        flightNum = new javax.swing.JTextField();
        jButton1_editSubmission = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        h1 = new javax.swing.JComboBox<>();
        h2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        m1 = new javax.swing.JComboBox<>();
        m2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        origin = new javax.swing.JTextField();
        destination = new javax.swing.JTextField();
        seatnum = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        year = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        priceUpdate = new javax.swing.JSpinner();
        error1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Flight");

        jLabel2.setText("Airlines");

        jLabel3.setText("Flight No.");

        jLabel4.setText("ETD");

        jLabel5.setText("ETA");

        jButton1_editSubmission.setText("Edit");
        jButton1_editSubmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_editSubmissionActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel6.setText(":");

        jLabel7.setText(":");

        jLabel8.setText("Seats Available:");

        jLabel9.setText("Origin:");

        jLabel10.setText("Destination:");

        destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationActionPerformed(evt);
            }
        });

        jLabel11.setText("Year:");

        year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                yearMouseReleased(evt);
            }
        });
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });

        jLabel12.setText("Month:");

        month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                monthMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                monthMouseReleased(evt);
            }
        });
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformned(evt);
            }
        });

        jLabel13.setText("Date:");

        jLabel14.setText("Price:");

        error1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addComponent(jButton1_editSubmission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origin)
                            .addComponent(destination)
                            .addComponent(seatnum)
                            .addComponent(priceUpdate)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(flightNum)
                                        .addComponent(Airline, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Airline, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(flightNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(h1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h2)
                            .addComponent(m2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(priceUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1_editSubmission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit)
                    .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_editSubmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_editSubmissionActionPerformed
        String airlineName = Airline.getSelectedItem().toString();
        String etd = h1.getSelectedItem().toString()+":" + m1.getSelectedItem().toString();
        String eta = h2.getSelectedItem().toString()+":" + m2.getSelectedItem().toString();
        String des = destination.getText().toString();
        String ori = origin.getText().toString();
        int seat = (int) seatnum.getValue();
        int price1=(int)priceUpdate.getValue();
        String num = flightNum.getText().toString();
        try {
            boolean count=false;
            if(airlineName!=null && eta.length()==5 && etd.length()==5 && des!=null && ori!=null && seat>0 && num!=null && price1>0)
            {
                if(curry<Integer.parseInt(year.getSelectedItem().toString()))
                {
                    count=true;
                }
                else if(curry==Integer.parseInt(year.getSelectedItem().toString()))
                {
                    if(currm<Integer.parseInt(month.getSelectedItem().toString()))
                    {
                        count=true;
                    }
                    else if(currm==Integer.parseInt(month.getSelectedItem().toString()))
                    {
                        if(currd<Integer.parseInt(date.getSelectedItem().toString()))
                        {
                            count=true;
                        }
                    }
                }
                if(count==true)
                {
                   st.executeUpdate("UPDATE `flight` SET `flight number`='"+num+"', `airline`='"+airlineName+"', "
                           + "`eta`='"+eta+"', `etd`='"+etd+"', `destination`='"+des+"',`origin`='"+ori+"', `seats left`='"+seat+"' "
                                   + "WHERE `Flight ID`='"+eRow+"'");
                this.dispose();
                t.fillTable("SELECT * FROM `flight`");
                }
                else
                {
                    error1.setText("You cannot add a flight after on the same day. Please recheck the date!");
                }
            }
            else
            {
                error1.setText("Invalid data input! Please check again. Some fields may be left empty");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR! : "+ex);
        }
    }//GEN-LAST:event_jButton1_editSubmissionActionPerformed

    private void destinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationActionPerformed

    private void yearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_yearMousePressed

    private void yearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_yearMouseReleased

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
        cyear=year.getSelectedItem().toString();
        this.Refresh();
    }//GEN-LAST:event_yearActionPerformed

    private void monthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMousePressed
    
    }//GEN-LAST:event_monthMousePressed

    private void monthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_monthMouseReleased

    private void monthActionPerformned(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformned
        cmonth=month.getSelectedItem().toString();
        this.Refresh();
    }//GEN-LAST:event_monthActionPerformned

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Airline;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JTextField destination;
    private javax.swing.JLabel error1;
    private javax.swing.JButton exit;
    private javax.swing.JTextField flightNum;
    private javax.swing.JComboBox<String> h1;
    private javax.swing.JComboBox<String> h2;
    private javax.swing.JButton jButton1_editSubmission;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> m1;
    private javax.swing.JComboBox<String> m2;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField origin;
    private javax.swing.JSpinner priceUpdate;
    private javax.swing.JSpinner seatnum;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
