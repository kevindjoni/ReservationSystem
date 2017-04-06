package pkgfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Freeware Sys
 */
public class addTable_Admin extends javax.swing.JFrame 
{
    private Statement st;
    private scheduleTable t;
    private String dateNow;
    private controlData cd;
    private DefaultComboBoxModel mdl;
    final private String[] airline = {"Garuda Indonesia" , "Lufthansa" , "China Airlines" ,
            "Singapore Airlines", "Emirates", "Etihad", "Air Asia", "Cathay Pacific",
            "Lion Air", "Japan Airlines", "All Nippon Airlines"};
    final private String[] hours = {
                            "00", "01","02","03","04","05","06","07","08","09","10",
                            "11","12","13","14","15","16","17","18","19","20",
                            "21","22","23"
                         };
    final private String[] minutes = {
                            "00", "01","02","03","04","05","06","07","08","09","10",
                            "11","12","13","14","15","16","17","18","19","20",
                            "21","22","23","24", "25","26","27","28","29","30",
                            "31","32","33","34","35","36","37","38","39","40",
                            "41","42","43","44","45","46","47","48","49","50",
                            "51","52","53","54","55","56","57","58","59"
        };
    
    public addTable_Admin(){}
    public addTable_Admin(controlData cd, String d)
    {
        initComponents();
        this.cd = cd;
        dateNow = d;
        Airline.setModel(cd.fillComboBox(airline));
        h1.setModel(cd.fillComboBox(hours));
        h2.setModel(cd.fillComboBox(hours));
        m1.setModel(cd.fillComboBox(minutes));
        m2.setModel(cd.fillComboBox(minutes));
        this.setDateBox();
        cd.Refresh(dateNow);
    }
    
    private boolean checkLeapYear(Object year)
    {
        boolean message;
        int y = (int) year;
        message = y % 4 == 0;
        return message;
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
                        boolean message = checkLeapYear(year.getSelectedItem());
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

    public String[] getAirline() {
        return airline;
    }

    public String[] getHours() {
        return hours;
    }

    public String[] getMinutes() {
        return minutes;
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
        Airline = new javax.swing.JComboBox<>();
        flightNum = new javax.swing.JTextField();
        add_Add = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        origin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        cancel_Add1 = new javax.swing.JButton();
        seatnum = new javax.swing.JSpinner();
        h1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        m1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        h2 = new javax.swing.JComboBox<>();
        m2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        year = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        price = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Flight");

        jLabel2.setText("Airline:");

        jLabel3.setText("Flight No:");

        jLabel4.setText("ETD:");

        jLabel5.setText("ETA:");

        Airline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AirlineActionPerformed(evt);
            }
        });

        flightNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightNumActionPerformed(evt);
            }
        });

        add_Add.setText("Add");
        add_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_AddActionPerformed(evt);
            }
        });

        jLabel6.setText("Seats Available:");

        jLabel7.setText("Origin:");

        origin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originActionPerformed(evt);
            }
        });

        jLabel8.setText("Destination:");

        destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationActionPerformed(evt);
            }
        });

        cancel_Add1.setText("Cancel");
        cancel_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_Add1ActionPerformed(evt);
            }
        });

        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        jLabel9.setText(":");

        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });

        jLabel10.setText(":");

        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
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

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));

        error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancel_Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(add_Add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(h2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(h1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(m1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(m2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                    .addComponent(Airline, 0, 628, Short.MAX_VALUE)
                                    .addComponent(flightNum)
                                    .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                                    .addComponent(destination)
                                    .addComponent(origin)
                                    .addComponent(seatnum))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Airline, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flightNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel_Add1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AirlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AirlineActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AirlineActionPerformed

    private void flightNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightNumActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_flightNumActionPerformed

    private void add_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_AddActionPerformed

        int curry, currm, currd;
        curry = Integer.parseInt(dateNow.substring(0, 4));
        currm = Integer.parseInt(dateNow.substring(5, 7));
        currd = Integer.parseInt(dateNow.substring(8, 10));
        
        String airlineName = Airline.getSelectedItem().toString();
        String eta = h1.getSelectedItem().toString() + ":" + m1.getSelectedItem().toString();
        String etd = h2.getSelectedItem().toString() + ":" + m2.getSelectedItem().toString();
        String des = destination.getText().toString();
        String ori = origin.getText().toString();
        String seat = (String) seatnum.getValue();
        String num = flightNum.getText().toString();
        String price1 = (String) price.getValue();
        String dateflight = year.getSelectedItem().toString() + "-" + month.getSelectedItem().toString() + "-" + date.getSelectedItem().toString();
        
        boolean count;
        int[] dateToday = {curry,currm,currd};
        String[] items = {airlineName, eta,etd,des,ori,seat,num,price1,dateflight};
        
        count  = cd.validateInput(dateToday,items);
        
        if (count) 
        {
            try {
                cd.getC().getSt().executeUpdate("INSERT INTO `flight` (`Flight ID`, `flight number`, `airline`, `etd`, `eta`, `seats left`, "
                        + "`destination`, `origin`,`date`,`price`) VALUES "
                        + "(NULL, '" + num + "', '" + airlineName + "', '" + eta + "', '" + etd + "', '" + seat + "', '" + des + "', "
                                + "'" + ori + "','" + dateflight + "','" + price1 + "');");
            } catch (SQLException ex) {
                Logger.getLogger(addTable_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            cd.fillTable("SELECT * FROM `flight`");
            scheduleTable s = new scheduleTable(cd);
            s.setVisible(true);
        } else {
            error.setText("All field must be filled / Value is invalid");
        }
            
    }//GEN-LAST:event_add_AddActionPerformed

    private void originActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_originActionPerformed

    private void destinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationActionPerformed

    private void cancel_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_Add1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancel_Add1ActionPerformed

    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_h1ActionPerformed

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_m1ActionPerformed

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h2ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m2ActionPerformed

    private void yearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMouseReleased
        // TODO add your handling code here:
//        cd.Refresh(date);
    }//GEN-LAST:event_yearMouseReleased

    private void monthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseReleased
        // TODO add your handling code here:
//        cmonth=month.getSelectedItem().toString();
//        cd.Refresh();
    }//GEN-LAST:event_monthMouseReleased

    private void yearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMousePressed
        // TODO add your handling code here:
//        cd.Refresh();
    }//GEN-LAST:event_yearMousePressed

    private void monthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMousePressed
        // TODO add your handling code here:
        /*
        cmonth=month.getSelectedItem().toString();
        this.Refresh();*/
    }//GEN-LAST:event_monthMousePressed

    private void monthActionPerformned(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformned
//        cmonth= month.getSelectedItem().toString();
//        this.Refresh();
    }//GEN-LAST:event_monthActionPerformned

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
//        cyear=year.getSelectedItem().toString();
//        this.Refresh();
    }//GEN-LAST:event_yearActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Airline;
    private javax.swing.JButton add_Add;
    private javax.swing.JButton cancel_Add1;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JTextField destination;
    private javax.swing.JLabel error;
    private javax.swing.JTextField flightNum;
    private javax.swing.JComboBox<String> h1;
    private javax.swing.JComboBox<String> h2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JSpinner price;
    private javax.swing.JSpinner seatnum;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
