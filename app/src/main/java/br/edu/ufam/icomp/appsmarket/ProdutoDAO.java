package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ProdutoDAO {
    private Context context;
    private SQLiteDatabase database;

    public ProdutoDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public  boolean addProduto( Produto produto){
        String sql = "INSERT INTO Produtos(nome,medida,fabricante,codigodebarra,valorcompra,valorvenda) VALUES ('"+ produto.getNome() + "','" + produto.getMedida()+ "', '" + produto.getFabricante() + "'," + produto.getBarCodigo() + "," + produto.getValorCompra() + ","+ produto.getValorVenda()+");";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Produto adicionado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!"+ e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Produto getProduto(long barCode){
        String sql = "SELECT * FROM Produtos WHERE codigodebarra=" + barCode+ ";";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String medida = cursor.getString(2);
            long barraCodigo = cursor.getLong(3);
            String fabricante = cursor.getString(4);
            float valCompra = cursor.getFloat(5);
            float valVenda = cursor.getFloat(6);

            return new Produto(id,nome,medida,fabricante,barraCodigo,valCompra,valVenda);
        }
        return null;
    }

    public boolean updateProduto(int id){
        Produto tmp = getProduto(id);
        String sql = "UPDATE Produtos SET nome ='" + tmp.getNome() + "',medida='" + tmp.getMedida()+ "',fabricante '" + tmp.getFabricante() + "',codigodebarra=" + tmp.getBarCodigo() + ",valorcompra=" + tmp.getValorCompra() + ",valorvenda="+ tmp.getValorVenda()+");" + " WHERE produto_id=" + tmp.getIdProduto() + ";";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Produto atualizado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return  false;
        }
    }

    public boolean delProduto(long barCode){
        String sql = "DELETE FROM produtos WHERE codigodebarra=" + barCode + ";";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Produto deletado!", Toast.LENGTH_SHORT).show();
            return true;
        }

        catch (SQLException e){
            Toast.makeText(context, "Erro " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return  false;
        }
    }


}

/*
 CREATE TABLE produtos(produto_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome TEXT NOT NULL,
 medida TEXT,
 codigodebarra BIGINTEGER,
  fabricante TEXT,
   valorvenda REAL,
    valorcompra REAL);

    private int idProduto;
    private String nome;
    private String medida;
    private String fabricante;
    private long barCodigo;
    private float valorCompra;
    private float valorVenda;
    */