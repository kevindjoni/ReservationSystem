package pkgfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freeware Sys
 */
public class transaction extends javax.swing.JFrame 
{
    private Statement st;
    private Object[] obj = null;
    
    public void fillTable(String query)
    {
        try 
        {
            ResultSet rs;
            DefaultTableModel table = new DefaultTableModel();
            rs = st.executeQuery(query);
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
            transactionTable.setModel(table);
        } 
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }
    
    public transaction()
    {
        initComponents();
    }
    
    public transaction(Statement st) 
    {
        initComponents();
        this.st = st;
        showDate();
        showTime();
        try 
        {
            ResultSet rs;
            DefaultTableModel table = new DefaultTableModel();
            rs = st.executeQuery("SELECT * FROM `transactions`");
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
            transactionTable.setModel(table);
        } 
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }
    
    void showDate()
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        dateT.setText(sdf.format(d));
    }
    
    void showTime()
    {
        new Timer(0, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                timeT.setText(sdf.format(d));
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timeT = new javax.swing.JLabel();
        dateT = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        search_transaction = new javax.swing.JTextField();
        backTransaction = new javax.swing.JButton();
        printTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaction");

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Booking Code", "No. of Tickets", "Booking Name", "Flight ID"
            }
        ));
        jScrollPane1.setViewportView(transactionTable);
        if (transactionTable.getColumnModel().getColumnCount() > 0) {
            transactionTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setText("Date:");

        jLabel3.setText("Time:");

        timeT.setText("time");

        dateT.setText("date");

        jLabel6.setText("Search:");

        search_transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_transactionActionPerformed(evt);
            }
        });

        backTransaction.setText("Flight Schedule");
        backTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTransactionActionPerformed(evt);
            }
        });

        printTicket.setText("Print Ticket(s)");
        printTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_transaction))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(printTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timeT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_transaction)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backTransaction)
                    .addComponent(printTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_transactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_transactionActionPerformed

    private void backTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTransactionActionPerformed
        scheduleTable_Staff t = new scheduleTable_Staff(st);
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backTransactionActionPerformed

    private void printTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTicketActionPerformed
//        int row = transactionTable.getSelectedRow();
//        int target = (int) transactionTable.getValueAt(row, 0);
//        String bookingCode = (String) transactionTable.getValueAt(row, 1);
//        String ticNum = (String) transactionTable.getValueAt(row, 2);
//        String bookName = (String) transactionTable.getValueAt(row, 3);
//        String eta = (String) scheduleTable_infoTable.getValueAt(row, 4);
//        int seats = (int) scheduleTable_infoTable.getValueAt(row, 5);
//        String destination = (String) scheduleTable_infoTable.getValueAt(row, 6);
//        String origin = (String) scheduleTable_infoTable.getValueAt(row, 7);
//        editTable_Admin ed = new editTable_Admin(target,flightnum,airline,etd,eta,seats,destination,origin,st,this);
//        ed.setVisible(true);
    }//GEN-LAST:event_printTicketActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backTransaction;
    private javax.swing.JLabel dateT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printTicket;
    private javax.swing.JTextField search_transaction;
    private javax.swing.JLabel timeT;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
