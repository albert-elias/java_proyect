/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Control.Clientes_C;
import Ventanas.DetalleVentas_V;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class vista_clientes extends javax.swing.JFrame {

    /**
     * Creates new form vista_clientes
     */
    public vista_clientes() {
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

        jbselect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtclient = new javax.swing.JTable();
        jbsearch = new javax.swing.JButton();
        jtfsearch = new javax.swing.JTextField();
        jbcancel = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbselect.setText("Seleccionar");
        jbselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbselectActionPerformed(evt);
            }
        });

        jtclient = new JTable() {

            public boolean isCellEditable(int row, int column) {

                for (int i = 0; i < jtclient.getRowCount(); i++) {

                    if (row == i) {

                        return false;

                    }

                }

                return true;

            }

        };
        jtclient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente"
            }
        ));
        jtclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtclientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtclient);

        jbsearch.setText("Bucar");
        jbsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsearchActionPerformed(evt);
            }
        });

        jbcancel.setText("Cancelar");
        jbcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbselect)
                        .addGap(36, 36, 36)
                        .addComponent(jbcancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbsearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbselect)
                    .addComponent(jbcancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbselectActionPerformed

        nombre = jTextField1.getText();
        name = jtfsearch.getText();
        DetalleVentas_V.tfcliente.setText(nombre);
        DetalleVentas_V.tfclientename.setText(name);
        dispose();

    }//GEN-LAST:event_jbselectActionPerformed

    private void jtclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtclientMouseClicked

        dtm = (DefaultTableModel) this.jtclient.getModel();
        int selRow = this.jtclient.getSelectedRow();

        if (evt.getClickCount() == 2) {

            String id = jtclient.getValueAt(selRow, 0).toString();
            Clientes_C finded = c.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(String.valueOf(finded.getNombre()));
            name = jtfsearch.getText();
            nombre = jTextField1.getText();
            DetalleVentas_V.tfcliente.setText(nombre);
            DetalleVentas_V.tfclientename.setText(name);
            this.dispose();

        } else {

            String id = String.valueOf(jtclient.getValueAt(selRow, 0).toString());
            Clientes_C finded = c.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(finded.getNombre());

        }

    }//GEN-LAST:event_jtclientMouseClicked

    private void jbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsearchActionPerformed

        consult(jtfsearch.getText());

    }//GEN-LAST:event_jbsearchActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed

        this.dispose();

    }//GEN-LAST:event_jbcancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        star();
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(vista_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbsearch;
    private javax.swing.JButton jbselect;
    private javax.swing.JTable jtclient;
    private javax.swing.JTextField jtfsearch;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel dtm;
    private String nombre, name;
    private final Clientes_C c = new Clientes_C();
    
    public void consult (String search) {
    
        DefaultTableModel model = c.Consult(search);
        jtclient.setModel(model);
    
    }
    
    public void star () {
        
        dtm = (DefaultTableModel) jtclient.getModel();
        ArrayList<Clientes_C> all = c.SearchAll();
        
        for(int i = 0; i < all.size(); i++ ){
            
            dtm.addRow(new Object[]{all.get(i).getId(), all.get(i).getNombre()});
            
        }
    
    }

}
