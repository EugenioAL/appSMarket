package br.edu.ufam.icomp.appsmarket;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String sobrenome;
    private int idFuncao;
    private String senha;

    public Funcionario(){
        this(0,"","",0,"");
    }

    public Funcionario(int id, String nome, String sobrenome,int idFuncao, String senha){
        this.idFuncionario = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idFuncao = idFuncao;
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public int getIdFuncao() {
        return idFuncao;
    }
    public String getSenha() {
        return senha;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}