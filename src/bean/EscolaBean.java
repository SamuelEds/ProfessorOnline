/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EscolaDao;

/**
 *
 * @author Pedro'S
 */
public class EscolaBean {
    private String cep;
    private String endereco;
    private String bairro;
    private String nome;
    private String dependencia;
    private String codigo;
    private String cidade;
    
    private String NomeDescPesquisa; //Irá buscar a escola por nome

    public String getNomeDescPesquisa() {
        return NomeDescPesquisa;
    }

    public void setNomeDescPesquisa(String NomeDescPesquisa) {
        this.NomeDescPesquisa = NomeDescPesquisa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void atualizar(EscolaDao pd, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
