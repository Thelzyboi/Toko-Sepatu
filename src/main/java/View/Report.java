/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Pojo.MonthSetting;
import Pojo.PieChart;
import Pojo.PieChartUI;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilities.ConnectionManager;

/**
 *
 * @author User
 */
public class Report extends javax.swing.JFrame {
    private ConnectionManager conMan;
    private Connection conn;
    PieChartUI pieChartUi = new PieChartUI();
    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox<>();
        cmbMonth = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("INCOME EXPENSE PIE CHART REPORT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel1.setText("Year");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        jLabel3.setText("Month");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, -1));

        cmbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearActionPerformed(evt);
            }
        });
        jPanel1.add(cmbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });
        jPanel1.add(cmbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            conMan = new ConnectionManager();
            conn = conMan.connect();
            showYear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearActionPerformed
        // TODO add your handling code here:
        if (cmbYear.getSelectedIndex()>=0) {
            int year = Integer.valueOf(cmbYear.getSelectedItem().toString());
            try {
                cmbMonth.removeAllItems();
                showMonth(year);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cmbYearActionPerformed

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        // TODO add your handling code here:
        if (cmbMonth.getSelectedIndex()>=0) {
            int year= Integer.valueOf(cmbYear.getSelectedItem().toString());
            MonthSetting month = (MonthSetting)cmbMonth.getSelectedItem();
            showData(year, month.getMonth());
        }
    }//GEN-LAST:event_cmbMonthActionPerformed

    private void showYear() throws SQLException{
        conMan = new ConnectionManager();
        conn = conMan.connect();
        Statement stmt;
        ResultSet rs;
        String sql = "SELECT DATE_FORMAT(transaksi.tanggal, '%Y') AS YearNumber from transaksi GROUP BY YearNumber";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int year = rs.getInt("YearNumber");
            cmbYear.addItem(year+"");
        }
    }
    
    private void showMonth(int year) throws SQLException{
        conMan = new ConnectionManager();
        conn = conMan.connect();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT DATE_FORMAT(transaksi.tanggal, '%M') AS MonthText, DATE_FORMAT(transaksi.tanggal, '%m') AS MonthNumber FROM transaksi WHERE DATE_FORMAT(transaksi.tanggal, '%Y')=? GROUP BY MonthNumber";
        ps = conMan.connect().prepareStatement(sql);
        ps.setInt(1, year);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            String monthText = rs.getString("MonthText");
            int month = rs.getInt("MonthNumber");
            cmbMonth.addItem(new MonthSetting(month, monthText));
        }
    }
    
    private void showData(int year, int month){
        PreparedStatement ps;
        ResultSet rs;
        try {
            pieChartUi.clearData();
            ps = conMan.connect().prepareStatement("SELECT transaksi.id_produk, SUM(total) FROM transaksi WHERE DATE_FORMAT(transaksi.tanggal, '%Y')=? AND DATE_FORMAT(transaksi.tanggal, '%m')=? GROUP BY transaksi.id_transaksi");
            ps.setInt(1, year);
            ps.setInt(2, month);
            rs = ps.executeQuery();
            int index = 0;
            while(rs.next()){
                String idProduk = rs.getString(1);
                double values = rs.getDouble(2);
                pieChartUi.addData(new PieChart(idProduk, values, getColor(index++)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Color getColor(int index){
        Color[] color = new Color[]{new Color(255,102,102),new Color(58,55,227),new Color(29,184,85),new Color(94,217,214),new Color(43,45,250),new Color(200,169,86)};
        return color[index];
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<Object> cmbMonth;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
