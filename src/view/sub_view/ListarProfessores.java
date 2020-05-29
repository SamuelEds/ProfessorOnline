/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub_view;

import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.CadastroProfessor;
/**
 *
 * @author User
 */
public class ListarProfessores extends javax.swing.JFrame {

    /**
     * Creates new form ListarProfessores
     */
    
    private static CadastroProfessor cf = new CadastroProfessor();
    DefaultListModel listaModel = new DefaultListModel();
    int enter = 0;
    
    public ListarProfessores(CadastroProfessor cp) {
        initComponents();
        
        cf = cp;
        
        puxarDados();
        listarNomes.setModel(listaModel);
        painelLista.setVisible(false);
    }
    
    private void ListarNomes(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professores WHERE nome like '"+nome.getText()+"%'");
            rs = stmt.executeQuery();
            listaModel.removeAllElements();
            int v = 0;
            
            while(rs.next() && v < 4){
                listaModel.addElement(rs.getString("nome"));
                v++;
            }
            
            if(v >= 1){
                painelLista.setVisible(true);
            }else{
                painelLista.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void SelecionarNome(){
        int linha = listarNomes.getSelectedIndex();
        
        if(linha >= 0){
            nome.setText(listarNomes.getSelectedValue());
        }
    }
    
    private void puxarDados(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professores");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) professores.getModel();
            while(rs.next()){
                Object[] dados = {rs.getInt("id") ,rs.getString("nome"),rs.getString("escola_per")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    private void Pesquisa(String nome){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professores WHERE nome like '"+nome+"%'");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) professores.getModel();
            table.setNumRows(0);
            while(rs.next()){
                Object[] dados = {rs.getInt("id") ,rs.getString("nome"),rs.getString("escola_per")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    private boolean verificar(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professores WHERE nome like '"+nome.getText()+"%'");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) professores.getModel();
            table.setNumRows(0);
            
            if(rs.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
        
        return false;
    }
    
    private void escolherDados(int id){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professores WHERE id = "+id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                cf.nome.setText(rs.getString("nome"));
                cf.telefone.setText(rs.getString("telefone"));
                cf.escola_pertencente.setText(rs.getString("escola_per"));
                cf.disciplina.setSelectedItem(String.valueOf(rs.getString("disciplina")));
                cf.senha.setText(rs.getString("senha"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
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
        jLabel1 = new javax.swing.JLabel();
        painelLista = new javax.swing.JScrollPane();
        listarNomes = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        professores = new javax.swing.JTable();
        escolher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("LISTA DE PROFESSORES CADASTRADOS NO SISTEMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 57, -1, -1));

        listarNomes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                listarNomesFocusLost(evt);
            }
        });
        listarNomes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarNomesMouseClicked(evt);
            }
        });
        painelLista.setViewportView(listarNomes);

        jPanel1.add(painelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 380, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeFocusLost(evt);
            }
        });
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 29, 385, 58));

        buscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel2.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 29, 181, 58));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("NOME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 29, -1, 58));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 107, 990, 100));

        professores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICAÇÃO", "NOME", "ESCOLA PERTECENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        professores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(professores);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 314, 988, 310));

        escolher.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        escolher.setText("ESCOLHER PROFESSOR SELECIONADO");
        escolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolherActionPerformed(evt);
            }
        });
        jPanel1.add(escolher, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, 400, 58));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1010, 789));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if(nome.getText().equals("")){
            JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO PARA BUSCA", "AVISO-LEGAL", JOptionPane.ERROR_MESSAGE);
        }else{
            
            if(verificar()){
                Pesquisa(nome.getText());
            }else{
                JOptionPane.showMessageDialog(null,"PROFESSOR NÃO ENCONTRADO", "AVISO-LEGAL", JOptionPane.ERROR_MESSAGE);
                puxarDados();
            }
            
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void escolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolherActionPerformed
        if(professores.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"SELECIONE UMA LINHA DA TABELA", "AVISO-LEGAL", JOptionPane.ERROR_MESSAGE);
        }else{
            int id = Integer.parseInt(professores.getValueAt(professores.getSelectedRow(), 0).toString());
            escolherDados(id);
            dispose();
        }
    }//GEN-LAST:event_escolherActionPerformed

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
       if(enter == 0){
           ListarNomes();
       }else{
           enter = 0;
       }
    }//GEN-LAST:event_nomeKeyReleased

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        painelLista.setVisible(false);
        enter = 0;
    }//GEN-LAST:event_nomeActionPerformed

    private void listarNomesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarNomesMouseClicked
        SelecionarNome();
        painelLista.setVisible(false);
    }//GEN-LAST:event_listarNomesMouseClicked

    private void nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFocusLost
        
    }//GEN-LAST:event_nomeFocusLost

    private void listarNomesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listarNomesFocusLost
        painelLista.setVisible(false);
    }//GEN-LAST:event_listarNomesFocusLost

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
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarProfessores(cf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton escolher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listarNomes;
    private javax.swing.JTextField nome;
    private javax.swing.JScrollPane painelLista;
    private javax.swing.JTable professores;
    // End of variables declaration//GEN-END:variables
}
