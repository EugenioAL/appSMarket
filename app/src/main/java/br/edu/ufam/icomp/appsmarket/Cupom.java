package br.edu.ufam.icomp.appsmarket;

import java.util.Date;

public class Cupom {
    private int idCupom;
    private int idFuncionario;
    private String data;
    private String meioDePagamento;

    public Cupom(){
        this(0,0,null,"");
    }

    public Cupom(int idCupom, int idFuncionario, String data, String meioDePagamento){
        this.idCupom = idCupom;
        this.idFuncionario = idFuncionario;
        this.data = data;
        this.meioDePagamento = meioDePagamento;
    }

    public int getIdCupom() {
        return idCupom;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public String getData() {
        return data;
    }
    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getMeioDePagamento() {
        return meioDePagamento;
    }
    public void setMeioDePagamento(String meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }
}
