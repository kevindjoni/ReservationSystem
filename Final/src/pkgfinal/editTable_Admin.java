/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Freeware Sys
 */
public class editTable_Admin extends javax.swing.JFrame {

    private int eRow;           //  edited row
//    private String flightnum;
//    private String airline;
//    private String etd;
//    private String eta;
//    private int seats;
//    private String des;
//    private String ori;
//    private String cmonth;
//    private String cyear;
//    private String cday;
    private int price;
    private int curry;
    private int currm;
    private int currd;
//    private String updatey;
//    private String updatem;
//    private String updated;
//    private Statement st;
//    private scheduleTable t;
    private DefaultComboBoxModel mdl;
//    private controlData cd = null;
//    private ArrayList<String> info;
    private String date1;
    private addTable_Admin add;
    private Control c;
    private scheduleTable admin;
    
    /**
     * Creates new form editTable_Admin
     */
    public editTable_Admin() 
    {
        initComponents();
//        cd = new controlData();
    }
    public editTable_Admin(ArrayList<String> a, scheduleTable admin, int no)
    {
//      info = a;
        initComponents();
        eRow = no;
//        cd = c;
        c = new Control();
        mdl=new DefaultComboBoxModel();
        this.admin = admin;
        add = new addTable_Admin();
        Airline1.setModel(c.fillComboBox(add.getAirline()));
        h1.setModel(c.fillComboBox(add.getHours()));
        h2.setModel(c.fillComboBox(add.getHours()));
        m1.setModel(c.fillComboBox(add.getMinutes()));
        m2.setModel(c.fillComboBox(add.getMinutes()));
        setDateBox();
        Airline1.setSelectedItem(a.get(0));
        h1.setSelectedItem(a.get(3).substring(0,2));
        m1.setSelectedItem(a.get(3).substring(3,5));
        h2.setSelectedItem(a.get(4).substring(0,2));
        m2.setSelectedItem(a.get(4).substring(3,5));
        seatnum.setValue(Integer.parseInt(a.get(5)));
        destination.setText(a.get(6));
        origin.setText(a.get(7));
        year.setSelectedItem(a.get(8).substring(0,4));
        month.setSelectedItem(a.get(8).substring(5,7));
        date.setSelectedItem(a.get(8).substring(8,10));
        c.tryRefresh(admin.isIsLogin(),a.get(8));
        priceUpdate.setValue(Integer.parseInt(a.get(9)));
    }
    
     public void setDateBox() 
    {
        int min = 2017;
        int max = 2027;
        mdl = new DefaultComboBoxModel();
        for (int z = min; z <= max; z++) {
            mdl.addElement(z);
            //jd.addItem(z);
        }
        year.setModel(mdl);
        int months[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        mdl = new DefaultComboBoxModel();
        for (int l = 0; l < months.length; l++) {
            mdl.addElement(months[l]);
        }
        month.setModel(mdl);
        int day[] = {31, 30, 28, 29};
        mdl = new DefaultComboBoxModel();
        for (int i = 1; i <= 31; i++) {
            mdl.addElement(i);
        }
        date.setModel(mdl);
        year.addActionListener(new ActionListener() {
            int index;

            public void actionPerformed(ActionEvent ae) {
                Object item = year.getSelectedItem();
                year.setSelectedItem(item);
            }
        });
        month.addActionListener(new ActionListener() {
            DefaultComboBoxModel mdl2 = new DefaultComboBoxModel();
            int value = 1;

            public void actionPerformed(ActionEvent e) {
                int k = month.getSelectedIndex();
                if (k < 7) {
                    if (k == 1) {
                        boolean message = add.checkLeapYear(year.getSelectedItem());
                        if (message) {
                            value = day[3];
                        } else {
                            value = day[2];
                        }

                    } else if (k % 2 == 1) {
                        value = day[1];
                    } else if (k % 2 == 0) {
                        value = day[0];
                    }
                } else {
                    if (k % 2 == 1) {
                        value = day[0];
                    } else if (k % 2 == 0) {
                        value = day[1];
                    }
                }

                for (int z = 1; z <= value; z++) {
                    mdl2.addElement(z);
                }
                date.setModel(mdl2);
            }
        });
        date.addActionListener(new ActionListener() {
            int index;

            public void actionPerformed(ActionEvent ae) {
                Object item = date.getSelectedItem();
                date.setSelectedItem(item);
            }
        });
    }
    

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
        Airline1 = new javax.swing.JComboBox<>();

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

        Airline1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Airline1ActionPerformed(evt);
            }
        });

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
                                .addComponent(flightNum, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Airline1, 0, 618, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Airline1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel6))))
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
        String airlineName = Airline1.getSelectedItem().toString();
        String etd = h1.getSelectedItem().toString()+":" + m1.getSelectedItem().toString();
        String eta = h2.getSelectedItem().toString()+":" + m2.getSelectedItem().toString();
        String des = destination.getText().toString();
        String ori = origin.getText().toString();
        String seat = (String) seatnum.getValue();
        String price1 = (String) priceUpdate.getValue();
        String num = flightNum.getText().toString();
        date1 = year.getSelectedItem().toString() + "-" 
                + month.getSelectedItem().toString() + "-" 
                + date.getSelectedItem().toString();
        
        boolean count;
        int[] dateToday = {curry,currm,currd};
        String[] items = {airlineName, eta,etd,des,ori,seat,num,price1};
        
        count  = c.validateInput(dateToday,items);
        
         
        if (count) {
            c.tryUpdateFlight(items, eRow );
            this.dispose();
            scheduleTable s = admin;
            s.setVisible(true);
        } else {
            error1.setText("You cannot add a flight after on the same day. Please recheck the date!");
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
//        cyear=year.getSelectedItem().toString();
//        cd.Refresh(info.get(9));
    }//GEN-LAST:event_yearActionPerformed

    private void monthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMousePressed
    
    }//GEN-LAST:event_monthMousePressed

    private void monthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_monthMouseReleased

    private void monthActionPerformned(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformned
//        cmonth=month.getSelectedItem().toString();
//        cd.Refresh(info.get(9));
    }//GEN-LAST:event_monthActionPerformned

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void Airline1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Airline1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Airline1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Airline1;
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
