/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.resultadoBEAN;
import connection.conexao;
import dao.resultadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class EditarNota_e_Media extends javax.swing.JFrame {

    /**
     * Creates new form EditarNota_e_Media
     */
    public EditarNota_e_Media() {
        initComponents();

        puxarBoletim();
        puxarResultado();
    }

//===================================================== PUXAR RESULTADOS DOS BANCOS ===================================================\\
    public void puxarBoletim() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM boletim");
            rs = stmt.executeQuery();

            DefaultTableModel table = (DefaultTableModel) alunos.getModel();

            while (rs.next()) {
                Object[] dados = {rs.getInt("matricula"), rs.getString("nome"), rs.getString("disciplina"), rs.getString("serie"), rs.getFloat("media")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarNota_e_Media.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
    }

    public void puxarResultado() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM resultado");
            rs = stmt.executeQuery();
            DefaultTableModel table = (DefaultTableModel) resultado.getModel();
            while (rs.next()) {
                Object[] dados = {rs.getInt("matricula"), rs.getString("nome"), rs.getString("serie"), rs.getString("disciplina"), rs.getFloat("bimestre_um"), rs.getFloat("bimestre_dois"), rs.getFloat("bimestre_tres"), rs.getFloat("bimestre_quatro"), rs.getFloat("media_final"), rs.getString("resultado")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarNota_e_Media.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//=====================================================================================================================================\\
//===================================================== VERIFICAÇÃO DE REGISTROS ===================================================\\
    public boolean verificarMatricula(int mat) { //VERIFICA SE A MATRÍCULA EXSITE
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM boletim WHERE matricula like '%" + mat + "%'");
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;

            }
        } catch (SQLException ex) {
            System.out.println("ERRO" + ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return false;
    }

    public boolean verificarResultado(int matricula) { //VERIFICA SE A MATRÍCULA JÁ FOI INSERIDA NA TABELA resultado DO BANCO DE DADOS
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM resultado WHERE matricula = " + matricula);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarNota_e_Media.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

//=====================================================================================================================================\\
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTable();
        matricula = new javax.swing.JTextField();
        matriculaR = new javax.swing.JTextField();
        pesquisarResultado = new javax.swing.JLabel();
        pesquisarBoletim = new javax.swing.JLabel();
        adicionarResultado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        remover = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Disciplina", "Serie", "Média"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alunos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(alunos);

        resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Serie", "Disciplina", "1º Bimestre", "2º Bimestre", "3º Bimestre", "4º Bimestre", "Média", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultado.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(resultado);

        pesquisarResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/IconePesquisarProfessor.png"))); // NOI18N
        pesquisarResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarResultadoMouseClicked(evt);
            }
        });

        pesquisarBoletim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/IconePesquisarProfessor.png"))); // NOI18N
        pesquisarBoletim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarBoletimMouseClicked(evt);
            }
        });

        adicionarResultado.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        adicionarResultado.setText(">");
        adicionarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarResultadoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("MATRÍCULA:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("MATRÍCULA:");

        remover.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        remover.setText("<");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adicionarResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(391, 391, 391))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(pesquisarBoletim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(matriculaR, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pesquisarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pesquisarResultado)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pesquisarBoletim)
                            .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matriculaR, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(adicionarResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLabel3.setText("LOCAL DE EDIÇÃO DE DADOS DOS ALUNOS");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Tabela de Resultados do Aluno");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Tabela de Médias de um Bimestre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(392, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(351, 351, 351))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(29, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1548, 809));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarBoletimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarBoletimMouseClicked

        try {
            int mat = Integer.parseInt(matricula.getText());

            Connection con = conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            DefaultTableModel table = (DefaultTableModel) alunos.getModel();

            if (verificarMatricula(mat) && matricula.getText() != "") {

                try {
                    stmt = con.prepareStatement("SELECT * FROM boletim WHERE matricula like '%" + mat + "%'");
                    rs = stmt.executeQuery();

                    table.setNumRows(0);
                    while (rs.next()) {
                        Object[] dados = {rs.getInt("matricula"), rs.getString("nome"), rs.getString("disciplina"), rs.getString("serie"), rs.getFloat("media")};
                        table.addRow(dados);
                    }
                } catch (SQLException ex) {
                    System.out.println("DEU FALSE");
                } finally {
                    conexao.closeConnection(con, stmt, rs);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ESSA MATRÍCULA FOI EXCLUÍDA OU NÃO EXISTE", "ERRO", JOptionPane.ERROR_MESSAGE);
                table.setNumRows(0);
                puxarBoletim();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "SO É ACEITÁVEL VALORES NUMÉRICOS/PREENCHA O CAMPO COM A MATRÍCULA", "ERRO", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_pesquisarBoletimMouseClicked

    private void adicionarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarResultadoActionPerformed
        DefaultTableModel table = (DefaultTableModel) resultado.getModel();
        resultadoBEAN rb = new resultadoBEAN();
        resultadoDAO rd = new resultadoDAO();

        if (alunos.getSelectedRow() != -1) {

            if (verificarResultado(Integer.parseInt(alunos.getValueAt(alunos.getSelectedRow(), 0).toString()))) {

                //AQUI VAI O CÓDIGO AUTOMÁTICO
                if (resultado.getSelectedRow() != -1) {

                    if (Integer.parseInt(alunos.getValueAt(alunos.getSelectedRow(), 0).toString()) == Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString())) {

                        String b1 = resultado.getValueAt(resultado.getSelectedRow(), 4).toString();
                        String b2 = resultado.getValueAt(resultado.getSelectedRow(), 5).toString();
                        String b3 = resultado.getValueAt(resultado.getSelectedRow(), 6).toString();
                        String b4 = resultado.getValueAt(resultado.getSelectedRow(), 7).toString();

                        if (!(b1.equals("") || b1.equals("0.0")) && b2.equals("0.0")) {

                            table.setValueAt(alunos.getValueAt(alunos.getSelectedRow(), 4), resultado.getSelectedRow(), 5);

                            //System.out.println("BIMESTRE DOIS");
                            rb.setBimestre_dois(Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 5).toString()));
                            rd.gravarBimestre_dois(rb, Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString()));

                        } else if (!(b2.equals(null) || b2.equals("0.0")) && b3.equals("0.0")) {

                            table.setValueAt(alunos.getValueAt(alunos.getSelectedRow(), 4), resultado.getSelectedRow(), 6);

                            rb.setBimestre_tres(Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 6).toString()));

                            rd.gravarBimestre_tres(rb, Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString()));

                        } else if (!(b3.equals(null) || b3.equals("0.0")) && b4.equals("0.0")) {

                            table.setValueAt(alunos.getValueAt(alunos.getSelectedRow(), 4), resultado.getSelectedRow(), 7);

                            rb.setBimestre_quatro(Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 7).toString()));

                            float vb1 = Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 4).toString());
                            float vb2 = Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 5).toString());
                            float vb3 = Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 6).toString());
                            float vb4 = Float.parseFloat(resultado.getValueAt(resultado.getSelectedRow(), 7).toString());

                            float media = (vb1 + vb2 + vb3 + vb4) / 4;
                            rb.setMedia(media);

                            resultado.setValueAt(media, resultado.getSelectedRow(), 8);

                            if (media >= 6) {
                                rb.setResultado("APROVADO");
                            } else if (media < 6 && media > 4) {
                                rb.setResultado("RECUPERAÇÃO");
                            } else {
                                rb.setResultado("REPROVADO");
                            }

                            resultado.setValueAt(rb.getResultado(), resultado.getSelectedRow(), 9);

                            rd.gravarBimestre_quatro(rb, Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString()));
                        } else {
                            JOptionPane.showMessageDialog(null, "O RESULTADO PARA ESSA MATRÍCULA JÁ FOI CALCULADA");
                        }
                    } else {
                        
                        if (verificarResultado(Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString()))) {
                            JOptionPane.showMessageDialog(null,"ESSA MATRÍCULA JÁ FOI REGISTRADA","ERRO",JOptionPane.ERROR_MESSAGE);
                        } else {
                            rb.setMatricula(Integer.parseInt(alunos.getValueAt(alunos.getSelectedRow(), 0).toString()));
                            rb.setNome(alunos.getValueAt(alunos.getSelectedRow(), 1).toString());
                            rb.setDisciplina(alunos.getValueAt(alunos.getSelectedRow(), 2).toString());
                            rb.setSerie(alunos.getValueAt(alunos.getSelectedRow(), 3).toString());
                            rb.setBimestre_um(Float.parseFloat(alunos.getValueAt(alunos.getSelectedRow(), 4).toString()));

                            rd.salvar(rb);

                            Object[] dados = {rb.getMatricula(), rb.getNome(), rb.getSerie(), rb.getDisciplina(), rb.getBimestre_um(), "0.0", "0.0", "0.0", "0.0"};
                            table.addRow(dados);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA DA TABELA DE RESULTADOS", "ERRO", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                rb.setMatricula(Integer.parseInt(alunos.getValueAt(alunos.getSelectedRow(), 0).toString()));
                rb.setNome(alunos.getValueAt(alunos.getSelectedRow(), 1).toString());
                rb.setDisciplina(alunos.getValueAt(alunos.getSelectedRow(), 2).toString());
                rb.setSerie(alunos.getValueAt(alunos.getSelectedRow(), 3).toString());
                rb.setBimestre_um(Float.parseFloat(alunos.getValueAt(alunos.getSelectedRow(), 4).toString()));

                rd.salvar(rb);

                Object[] dados = {rb.getMatricula(), rb.getNome(), rb.getSerie(), rb.getDisciplina(), rb.getBimestre_um(), "0.0", "0.0", "0.0", "0.0"};
                table.addRow(dados);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA DA TABELA DOS ALUNOS", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_adicionarResultadoActionPerformed

    private void pesquisarResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarResultadoMouseClicked
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM resultado WHERE matricula like '%" + matriculaR.getText() + "%'");
            rs = stmt.executeQuery();

            DefaultTableModel table = (DefaultTableModel) resultado.getModel();
            table.setNumRows(0);
            while (rs.next()) {
                Object[] dados = {rs.getInt("matricula"), rs.getString("nome"), rs.getString("serie"), rs.getString("disciplina"), rs.getFloat("bimestre_um"), rs.getFloat("bimestre_dois"), rs.getFloat("bimestre_tres"), rs.getFloat("bimestre_quatro"), rs.getFloat("media_final"), rs.getString("resultado")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarNota_e_Media.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisarResultadoMouseClicked

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        resultadoDAO rd = new resultadoDAO();
        if (resultado.getSelectedRow() != -1) {

            DefaultTableModel table = (DefaultTableModel) resultado.getModel();

            int matricula = Integer.parseInt(resultado.getValueAt(resultado.getSelectedRow(), 0).toString());
            String b1 = resultado.getValueAt(resultado.getSelectedRow(), 4).toString();//OBTÉM O VALOR DO CAMPO BIMESTRA_UM DA TEBAL RESULTADO
            String b2 = resultado.getValueAt(resultado.getSelectedRow(), 5).toString(); //OBTÉM O VALOR DO CAMPO BIMESTRA_DOIS DA TEBAL RESULTADO
            String b3 = resultado.getValueAt(resultado.getSelectedRow(), 6).toString();//OBTÉM O VALOR DO CAMPO BIMESTRA_TRES DA TEBAL RESULTADO
            String b4 = resultado.getValueAt(resultado.getSelectedRow(), 7).toString(); //OBTÉM O VALOR DO CAMPO BIMESTRA_QUATRO DA TEBAL RESULTADO
            String media = resultado.getValueAt(resultado.getSelectedRow(), 8).toString(); //OBTÉM O VALOR DO CAMPO MEDIA DA TEBAL RESULTADO
            //String resultadoC = resultado.getValueAt(resultado.getSelectedRow(), 9).toString() ? resultado.getValueAt(resultado.getSelectedRow(), 9).toString() : ""; //OBTÉM O VALOR DO CAMPO RESULTADO DA TEBAL RESULTADO

            if (!String.valueOf(b4).equals("0.0")) {
                //AQUI É PRA REMOVER O RESULTADO, MÉDIA E O BIMESTRE QUATRO
                rd.remover_Media_Resultado(matricula);

                //SETAR OS CAMPOS RESULTADO, MÉDIA E O BIMESTRE QUATRO
                resultado.setValueAt(null, resultado.getSelectedRow(), 9); //SETAR O CAMPO RESULTADO DA TABELA
                resultado.setValueAt("0.0", resultado.getSelectedRow(), 8); //SETAR O CAMPO MÉDIA DA TABELA
                resultado.setValueAt("0.0", resultado.getSelectedRow(), 7); //SETAR O CAMPO BIMESTRE QUATRO DA TABELA

            } else if (!b3.equals("0.0")) {

                rd.remover_Bimestre_Tres(matricula);
                resultado.setValueAt("0.0", resultado.getSelectedRow(), 6);

            } else if (!b2.equals("0.0")) {
                rd.remover_Bimestre_Dois(matricula);
                resultado.setValueAt("0.0", resultado.getSelectedRow(), 5);
            } else {
                rd.remover_Resultado(matricula);
                table.removeRow(resultado.getSelectedRow());
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA DA TABELA DE RESULTADO", "AVISO-LEGAL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removerActionPerformed

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
            java.util.logging.Logger.getLogger(EditarNota_e_Media.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarNota_e_Media.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarNota_e_Media.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarNota_e_Media.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarNota_e_Media().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarResultado;
    private javax.swing.JTable alunos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField matriculaR;
    private javax.swing.JLabel pesquisarBoletim;
    private javax.swing.JLabel pesquisarResultado;
    private javax.swing.JButton remover;
    private javax.swing.JTable resultado;
    // End of variables declaration//GEN-END:variables
}