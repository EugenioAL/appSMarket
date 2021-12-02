package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EstoqueDAO {
    private Context context;
    private SQLiteDatabase database;

    public EstoqueDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    /*private int idProduto;
    private int quantidadeEmEstoque;
    private int quantidadeMinima;

    CREATE TABLE estoque(produto_id INTEGER NOT NULL PRIMARY KEY,
    quantidademinima INTEGER,
    quantidadeemestoque INTEGER,
    FOREIGN KEY(produto_id) REFERENCES produtos(produto_id));*/

    public boolean addProdEstoque(Estoque novoProduto){
        String sql = "INSERT INTO estoque(produto_id,quantidadeemestoque,quantidademinima) VALUES ("+ novoProduto.getIdProduto() + "," + novoProduto.getQuantidadeEmEstoque()+ ", " + novoProduto.getQuantidadeMinima() +");";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Produto Adicionado ao estoque!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Estoque getProdEstoque(int prodId){
        String sql = "SELECT FROM estoque WHERE produto_id=" + prodId + ";";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int produtoID = cursor.getInt(0);
            int qmin = cursor.getInt(1);
            int qEmEstoque = cursor.getInt(2);
            return new Estoque(produtoID,qmin,qEmEstoque);
        }

        return null;
    }

    public boolean updateprodEstoque(Estoque prodEstoque){
        String sql = "UPDATE estoque SET quanridadeemestoque=" + prodEstoque.getQuantidadeEmEstoque()+ ", quantidademinima=" + prodEstoque.getQuantidadeMinima() + " WHERE produto_id=" + prodEstoque.getIdProduto() + ";";
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Estoque atualizado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean delProdEstoque(int id){
        String sql = "DELETE FROM estoque WHERE produto_id=" + id + ";";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Produto deletado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}
