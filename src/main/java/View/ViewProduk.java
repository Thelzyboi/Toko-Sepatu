/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Implements.ProdukImplements;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import Pojo.Produk;
import Service.ProdukService;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DARARI
 */
public class ViewProduk extends javax.swing.JFrame {

    ProdukService produkService;

    public ViewProduk() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
    }

    public void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }

    private void emptyField() {
        txtIdProduk.setText("");
        txtnamaProduk.setText("");
        txtQty.setText("");
        txtHarga.setText("");

    }

    private void loadData() {
        produkService = new ProdukImplements();
        List<Produk> listProduk = new ArrayList<>();
        listProduk = produkService.findAll();
        Object[][] objectProduk = new Object[listProduk.size()][5];

        int counter = 0;
        for (Produk produk : listProduk) {
            objectProduk[counter][0] = produk.getId();
            objectProduk[counter][1] = produk.getNamaProduk();
            objectProduk[counter][2] = produk.getKategori();
            objectProduk[counter][3] = produk.getQuantity();
            objectProduk[counter][4] = produk.getHarga();

            counter++;
        }
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
                objectProduk,
                new String[]{
                    "ID", "NamaProduk", "Kategori", " Quantity", "Harga"
                }
        ));
    }

    private void loadData(Produk produk) {
        Object[][] objectProduk = new Object[1][5];

        objectProduk[0][0] = produk.getId();
        objectProduk[0][1] = produk.getNamaProduk();
        objectProduk[0][2] = produk.getKategori();
        objectProduk[0][3] = produk.getQuantity();
        objectProduk[0][4] = produk.getHarga();

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
                objectProduk,
                new String[]{
                    "ID", "NamaProduk", "Kategori", " Quantity", "Harga"
                }
        ));
    }

    private Produk finProduk(String id) {
        Produk produk = new Produk();
        produkService = new ProdukImplements();
        produk = produkService.findById(id);

        return produk;
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
        btnBack = new javax.swing.JButton();
        lblShoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblHarga = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        lblQty = new javax.swing.JLabel();
        cmbProduk = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        txtnamaProduk = new javax.swing.JTextField();
        lblNamaProduk = new javax.swing.JLabel();
        txtIdProduk = new javax.swing.JTextField();
        lblIdProduk = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();
        lblController = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 90, -1));

        lblShoes.setBackground(new java.awt.Color(255, 255, 255));
        lblShoes.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lblShoes.setForeground(new java.awt.Color(0, 0, 0));
        lblShoes.setText("PRODUCT DASHBOARD");
        jPanel1.add(lblShoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        tblProduk.setBackground(new java.awt.Color(255, 255, 255));
        tblProduk.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tblProduk.setForeground(new java.awt.Color(0, 0, 0));
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduk);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 578, 480));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHarga.setBackground(new java.awt.Color(255, 255, 255));
        lblHarga.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(0, 0, 0));
        lblHarga.setText("Harga");
        jPanel2.add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 120, -1));

        txtHarga.setBackground(new java.awt.Color(255, 255, 255));
        txtHarga.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        txtHarga.setForeground(new java.awt.Color(0, 0, 0));
        txtHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        jPanel2.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, -1));

        txtQty.setBackground(new java.awt.Color(255, 255, 255));
        txtQty.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        txtQty.setForeground(new java.awt.Color(0, 0, 0));
        txtQty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel2.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, -1));

        lblQty.setBackground(new java.awt.Color(255, 255, 255));
        lblQty.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblQty.setForeground(new java.awt.Color(0, 0, 0));
        lblQty.setText("QTY");
        jPanel2.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, -1));

        cmbProduk.setBackground(new java.awt.Color(255, 255, 255));
        cmbProduk.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        cmbProduk.setForeground(new java.awt.Color(0, 0, 0));
        cmbProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Converse", "Heels", "Sneakers", "Boots", "Sandals" }));
        jPanel2.add(cmbProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        lblCategory.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(0, 0, 0));
        lblCategory.setText("Kategori");
        jPanel2.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, -1));

        txtnamaProduk.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaProduk.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        txtnamaProduk.setForeground(new java.awt.Color(0, 0, 0));
        txtnamaProduk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtnamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaProdukActionPerformed(evt);
            }
        });
        jPanel2.add(txtnamaProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, -1));

        lblNamaProduk.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaProduk.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblNamaProduk.setForeground(new java.awt.Color(0, 0, 0));
        lblNamaProduk.setText("Nama Produk");
        jPanel2.add(lblNamaProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, -1));

        txtIdProduk.setBackground(new java.awt.Color(255, 255, 255));
        txtIdProduk.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        txtIdProduk.setForeground(new java.awt.Color(0, 0, 0));
        txtIdProduk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdukActionPerformed(evt);
            }
        });
        jPanel2.add(txtIdProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));

        lblIdProduk.setBackground(new java.awt.Color(255, 255, 255));
        lblIdProduk.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblIdProduk.setForeground(new java.awt.Color(0, 0, 0));
        lblIdProduk.setText("ID");
        jPanel2.add(lblIdProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        btnCreate.setBackground(new java.awt.Color(0, 0, 0));
        btnCreate.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel2.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setText("CRUD");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, 30));

        btnSearch1.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch1.setText("SEARCH");
        btnSearch1.setBorder(null);
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 370, 470));

        lblController.setBackground(new java.awt.Color(255, 255, 255));
        lblController.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblController.setForeground(new java.awt.Color(0, 0, 0));
        lblController.setText("CONTROLLER");
        jPanel1.add(lblController, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void txtIdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdukActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id, nama, kategori;
        double harga;
        int quantity;
        produkService = new ProdukImplements();

        id = txtIdProduk.getText();
        nama = txtnamaProduk.getText();
        quantity = Integer.parseInt(txtQty.getText());
        harga = Double.parseDouble(txtHarga.getText());

        kategori = cmbProduk.getSelectedItem().toString();

        Produk produk = new Produk();
        produk.setId(id);
        produk.setNamaProduk(nama);
        produk.setKategori(kategori);
        produk.setQuantity(quantity);
        produk.setHarga(harga);

        produkService.update(produk);
        JOptionPane.showMessageDialog(null, "Data produk updated successfully");
        loadData();
        emptyField();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        emptyField();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String id, nama, kategori;
        double harga;
        int quantity;
        produkService = new ProdukImplements();

        id = txtIdProduk.getText();
        nama = txtnamaProduk.getText();
        quantity = Integer.parseInt(txtQty.getText());
        harga = Double.parseDouble(txtHarga.getText());

        kategori = cmbProduk.getSelectedItem().toString();

        Produk produk = new Produk();
        produk.setId(id);
        produk.setNamaProduk(nama);
        produk.setKategori(kategori);
        produk.setQuantity(quantity);
        produk.setHarga(harga);

        produkService.create(produk);
        JOptionPane.showMessageDialog(null, "Data produk created successfully");
        loadData();
        emptyField();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String id;
        produkService = new ProdukImplements();
        int dialogButton = JOptionPane.YES_NO_OPTION;

        id = txtIdProduk.getText();

        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete it?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            produkService.delete(id);
            loadData();
            emptyField();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        String id, nama, kategori;
        double harga;
        int quantity;

        int row = tblProduk.getSelectedRow();
        id = tblProduk.getValueAt(row, 0).toString();
        nama = tblProduk.getValueAt(row, 1).toString();
        kategori = tblProduk.getValueAt(row, 2).toString();
        quantity = Integer.parseInt(tblProduk.getValueAt(row, 3).toString());
        harga = Double.parseDouble(tblProduk.getValueAt(row, 4).toString());

        txtIdProduk.setText(id + "");
        txtnamaProduk.setText(nama);
        cmbProduk.setSelectedItem(kategori);
        txtQty.setText(quantity + "");
        txtHarga.setText(harga + "");


    }//GEN-LAST:event_tblProdukMouseClicked

    private void txtnamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaProdukActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String id;
        Produk searchProduk = new Produk();

        id = txtSearch.getText();
        searchProduk = finProduk(id);
        if (searchProduk != null) {
            loadData(searchProduk);
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbProduk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblController;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblIdProduk;
    private javax.swing.JLabel lblNamaProduk;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblShoes;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdProduk;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtnamaProduk;
    // End of variables declaration//GEN-END:variables

    private void groupButton() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
