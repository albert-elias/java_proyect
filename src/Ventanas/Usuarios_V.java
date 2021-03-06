/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Control.TipoUsuario_C;
import Control.Usuarios_C;
import ContolesVista.vista_usuarios;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Usuarios_V extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios_V
     */
    public Usuarios_V() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtuser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfcode = new javax.swing.JTextField();
        jtfuser = new javax.swing.JTextField();
        jtfpass = new javax.swing.JTextField();
        jcbtu = new javax.swing.JComboBox();
        jbsave = new javax.swing.JButton();
        jndelete = new javax.swing.JButton();
        jbupdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        breport = new javax.swing.JButton();
        jbexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("USUARIOS");

        jtuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Usuario", "Clave", "Tipo de Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtuserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtuser);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 12, 0, 12, 0, 12, 0};
        jPanel2Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel2.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Tipo de usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel5, gridBagConstraints);

        jtfcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfcodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfcodeKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jtfcode, gridBagConstraints);

        jtfuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfuserKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jtfuser, gridBagConstraints);

        jtfpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfpassKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jtfpass, gridBagConstraints);

        jcbtu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbtuKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 31;
        jPanel2.add(jcbtu, gridBagConstraints);

        jbsave.setText("Guardar");
        jbsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        jPanel2.add(jbsave, gridBagConstraints);

        jndelete.setText("Eliminar");
        jndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jndeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.4;
        jPanel2.add(jndelete, gridBagConstraints);

        jbupdate.setText("Modificar");
        jbupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbupdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jbupdate, gridBagConstraints);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0};
        jPanel1Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel1.setLayout(jPanel1Layout);

        breport.setText("Ver Reporte");
        breport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel1.add(breport, gridBagConstraints);

        jbexit.setText("Salir");
        jbexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbexitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        jPanel1.add(jbexit, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbupdateActionPerformed
        
        cod = getInt(jtfcode.getText());
        t_u = getInt(String.valueOf(this.jcbtu.getSelectedIndex()));
        name = jtfuser.getText();
        password = jtfpass.getText();
        
        Usuarios_C mc1 = new Usuarios_C(cod, name, password, t_u);
        if(mc1.Update()){
            
            JOptionPane.showMessageDialog(rootPane, "Registro modficado");
            this.updateUser();
            this.starUser();
            this.updateTipoUsuario();
            
        } else {
            
            JOptionPane.showMessageDialog(rootPane, "No modificado");
            
        }
        
    }//GEN-LAST:event_jbupdateActionPerformed

    private void jbexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexitActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jbexitActionPerformed

    private void jtuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtuserMouseClicked
        
        dtmuser = (DefaultTableModel) this.jtuser.getModel();
        int selRow = this.jtuser.getSelectedRow();
        Usuarios_C c = new Usuarios_C();
        
        if(selRow != -1){
            
            String id = String.valueOf(dtmuser.getValueAt(selRow, 0).toString());
            Usuarios_C finded = c.Search(id);
            
            if(!(finded == null)){
                
                this.jtfcode.setText(String.valueOf(finded.getId()));
                this.jcbtu.setSelectedIndex(finded.getTipo_usuario()-1);
                this.jtfpass.setText(finded.getClave());
                this.jtfuser.setText(finded.getUsuario());
                
             }
            
        }
        
    }//GEN-LAST:event_jtuserMouseClicked

    private void jbsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsaveActionPerformed
        
        cod = getInt(jtfcode.getText());
        t_u = getInt(String.valueOf(this.jcbtu.getSelectedIndex()+1));
        name = jtfuser.getText();
        password = jtfpass.getText();
        
        if ((cod <= 0) || (t_u <= 0) || (name.equals("") || (password.equals("")))) {
            
            JOptionPane.showMessageDialog(rootPane, "No registrada \nComplete todos los campos");
            
        } else {
            
            Usuarios_C cc = new Usuarios_C(cod, name, password, t_u);
            Usuarios_C ok = cc.Search(String.valueOf(cod));
            
            if (ok == null) {
                
                if (cc.Insert()) {
                    
                    JOptionPane.showMessageDialog(rootPane, "Registrado con exito");
                    
                } else {
                    
                    JOptionPane.showMessageDialog(rootPane, "No registrado \n Complete los campos");
                    
                }
                
            } else {
                
                JOptionPane.showMessageDialog(rootPane, "Ya existe");
                jtfcode.setText(String.valueOf(ok.getId()));
                jcbtu.setSelectedItem(String.valueOf(ok.getTipo_usuario()));
                jtfuser.setText(ok.getUsuario());
                jtfpass.setText(ok.getClave());
                
            }
            
            dtmuser = (DefaultTableModel) jtuser.getModel();
            int rows = jtuser.getRowCount();
            for (int i = 0; rows > i; i++) {
                
                dtmuser.removeRow(0);
                
            }
            
            this.updateUser();
            this.updateTipoUsuario();
            this.starUser();
            
        }
        
    }//GEN-LAST:event_jbsaveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.updateTipoUsuario();
        this.updateUser();
        this.starUser();
        this.countUser();

    }//GEN-LAST:event_formWindowOpened

    private void jndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jndeleteActionPerformed
        
        String code = jtfcode.getText();
        Usuarios_C us = new Usuarios_C();
        
        if(us.Delete(code)){
            
            JOptionPane.showMessageDialog(this, "Eliminando satisfactoriamente");
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Imposible eliminar");
            
        }
        
        this.updateUser();
        this.updateTipoUsuario();
        this.starUser();
        
    }//GEN-LAST:event_jndeleteActionPerformed

    private void jtfcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcodeKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(jtfcode.getText().equals("")){
                
                jtfcode.requestFocus();
                
            } else {
                
                jtfuser.requestFocus();
                
            }
            
        }
        
    }//GEN-LAST:event_jtfcodeKeyPressed

    private void jtfuserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfuserKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(jtfuser.getText().equals("")){
                
                jtfuser.requestFocus();
                
            } else {
                
                jtfpass.requestFocus();
                
            }
            
        }
        
    }//GEN-LAST:event_jtfuserKeyPressed

    private void jtfpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpassKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(jtfpass.getText().equals("")){
                
                jtfpass.requestFocus();
                
            } else {
                
                jcbtu.requestFocus();
                
            }
            
        }
        
    }//GEN-LAST:event_jtfpassKeyPressed

    private void jcbtuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbtuKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if (this.jcbtu.getSelectedIndex()== -1){
                
                JOptionPane.showMessageDialog(rootPane, "Seleccione el tipo de usuario");
                this.jcbtu.requestFocus();
                
            } else {
                
                if (!(this.jbupdate.isEnabled())){
                    
                    this.jbupdate.requestFocus();
                    
                } else {
                    
                    this.jbsave.setEnabled(true);
                    this.jbsave.requestFocus();
                    
                }
                
            }
            
        }
        
    }//GEN-LAST:event_jcbtuKeyPressed

    private void breportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breportActionPerformed
        
        vu.showUsuarios();

    }//GEN-LAST:event_breportActionPerformed

    private void jtfcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcodeKeyTyped
        
        char numero = evt.getKeyChar();

        if (Character.isLetter(numero)) {

            getToolkit().beep();
            evt.consume();

        }

    }//GEN-LAST:event_jtfcodeKeyTyped

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
            java.util.logging.Logger.getLogger(Usuarios_V.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios_V.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios_V.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios_V.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios_V().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton breport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbexit;
    private javax.swing.JButton jbsave;
    private javax.swing.JButton jbupdate;
    private javax.swing.JComboBox jcbtu;
    private javax.swing.JButton jndelete;
    private javax.swing.JTextField jtfcode;
    private javax.swing.JTextField jtfpass;
    private javax.swing.JTextField jtfuser;
    private javax.swing.JTable jtuser;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel dtmuser;
    public int cod, t_u;
    public String name, password;
    private final Usuarios_C c = new Usuarios_C();
    private final vista_usuarios vu = new vista_usuarios();
    
    private void updateUser() {
        
        int tam = jtuser.getRowCount();
        for (int i = 0; i < tam; i++) {
            
            dtmuser.removeRow(0);
            
        }
        
    }
    
    private void starUser() {
        
        dtmuser = (DefaultTableModel) this.jtuser.getModel();
        ArrayList<vista_usuarios> all = vu.buscarusuario();
        
        for (int i = 0; i <all.size(); i++) {
            
            dtmuser.addRow(new Object[]{all.get(i).getCodigo(), all.get(i).getUsuario(),
            all.get(i).getClave(), all.get(i).getTipo()});
            
        }
        
        TipoUsuario_C tu = new TipoUsuario_C();
        ArrayList<TipoUsuario_C> list = tu.SearchAll();

        for(int i = 0; i < list.size(); i++){

            jcbtu.addItem(String.valueOf(list.get(i).getId()) + " - " + list.get(i).getName());

        }
        
        jcbtu.setSelectedIndex(-1);
        this.jtfcode.setText("");
        this.jtfpass.setText("");
        this.jtfuser.setText("");
        
    }
    
    private void countUser() {
        
        this.jtfcode.setText(c.New());
        this.jcbtu.requestFocus();
        
    }
    
    private void updateTipoUsuario() {
        
        int us = jcbtu.getItemCount();
        
        for (int i = 0; i < us; i++) {
            
            jcbtu.removeItemAt(0);
            
        }
        
    }
    
    public static Integer getInt(String cadena){

        return ( (cadena == null || cadena.isEmpty() ) ? 0 : Integer.parseInt(cadena.trim()));

    }

}