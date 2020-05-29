package dao;

import bean.resultadoBEAN;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class resultadoDAO {

    Connection con = conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void salvar(resultadoBEAN rb) {
        try {
            stmt = con.prepareStatement("INSERT INTO resultado (matricula, nome, serie, disciplina, bimestre_um) VALUES (?,?,?,?,?)");
            stmt.setInt(1, rb.getMatricula());
            stmt.setString(2, rb.getNome());
            stmt.setString(3, rb.getSerie());
            stmt.setString(4, rb.getDisciplina());
            stmt.setFloat(5, rb.getBimestre_um());

            stmt.executeUpdate();
            //System.out.println("MATRÍCULA INSERIDA");
        } catch (SQLException ex) {
            System.out.println("ERRO " + ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }

    public void gravarBimestre_dois(resultadoBEAN rb, int matricula) {
        try {

            stmt = con.prepareStatement("UPDATE resultado SET bimestre_dois = ? WHERE matricula = " + matricula);
            stmt.setFloat(1, rb.getBimestre_dois());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERRO " + ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }

    }

    public void gravarBimestre_tres(resultadoBEAN rb, int matricula) {
        try {

            stmt = con.prepareStatement("UPDATE resultado SET bimestre_tres = ? WHERE matricula = " + matricula);
            stmt.setFloat(1, rb.getBimestre_tres());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERRO " + ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    public void gravarBimestre_quatro(resultadoBEAN rb, int matricula) {
        try {

            stmt = con.prepareStatement("UPDATE resultado SET bimestre_quatro = ?, media_final = ?, resultado = ? WHERE matricula = " + matricula);
            stmt.setFloat(1, rb.getBimestre_quatro());
            stmt.setFloat(2, rb.getMedia());
            stmt.setString(3, rb.getResultado());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERRO " + ex);
        }finally{
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    
    //===================================REMOÇÀO DE DADOS===============================================\\
    public void remover_Media_Resultado(int Matricula){
        try {
            stmt = con.prepareStatement("UPDATE resultado SET bimestre_quatro = 0.0, media_final = 0.0, resultado = '' WHERE matricula = "+Matricula);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(resultadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover_Bimestre_Tres(int matricula){
        try {
            stmt = con.prepareStatement("UPDATE resultado SET bimestre_tres = 0.0 WHERE matricula = "+matricula);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(resultadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover_Bimestre_Dois(int matricula){
        try {
            stmt = con.prepareStatement("UPDATE resultado SET bimestre_dois = 0.0 WHERE matricula = "+matricula);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(resultadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover_Resultado(int matricula){
        try {
            stmt = con.prepareStatement("DELETE FROM resultado WHERE matricula = "+matricula);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(resultadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
