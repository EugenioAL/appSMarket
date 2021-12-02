package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutoVendidoDAO {
    private Context context;
    private SQLiteDatabase database;

    public ProdutoVendidoDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public boolean addProdutoVendido(ProdutoVendido tmp){
        String sql = "INSERT INTO produtosvendidos(cupom_id,produto_id,quantidade,valor) VALUES ("+ tmp.getIdCupom() + "," + tmp.getIdProduto()+ ", " + tmp.getQuantidade() +");";

        try {
            database.execSQL(sql);
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    public ArrayList<ProdutoVendido> getProdutoVendido(int cupomId){
        String sql = "SELECT * FROM produtosvendidos WHERE cupom_id=" + cupomId + ";";
        Cursor cursor = database.rawQuery(sql,null);
        ArrayList<ProdutoVendido> res = new ArrayList<ProdutoVendido>();

        while (cursor.moveToNext()){
            int cupom_id = cursor.getInt(0);
            int produto_id = cursor.getInt(2);
            int quantidade = cursor.getInt(2);
            float valor = cursor.getFloat(3);

            res.add(new ProdutoVendido(cupom_id,produto_id,quantidade,valor));
        }

        return null;
    }

    public boolean delProdutosVendidos(int cupom_id){
        String sql = "DELETE * FROM produtosvendidos where cupom_id=" + cupom_id + ";";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Cupom exluido!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
