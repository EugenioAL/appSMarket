package br.edu.ufam.icomp.appsmarket;

public class Produto {
    private int idProduto;
    private String nome;
    private String medida;
    private String fabricante;
    private long barCodigo;
    private float valorCompra;
    private float valorVenda;

    public Produto(){
        this( 0,"","","",0,0,0);
    }

    public Produto(int idProduto, String nome, String medida, String fabricante, long barCodigo, float valorCompra, float valorVenda){
        this.idProduto = idProduto;
        this.nome = nome;
        this.medida = medida;
        this.fabricante = fabricante;
        this.barCodigo = barCodigo;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public String getNome() {
        return nome;
    }
    public String getMedida() {
        return medida;
    }
    public String getFabricante() {
        return fabricante;
    }
    public long getBarCodigo() {
        return barCodigo;
    }
    public float getValorCompra() {
        return valorCompra;
    }
    public float getValorVenda() {
        return valorVenda;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMedida(String medida) {
        this.medida = medida;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public void setBarCodigo(long barCodigo) {
        this.barCodigo = barCodigo;
    }
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String produtoToString(){
        String descricao = "Id: " + this.getIdProduto() + " Nome: " + this.getNome() + " Fabricante: " + this.getFabricante() + " Medida: " + this.getMedida() + " Valor: " + this.getValorVenda();
        return descricao;
    }
}
