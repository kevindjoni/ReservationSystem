package pkgfinal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Freeware Sys
 */
public class scheduleTable extends javax.swing.JFrame 
{
    private String date;
    private boolean isLogin = false;
    private Control c;
    
    public scheduleTable()
    {
        initComponents();
        table1.getTableHeader().setReorderingAllowed(false);
        isLogin = true;
        // initialize flight schedule
        c = new Control();
        String command = "SELECT * FROM `flight`";
        table1.setModel(c.fillTable(isLogin, command));
        
        
        showDate();
        showTime();
        
        
    }
    
    void showDate()
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        dateL.setText(sdf.format(d));
        date = sdf.format(d);
    }
    
    void showTime()
    {
        Timer timer=new Timer(0, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date d = new Date(); 
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String a=sdf.format(d);
                timeL.setText(a);
            }
        });
        timer.start();
//        String time1 = timeL.getText();
//        System.out.println("LALALALLA"+timeL.getText());
//        hour1=time1.substring(0, 2);
//        minute1=time.substring(3, 4);
//        hour=Integer.parseInt(hour1);
//        month=Integer.parseInt(minute1);
    }

    public boolean isIsLogin() {
        return isLogin;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel_Date = new javax.swing.JLabel();
        jLabel_Time = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        dateL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        add_Admin = new javax.swing.JButton();
        edit_Admin = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        search_Label = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        viewUser = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SearchOrigin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SearchDestination = new javax.swing.JTextField();
        logout = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 28)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Flight Schedule");

        jLabel_Date.setText("Date:");

        jLabel_Time.setText("Time:");

        timeL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeL.setText("time");

        dateL.setText("date");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Airline", "Flight No.", "ETD", "ETA"
            }
        ));
        jScrollPane1.setViewportView(table1);

        add_Admin.setText("Add");
        add_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_AdminActionPerformed(evt);
            }
        });

        edit_Admin.setText("Edit");
        edit_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_AdminActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        search_Label.setText("Search:");

        jTextField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SearchActionPerformed(evt);
            }
        });
        jTextField_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchKeyReleased(evt);
            }
        });

        viewUser.setText("View Users");
        viewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserActionPerformed(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 51, 51));

        jLabel1.setText("Origin:");

        SearchOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOriginActionPerformed(evt);
            }
        });
        SearchOrigin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchOriginKeyReleased(evt);
            }
        });

        jLabel2.setText("Destination:");

        SearchDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchDestinationActionPerformed(evt);
            }
        });
        SearchDestination.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchDestinationKeyReleased(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(add_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Date)
                            .addComponent(search_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Time)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Search)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SearchOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(50, 50, 50)
                                        .addComponent(SearchDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(dateL)
                    .addComponent(jLabel_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SearchOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(SearchDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(add_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edit_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refresh)
                    .addComponent(viewUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchActionPerformed

    private void add_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_AdminActionPerformed
        // add button
        addTable_Admin add = new addTable_Admin(date,this);
        add.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_AdminActionPerformed

    private void edit_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_AdminActionPerformed
            int row = table1.getSelectedRow();
            int id = Integer.parseInt(table1.getValueAt(row, 0).toString());
            ArrayList<String> arr = new ArrayList<>();
            
            // 0 = target
            // 1 = flightnum
            // 2 = airline
            // 3 = etd
            // 4 = eta
            // 5 = seats
            // 6 = destination
            // 7 = origin
            // 8 = date
            // 9  = price

            for(int z=0;z<10;z++)
            {
                arr.add( table1.getValueAt(row, z).toString() );
            }
            
            editTable_Admin ed = new editTable_Admin(arr,this,id);
            ed.setVisible(true);
    }//GEN-LAST:event_edit_AdminActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        c.tryRefresh(isLogin, date);
        table1.setModel(c.fillTable(this.isLogin,"SELECT * FROM `flight`"));
    }//GEN-LAST:event_refreshActionPerformed

    private void jTextField_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchKeyReleased
        // TODO add your handling code here:
        String q = "SELECT * FROM `flight` WHERE `flight number` LIKE '%" + jTextField_Search.getText() + "%' OR `airline` LIKE '%" + jTextField_Search.getText() + "%'";
        table1.setModel(c.fillTable(isLogin, q));
    }//GEN-LAST:event_jTextField_SearchKeyReleased

    private void SearchDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchDestinationActionPerformed

    private void SearchOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchOriginActionPerformed

    private void SearchOriginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchOriginKeyReleased
        String txt = "SELECT * FROM `flight` WHERE `destination` LIKE '%" + SearchDestination.getText() + "%' AND `origin` LIKE '%" + SearchOrigin.getText() + "%'";
        table1.setModel(c.fillTable(isLogin,txt));
    }//GEN-LAST:event_SearchOriginKeyReleased

    private void SearchDestinationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchDestinationKeyReleased
        String txt = "SELECT * FROM `flight` WHERE `destination` LIKE '%" + SearchDestination.getText() + "%' AND `origin` LIKE '%" + SearchOrigin.getText() + "%'";
        table1.setModel(c.fillTable(isLogin,txt));
    }//GEN-LAST:event_SearchDestinationKeyReleased

    private void viewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserActionPerformed
        viewUser vu = new viewUser(this);
        vu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewUserActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchDestination;
    private javax.swing.JTextField SearchOrigin;
    private javax.swing.JButton add_Admin;
    private javax.swing.JLabel dateL;
    private javax.swing.JButton edit_Admin;
    private javax.swing.JLabel error;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_Time;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Search;
    private javax.swing.JButton logout;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel search_Label;
    private javax.swing.JTable table1;
    private javax.swing.JLabel timeL;
    private javax.swing.JButton viewUser;
    // End of variables declaration//GEN-END:variables
}