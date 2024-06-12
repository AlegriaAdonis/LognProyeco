
package Clases;

import Interfaces_Recepcionista.Principal_Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame {
    Principal_Hotel principal = new Principal_Hotel();
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    public Login() {
        initComponents();
        mongoClient = new MongoClient("localhost", 27017); 
        database = mongoClient.getDatabase("Reservas_Santander");
        collection = database.getCollection("usuarios"); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        About = new javax.swing.JButton();
        Registrarse = new javax.swing.JButton();
        Documentacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        Ingresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        About.setText("About");
        getContentPane().add(About, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 199, 50));

        Registrarse.setText("Registrarse");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 199, 50));

        Documentacion.setText("Documentacion");
        Documentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentacionActionPerformed(evt);
            }
        });
        getContentPane().add(Documentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 199, 50));

        jLabel1.setText("Contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 470, 70));

        jLabel2.setText("Identificacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 470, 70));

        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 420, 60));

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 420, 60));

        Ingresar.setText("Ingresar");
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, 170, 60));

        jLabel3.setText("Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 270, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarseActionPerformed

    private void DocumentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocumentacionActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        String userID = ID.getText();
    String password = Contraseña.getText();
    Document query = new Document("Cedula", userID);
    Document queryD = new Document("CodigoUsuario:", password);
    long count= collection.countDocuments(query);
    long countD= collection.countDocuments(queryD);
        if(count<=0){
            JOptionPane.showMessageDialog(null, "La cedula ingresada no esta registrada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
         if(countD<=0){
            JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            
            return;
        }else{
          principal.setVisible(true);   
        }
        }
    }//GEN-LAST:event_IngresarActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton About;
    private javax.swing.JTextField Contraseña;
    private javax.swing.JButton Documentacion;
    private javax.swing.JTextField ID;
    private javax.swing.JButton Ingresar;
    private javax.swing.JButton Registrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
