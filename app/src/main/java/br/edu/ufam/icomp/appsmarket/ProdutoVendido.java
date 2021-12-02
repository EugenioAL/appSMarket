package br.edu.ufam.icomp.appsmarket;

public class ProdutoVendido {
    private int idCupom;
    private int idProduto;
    private int quantidade;
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ProdutoVendido(){
        this(0,0,0,0);
    }

    public ProdutoVendido(int idCupom, int idProduto, int quantidade,float valor){
        this.idCupom = idCupom;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdCupom() {
        return idCupom;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
