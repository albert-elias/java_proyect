/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import Conexion.ConexionRapida;
import Control.Ciudades_C;
import Ventanas.Clientes_V;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class vista_ciudades extends javax.swing.JFrame {

    /**
     * Creates new form vistas_ciudades
     */
    public vista_ciudades(java.awt.Frame parent, boolean modal) {
        
        ConexionRapida.getInstanciaConexion();
        initComponents();
//        star();
        
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
        jbsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcity = new javax.swing.JTable();
        jbselect = new javax.swing.JButton();
        jbcancel = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cunsultar ciudad");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbsearch.setText("Bucar");
        jbsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsearchActionPerformed(evt);
            }
        });

        jtcity = new JTable() {

            public boolean isCellEditable(int row, int column) {

                for (int i = 0; i < jtcity.getRowCount(); i++) {

                    if (row == i) {

                        return false;

                    }

                }

                return true;

            }

        };
        jtcity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Ciudad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtcity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtcityMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtcity);
        if (jtcity.getColumnModel().getColumnCount() > 0) {
            jtcity.getColumnModel().getColumn(0).setMaxWidth(50);
            jtcity.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jbselect.setText("Seleccionar");
        jbselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbselectActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbselect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbselect)
                            .addComponent(jbcancel))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsearchActionPerformed
        
        consult(jtfsearch.getText());
        
        
    }//GEN-LAST:event_jbsearchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.star();
        this.jTextField1.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void jtcityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcityMouseClicked
        
        dtmciudad = (DefaultTableModel) this.jtcity.getModel();
        int selRow = this.jtcity.getSelectedRow();
        
        if (evt.getClickCount() == 2) {
            
            String id = jtcity.getValueAt(selRow, 0).toString();
            Ciudades_C finded = c.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(String.valueOf(finded.getName()));
            name = jtfsearch.getText();
            nombre = jTextField1.getText();
            Clientes_V.jtfcodciu.setText(nombre);
            Clientes_V.jtfresult.setText(name);
            this.dispose();
            
        } else {
            
            String id = String.valueOf(jtcity.getValueAt(selRow, 0).toString());
            Ciudades_C finded = c.Search(id);
            jTextField1.setText(String.valueOf(finded.getId()));
            jtfsearch.setText(finded.getName());
        
        }
        
    }//GEN-LAST:event_jtcityMouseClicked

    private void jbselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbselectActionPerformed
        
        nombre = jTextField1.getText();
        name = jtfsearch.getText();
        Clientes_V.jtfcodciu.setText(nombre);
        Clientes_V.jtfresult.setText(name);
        dispose();
        
        
    }//GEN-LAST:event_jbselectActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbcancelActionPerformed

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
            java.util.logging.Logger.getLogger(vista_ciudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_ciudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_ciudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_ciudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vista_ciudades dialog = new vista_ciudades(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jtcity;
    private javax.swing.JTextField jtfsearch;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel dtmciudad;
    private String nombre, name;
    private final Ciudades_C c = new Ciudades_C();
    
    public void consult (String search) {
    
        update();
        ArrayList<Ciudades_C> all = c.Consult(search);
        for(int i = 0; i < all.size(); i++ ){
            
            dtmciudad.addRow(new Object[]{all.get(i).getId(), all.get(i).getName()});
            
        }
    
    }
    
    public void star () {
        
        dtmciudad = (DefaultTableModel) jtcity.getModel();
        ArrayList<Ciudades_C> all = c.SearchAll();
        
        for(int i = 0; i < all.size(); i++ ){
            
            dtmciudad.addRow(new Object[]{all.get(i).getId(), all.get(i).getName()});
            
        }
    
    }

    private void update () {
        
        int tam = jtcity.getRowCount();
        
        for (int i = 0; i < tam; i++) {
            
            dtmciudad.removeRow(0);
            
        }
        
    }

}
