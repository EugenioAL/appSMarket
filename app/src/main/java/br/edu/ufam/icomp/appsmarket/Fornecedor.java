package br.edu.ufam.icomp.appsmarket;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private long cnpj;
    private String telefone;

    public Fornecedor(){
        this(0,"",0,"");
    }

    public Fornecedor(int idFornecedor, String nome, long cnpj, String telefone){
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this. cnpj = cnpj;
        this.telefone = telefone;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }
    public String getNome() {
        return nome;
    }
    public long getCnpj() {
        return cnpj;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
