/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author User
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        /*try {
            UIManager.setLookAndFeel("Nimbus");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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

        jLabel1 = new javax.swing.JLabel();
        progresso = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/screen-0.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progresso.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        progresso.setForeground(new java.awt.Color(40, 103, 98));
        progresso.setText("0%");
        getContentPane().add(progresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 60, -1));

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setForeground(new java.awt.Color(35, 107, 98));
        barra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        barra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barra.setEnabled(false);
        barra.setFocusable(false);
        barra.setRequestFocusEnabled(false);
        barra.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 270, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arteLoading.jpeg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 370, 620));

        setSize(new java.awt.Dimension(360, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        SplashScreen sc=new SplashScreen();
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                sc.setVisible(true);
               
            }
        });
        Login l = new Login();
        try{
            for (int i=0;i<=100;i++)
            {
                Thread.sleep(40);
                sc.barra.setValue(i);
                sc.progresso.setText(Integer.toString(i)+ "%");
                 if(i ==100){
                
                 }
            }
        }catch (Exception e) {
        }
        new SplashScreen().setVisible(false);
        l.setVisible(true);
sc.setVisible(false);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel progresso;
    // End of variables declaration//GEN-END:variables
}
