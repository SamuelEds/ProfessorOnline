package dao;

import bean.boletimBEAN;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class boletimDAO {
    public void salvar(boletimBEAN ab){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO boletim(nome, disciplina, serie, prova_parcial, prova_bimestral, media, resultado) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, ab.getNome());
            stmt.setString(2, ab.getDisciplina());
            stmt.setString(3, ab.getSerie());
            stmt.setDouble(4, ab.getProvaPar());
            stmt.setDouble(5, ab.getProvaPar());
            stmt.setDouble(6, ab.getMedia());
            stmt.setString(7, ab.getResultado());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dados salvos no banco de dados!!");
        } catch (SQLException ex) {
            Logger.getLogger(boletimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexao.closeConnection(con, stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM boletim WHERE id = "+id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(boletimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
