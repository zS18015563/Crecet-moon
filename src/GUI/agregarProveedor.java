package GUI;

import Class.Proovedor;
import Funciones.IO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class agregarProveedor extends javax.swing.JFrame {


    public agregarProveedor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agregar Proovedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 180, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 121, 29));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 121, 35));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 182, 35));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 182, 35));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Agregar Proveedor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 190, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    IO io=new IO();
    ArrayList<Proovedor> provedorexistente = io.lecturaProovedor();
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ID = jTextField2.getText();
        String nombre = jTextField1.getText();
        if (ID.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Uno o mas campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int c = 0; c < provedorexistente.size(); c++) {
                if (ID.equals(provedorexistente.get(c).getID())) {
                    JOptionPane.showMessageDialog(new JFrame(), "proovedor existente en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int A = JOptionPane.showConfirmDialog(new JFrame(), "seguro que desa agregar al proovedor " + nombre);
            if (A == JOptionPane.YES_OPTION) {
                Proovedor nuevoProovedor= new Proovedor(ID, nombre);
                provedorexistente.add(nuevoProovedor);
                io.escrituraProovedor(provedorexistente);
                JOptionPane.showMessageDialog(new JFrame(), "Proovedor agregado correctamente");
                jTextField1.setText("");
                jTextField2.setText("");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ventanaPrincipal ventana=new ventanaPrincipal();
        this.setVisible(false);
        ventana.iniciar();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void iniciar() {
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 500, 300);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
