package br.edu.ufam.icomp.appsmarket;

public class Estoque {
    private int idProduto;
    private int quantidadeEmEstoque;
    private int quantidadeMinima;

    public Estoque(){
        this(0,0,0);
    }

    public Estoque(int idProduto, int quantidadeEmEstoque, int quantidadeMinima){
        this.idProduto = idProduto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
}
