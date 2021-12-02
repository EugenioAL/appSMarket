package br.edu.ufam.icomp.appsmarket;

public class Funcao {
    private int idFuncao;
    private String nome;
    private int categoria;
    private double salario;

    public Funcao(){
        this(0, "", 0, 0);
    }

    public Funcao(int id, String nome, int categoria, double salario) {
        this.idFuncao = id;
        this.nome = nome;
        this.categoria = categoria;
        this.salario = salario;

    }

    public int getIdFuncao() {
        return idFuncao;
    }
    public String getNome() {
        return nome;
    }
    public int getCategoria() {
        return categoria;
    }
    public double getSalario() {
        return salario;
    }
    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

}