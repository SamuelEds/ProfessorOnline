/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EscolaBean;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro'S
 */
public class EscolaDao {

    public void create(EscolaBean p) { //Função para salvar os dados
        Connection con = conexao.getConnection(); //Variável que irá receber a conexão
        PreparedStatement stmt = null; //Variável que irá guardar o comando SQL
        try {

            stmt = con.prepareStatement("INSERT INTO escola(nome,bairro,cep,cidade,dependencia,endereco,codigo) VALUES (?,?,?,?,?,?,?)"); //Varável stmt irá receber os comando SQL
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getBairro());
            stmt.setString(3, p.getCep());
            stmt.setString(4, p.getCidade());
            stmt.setString(5, p.getDependencia());
            stmt.setString(6, p.getEndereco());
            stmt.setString(7, p.getCodigo());

            stmt.executeUpdate();//Executar o comando

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso"); // Exibir mensagem caso tudo funcione

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public void deletar(int matricula) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        if (verif(matricula)) {

            try {
                stmt = con.prepareStatement("DELETE FROM escola WHERE id = " + matricula);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro excluido com Sucesso!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Esse registro não foi encontrados");
            }finally{
                conexao.closeConnection(con, stmt);
            }

        } else {

            JOptionPane.showMessageDialog(null, "Escola não existe ou foi excluído");

        }
    }

    public boolean verif(int id) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM escola WHERE id = " + id + "");
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "É preciso do id para confirmação!!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public void atualizar(EscolaBean eb, int id) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        if (verif(id)) {
            try {
                stmt = con.prepareStatement("UPDATE escola SET nome = ?,bairro = ?,cep = ?,cidade = ?,dependencia = ?, endereco = ?, codigo= ? WHERE id = " + id);

                stmt.setString(1, eb.getNome());
                stmt.setString(2, eb.getBairro());
                stmt.setString(3, eb.getCep());
                stmt.setString(4, eb.getCidade());
                stmt.setString(5, eb.getDependencia());
                stmt.setString(6, eb.getEndereco());
                stmt.setString(7, eb.getCodigo());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Esse registro não foi encontrado");
            } finally {
                conexao.closeConnection(con, stmt);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Matrícula não existe ou foi excluído");
        }

    }
}
