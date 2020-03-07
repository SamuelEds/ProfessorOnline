/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JInternalFrame;

import bean.boletimBEAN;
import connection.conexao;
import dao.boletimDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaProfessor;

/**
 *
 * @author Aluno
 */
public class GerBoletim extends javax.swing.JInternalFrame {

    /**
     * Creates new form GerBoletim
     */
    public GerBoletim() {
        initComponents();
        
        puxarBoletim();
    }
    
    public void puxarBoletim(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM boletim");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) boletim.getModel();
            table.setNumRows(0);
            while(rs.next()){
                Object[] l = {rs.getInt("id"),rs.getString("nome"), rs.getString("disciplina"), rs.getString("serie"), rs.getDouble("prova_parcial"), rs.getDouble("prova_bimestral"), rs.getDouble("media"), rs.getString("resultado")};
                table.addRow(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaProfessor.class.getName()).log(Level.SEVERE, null, ex);
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

        mostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        boletim = new javax.swing.JTable();
        deletar = new javax.swing.JButton();
        pesquisar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        mostrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrar.setText("MOSTRAR TUDO");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("GERENCIAMENTO DE BOLETIM");

        boletim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Disciplina", "Serie", "Prova Parcial", "Prova Bimestral", "Média", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boletim.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(boletim);

        deletar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletar.setText("DELETAR DADOS");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        pesquisar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pesquisar.setText("PESQUISAR DADOS");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(pesquisar)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        boletimBEAN ab = new boletimBEAN();
        boletimDAO ad = new boletimDAO();
        
        if(boletim.getSelectedRow() != -1){
            DefaultTableModel table = (DefaultTableModel) boletim.getModel();
            
            int id = Integer.parseInt(String.valueOf(boletim.getValueAt(boletim.getSelectedRow(), 0)));
            ad.deletar(id);
            table.removeRow(boletim.getSelectedRow());
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para exclusão","Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        boletimDAO bt = new boletimDAO();
        
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção:\n [1] - Pesquiar por ID\n [2] - Pesquisar por nome"));
        
        switch(n){
            case 1:
        
            try {
                
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID: "));
                
                stmt = con.prepareStatement("SELECT * FROM boletim WHERE id like '%"+id+"%'");
                rs = stmt.executeQuery();
                
                DefaultTableModel table = (DefaultTableModel) boletim.getModel();
                table.setNumRows(0);
                
                while(rs.next()){
                    Object[] l = {rs.getInt("id"), rs.getString("nome"), rs.getString("disciplina"), rs.getString("serie"), rs.getDouble("prova_parcial"), rs.getDouble("prova_bimestral"), rs.getDouble("media"), rs.getString("resultado")};
                    table.addRow(l);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERRO!  "+ex);
            }
        
            break;
            
            case 2:
                
            try {
                
                String nome1 = JOptionPane.showInputDialog("Digite o nome do aluno: ");
                
                stmt = con.prepareStatement("SELECT * FROM boletim WHERE nome like '%"+nome1+"%'");
                rs = stmt.executeQuery();
                
                DefaultTableModel table = (DefaultTableModel) boletim.getModel();
                table.setNumRows(0);
                
                while(rs.next()){
                    Object[] l = {rs.getInt("id"), rs.getString("nome"), rs.getString("disciplina"), rs.getString("serie"), rs.getDouble("prova_parcial"), rs.getDouble("prova_bimestral"), rs.getDouble("media"), rs.getString("resultado")};
                    table.addRow(l);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERRO!  "+ex);
            }
            
            break;
        }
    }//GEN-LAST:event_pesquisarActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
       DefaultTableModel table = (DefaultTableModel) boletim.getModel();
       table.setNumRows(0);
       puxarBoletim();
    }//GEN-LAST:event_mostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable boletim;
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton pesquisar;
    // End of variables declaration//GEN-END:variables
}
