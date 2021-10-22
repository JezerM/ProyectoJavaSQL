/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import dao.TablaAutor;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Cisneros
 */
public class FrmAutor extends javax.swing.JFrame {

    TablaAutor tAutor = new TablaAutor();
    boolean esNuevo;
    int idAutor = 0;
    int posActual = 0;
    
    
    public FrmAutor() {
        initComponents();
        mostrarEnTP(posActual);
        this.setLocationRelativeTo(null);
    }

    private void limpiar(){
        esNuevo = true;
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfNombre.requestFocus();
    }
   
    private void mostrarEnTP(int fila){
        if(!tAutor.getLista().isEmpty()){
            tfNombre.setText(tAutor.getLista().get(fila).getNombrePila());
            tfApellido.setText(tAutor.getLista().get(fila).getApellidoPaterno());
            idAutor = tAutor.getLista().get(fila).getIdAutor();
            
            int ultReg = tAutor.getLista().size();
            IContador.setText("" + (fila + 1) + " de " + ultReg);
            tfNombre.requestFocus();
        }else{
            limpiar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        tbBarra = new javax.swing.JToolBar();
        bNuevo = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bAnterior = new javax.swing.JButton();
        IContador = new javax.swing.JLabel();
        bSiguente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        guardarEnBD = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jPanel2 = new javax.swing.JPanel();
        INombre = new javax.swing.JLabel();
        IApellido = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbBarra.setRollover(true);

        bNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Nuevo.png"))); // NOI18N
        bNuevo.setFocusable(false);
        bNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        tbBarra.add(bNuevo);

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Guardar.png"))); // NOI18N
        bGuardar.setFocusable(false);
        bGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        tbBarra.add(bGuardar);

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Eliminar.png"))); // NOI18N
        bEliminar.setFocusable(false);
        bEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        tbBarra.add(bEliminar);
        tbBarra.add(jSeparator1);

        bAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/anterior.png"))); // NOI18N
        bAnterior.setFocusable(false);
        bAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });
        tbBarra.add(bAnterior);

        IContador.setText("0 de 0");
        tbBarra.add(IContador);

        bSiguente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/next.png"))); // NOI18N
        bSiguente.setFocusable(false);
        bSiguente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSiguente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSiguente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguenteActionPerformed(evt);
            }
        });
        tbBarra.add(bSiguente);
        tbBarra.add(jSeparator2);

        guardarEnBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/ActualizarBD.png"))); // NOI18N
        guardarEnBD.setFocusable(false);
        guardarEnBD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarEnBD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardarEnBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEnBDActionPerformed(evt);
            }
        });
        tbBarra.add(guardarEnBD);
        tbBarra.add(jSeparator3);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        INombre.setText("Nombre: ");

        IApellido.setText("Apellido: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(IApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfApellido))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(INombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNombre)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(INombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IApellido)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Datos del usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbBarra, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
            
      if(tfNombre.getText().equals(null)){
          JOptionPane.showMessageDialog(this,"Debe ingresar un nombre","Autor", JOptionPane.WARNING_MESSAGE);
          this.tfNombre.requestFocus();
          return;
      }
      
      if(tfApellido.getText().equals(null)){
          JOptionPane.showMessageDialog(this,"Debe ingresar un apellido","Autor", JOptionPane.WARNING_MESSAGE);
          this.tfApellido.requestFocus();
          return;
      }
      
      int b;
      if(esNuevo){
          b = tAutor.agregarLista(tfNombre.getText(),tfApellido.getText());
      }else{
          b =  tAutor.editarLista(idAutor, tfNombre.getText(), tfApellido.getText());
      }
      
      if(b == 1){
          JOptionPane.showMessageDialog(this,"Registro guardado... ", "Autor", JOptionPane.INFORMATION_MESSAGE);
      }
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        int resp = JOptionPane.showConfirmDialog(this,"Realmente desea eliminar el autor?" + this.tfNombre.getText() + " " 
                        + this.tfApellido.getText() + "?","Autor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resp == 0){
            int b = tAutor.eliminarEnLista(idAutor);
            
            if(b == 1){
                JOptionPane.showMessageDialog(this, "Registro Eliminado sastifactoriamente"
                        + JOptionPane.INFORMATION_MESSAGE);
            }else{
                   JOptionPane.showMessageDialog(this, "Error inesperado, verifique y vuelva a intentar", "Autor",
                           JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        if(posActual == 0){
            posActual = tAutor.getLista().size();
            
            posActual--;
            this.mostrarEnTP(posActual);
        }
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bSiguenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguenteActionPerformed
        posActual++;
        
        if(posActual == tAutor.getLista().size()){
            posActual = 0;
            this.mostrarEnTP(posActual);
        }
    }//GEN-LAST:event_bSiguenteActionPerformed

    private void guardarEnBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEnBDActionPerformed
        String msn = tAutor.actualizarBD();
        JOptionPane.showMessageDialog(this,msn,"Actualizar Base de Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        posActual = 0;
        mostrarEnTP(posActual);
    }//GEN-LAST:event_guardarEnBDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FrmAutor frm = new FrmAutor();
        frm.setVisible(true);
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IApellido;
    private javax.swing.JLabel IContador;
    private javax.swing.JLabel INombre;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSiguente;
    private javax.swing.JButton guardarEnBD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar tbBarra;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
