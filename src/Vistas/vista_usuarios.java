/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Ventanas.Cargar_Funcionarios;
import Control.CargosC;
import Control.Usuarios_C;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class vista_usuarios extends javax.swing.JFrame {

    /**
     * Creates new form vista_cargos
     */
    public vista_usuarios(java.awt.Frame parent, boolean modal) {
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

        jtfsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtoffice = new javax.swing.JTable();
        jbsearch = new javax.swing.JButton();
        jbcancel = new javax.swing.JButton();
        jbselect = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtoffice = new JTable() {

            public boolean isCellEditable(int row, int column) {

                for (int i = 0; i < jtoffice.getRowCount(); i++) {

                    if (row == i) {

                        return false;

                    }

                }

                return true;

            }

        };
        jtoffice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtoffice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtofficeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtoffice);

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

        jbselect.setText("Seleccionar");
        jbselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbselectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbselect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbcancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbsearch)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbselect)
                    .addComponent(jbcancel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtofficeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtofficeMouseClicked

        dtm = (DefaultTableModel) this.jtoffice.getModel();
        int selRow = this.jtoffice.getSelectedRow();

        if (evt.getClickCount() == 2) {

            String id = String.valueOf(jtoffice.getValueAt(selRow, 0).toString());
            Usuarios_C finded = u.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(String.valueOf(finded.getUsuario()));
            name = jtfsearch.getText();
            nombre = jTextField1.getText();
            Cargar_Funcionarios.tfuser.setText(nombre);
            Cargar_Funcionarios.tfusername.setText(name);
            this.dispose();

        } else {

            String id = String.valueOf(jtoffice.getValueAt(selRow, 0).toString());
            Usuarios_C finded = u.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(finded.getUsuario());

        }

    }//GEN-LAST:event_jtofficeMouseClicked

    private void jbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsearchActionPerformed

        consult(jtfsearch.getText());

    }//GEN-LAST:event_jbsearchActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed

        this.dispose();

    }//GEN-LAST:event_jbcancelActionPerformed

    private void jbselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbselectActionPerformed

        nombre = jTextField1.getText();
        name = jtfsearch.getText();
        Cargar_Funcionarios.tfuser.setText(nombre);
        Cargar_Funcionarios.tfusername.setText(name);
        dispose();

    }//GEN-LAST:event_jbselectActionPerformed

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
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vista_usuarios dialog = new vista_usuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbsearch;
    private javax.swing.JButton jbselect;
    private javax.swing.JTextField jtfsearch;
    private javax.swing.JTable jtoffice;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel dtm;
    private String name, nombre;
    private final Usuarios_C u = new Usuarios_C();

    public void consult (String search) {
    
        DefaultTableModel model = u.Consult(search);
        jtoffice.setModel(model);
    
    }
    
    public void star () {
        
        dtm = (DefaultTableModel) jtoffice.getModel();
        ArrayList<Usuarios_C> all = u.SearchAll();
        
        for(int i = 0; i < all.size(); i++ ){
            
            dtm.addRow(new Object[]{all.get(i).getId(), all.get(i).getUsuario()});
            
        }
    
    }
    
}
