/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Alpro02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BRAVO 15
 */
public class BRILIamWMS extends javax.swing.JFrame {

    /**
     * Creates new form BRILIamWMS
     */
    public BRILIamWMS() {
        initComponents();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] { "Code", "Name", "Qty", "Price" }
    ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Inbound");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Outbound");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Adjustment Stock");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("File txt");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("System Gudang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton7))
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel2)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tambahBarang();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        kurangiBarang();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        editBarang();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        printKeFileTxt();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tambahBarang() {
    String kode = JOptionPane.showInputDialog(this, "Masukkan Kode Barang:");
    String nama = JOptionPane.showInputDialog(this, "Masukkan Nama Barang:");
    String qtyStr = JOptionPane.showInputDialog(this, "Masukkan Jumlah Barang:");
    String hargaStr = JOptionPane.showInputDialog(this, "Masukkan Harga Barang:");

    try {
        int qty = Integer.parseInt(qtyStr);
        double harga = Double.parseDouble(hargaStr);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        boolean found = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(kode)) {
                int qtyLama = Integer.parseInt(model.getValueAt(i, 2).toString());
                model.setValueAt(qtyLama + qty, i, 2);
                found = true;
                break;
            }
        }

        if (!found) {
            model.addRow(new Object[]{kode, nama, qty, harga});
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Input angka tidak valid.");
    }
}

private void kurangiBarang() {
    String kode = JOptionPane.showInputDialog(this, "Masukkan Kode Barang:");
    String qtyStr = JOptionPane.showInputDialog(this, "Jumlah Barang yang Keluar:");

    try {
        int qty = Integer.parseInt(qtyStr);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(kode)) {
                int qtyLama = Integer.parseInt(model.getValueAt(i, 2).toString());
                if (qtyLama >= qty) {
                    model.setValueAt(qtyLama - qty, i, 2);
                } else {
                    JOptionPane.showMessageDialog(this, "Stok tidak mencukupi.");
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Barang tidak ditemukan.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Input angka tidak valid.");
    }
}

private void editBarang() {
    String kode = JOptionPane.showInputDialog(this, "Masukkan Kode Barang yang ingin diedit:");
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0).equals(kode)) {
            String namaBaru = JOptionPane.showInputDialog(this, "Nama baru:", model.getValueAt(i, 1));
            String qtyBaruStr = JOptionPane.showInputDialog(this, "Qty baru:", model.getValueAt(i, 2));
            String hargaBaruStr = JOptionPane.showInputDialog(this, "Harga baru:", model.getValueAt(i, 3));

            try {
                int qtyBaru = Integer.parseInt(qtyBaruStr);
                double hargaBaru = Double.parseDouble(hargaBaruStr);

                model.setValueAt(namaBaru, i, 1);
                model.setValueAt(qtyBaru, i, 2);
                model.setValueAt(hargaBaru, i, 3);

                return;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Input angka tidak valid.");
                return;
            }
        }
    }

    JOptionPane.showMessageDialog(this, "Barang tidak ditemukan.");
}

private void printKeFileTxt() {
    try {
        FileWriter writer = new FileWriter("data_barang.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String kode = model.getValueAt(i, 0).toString();
            String nama = model.getValueAt(i, 1).toString();
            String qty = model.getValueAt(i, 2).toString();
            String harga = model.getValueAt(i, 3).toString();

            String line = kode + " | " + nama + " | " + qty + " | " + harga;
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        writer.close();

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke file data_barang.txt");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file: " + e.getMessage());
    }
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
            java.util.logging.Logger.getLogger(BRILIamWMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BRILIamWMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BRILIamWMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BRILIamWMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BRILIamWMS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
