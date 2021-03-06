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
public class ListarEscolas extends javax.swing.JFrame {

    /**
     * Creates new form ListarEscolas
     */
    
    private static CadastroProfessor cpp = new CadastroProfessor();
    DefaultListModel listar = new DefaultListModel();
    private int enter = 0;
    
    public ListarEscolas(CadastroProfessor cp) {
        initComponents();
        
        cpp = cp;
        
        listaEscola.setModel(listar);
        listaEscola.setVisible(false);
        PainelScroll.setVisible(false);
        
        PuxarDados();
        
        
    }
    
    public void listarEscolas(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM escola WHERE nome like '%"+desc.getText()+"%'");
            rs = stmt.executeQuery();
            
            listar.removeAllElements();
            int v = 0;
            
            while(rs.next() && v < 7){
                listar.addElement(rs.getString("nome"));
                v++;
            }
            
            if(v >= 1){
                PainelScroll.setVisible(true);
                listaEscola.setVisible(true);
                
            }else{
                PainelScroll.setVisible(false);
                listaEscola.setVisible(false);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO NO SQL");
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    public void SelecionarNome(){
        
        int linha = listaEscola.getSelectedIndex();
        
        if(linha >= 0){
            puxarDadosPorNome(listaEscola.getSelectedValue());
        }
    }
    
    public void resgatarNome(String nome){
        desc.setText(nome);
        
        if(desc.getText().equals("")){
            PuxarDados();
        }else{
            puxarDadosPorNome(nome);
        }
        
        
    }
    
    private void puxarDadosPorNome(String nome){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM escola WHERE nome like '%"+nome+"%'");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) escolas.getModel();
            table.setNumRows(0);
            while(rs.next()){
                Object dados[] = {rs.getString("nome"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("dependencia"), rs.getString("endereco")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarEscolas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void PuxarDados(){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM escola");
            rs = stmt.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel) escolas.getModel();
            table.setNumRows(0);
            while(rs.next()){
                Object dados[] = {rs.getString("nome"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("dependencia"), rs.getString("endereco")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarEscolas.class.getName()).log(Level.SEVERE, null, ex);
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
        PainelScroll = new javax.swing.JScrollPane();
        listaEscola = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        desc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        escolas = new javax.swing.JTable();
        pegarEscolha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaEscola.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                listaEscolaFocusLost(evt);
            }
        });
        listaEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEscolaMouseClicked(evt);
            }
        });
        PainelScroll.setViewportView(listaEscola);

        jPanel1.add(PainelScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 460, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        desc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOME DA ESCOLA:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 27, 980, 137));

        escolas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "BAIRRO", "CEP", "CIDADE", "DEPENDÊNCIA", "ENDEREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        escolas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(escolas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 277, -1, -1));

        pegarEscolha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pegarEscolha.setText("ESCOLHER ESCOLA SELECIONADA");
        pegarEscolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarEscolhaActionPerformed(evt);
            }
        });
        jPanel1.add(pegarEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 677, 407, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1010, 802));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pegarEscolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarEscolhaActionPerformed
        if(escolas.getSelectedRow() != -1){
            cpp.escola_pertencente.setText(escolas.getValueAt(escolas.getSelectedRow(), 0).toString());
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"SELECIONE UMA LINHA DA TABELA","AVISO-LEGAL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pegarEscolhaActionPerformed

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        //PainelScroll.setVisible(false);
        //listaEscola.setVisible(false);
        enter = 1;
    }//GEN-LAST:event_descActionPerformed

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
        if(enter == 0){
            listarEscolas();
        }else{
            enter = 0;
        }
    }//GEN-LAST:event_descKeyReleased

    private void listaEscolaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEscolaMouseClicked
        SelecionarNome();
        PainelScroll.setVisible(false);
        listaEscola.setVisible(false);
    }//GEN-LAST:event_listaEscolaMouseClicked

    private void listaEscolaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaEscolaFocusLost
        PainelScroll.setVisible(false);
    }//GEN-LAST:event_listaEscolaFocusLost

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
            java.util.logging.Logger.getLogger(ListarEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarEscolas(cpp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PainelScroll;
    private javax.swing.JTextField desc;
    private javax.swing.JTable escolas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEscola;
    private javax.swing.JButton pegarEscolha;
    // End of variables declaration//GEN-END:variables
}
