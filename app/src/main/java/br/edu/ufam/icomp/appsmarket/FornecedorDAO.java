package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class FornecedorDAO {
    private Context context;
    private SQLiteDatabase database;

    public FornecedorDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public boolean addFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores(nome,cnpj,telefone) VALUES ('"+ fornecedor.getNome() + "'," + fornecedor.getCnpj()+ ", '" + fornecedor.getTelefone() +"');";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funcao Adiconada!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Fornecedor getFornecedor(String nome){
        String sql = "SELECT * FROM fornecedores WHERE nome='" + nome + "';";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomeF = cursor.getString(1);
            long cnpj= cursor.getLong(2);
            String telefone = cursor.getString(3);
            return new Fornecedor(id,nomeF,cnpj,telefone);

        }
        return null;
    }

    public boolean updateFornecedor(Fornecedor fornecedor){
        String sql = "UPDATE fornecedores SET nome='" + fornecedor.getNome()+ "'', cnpj=" + fornecedor.getCnpj() + ", telefone='" + fornecedor.getTelefone() + "' WHERE fornecedor_id=" + fornecedor.getIdFornecedor() + ";";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Fornecedor atualizado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public boolean delFornecedor(String nome){
        String sql = "";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Fornecedor excluido!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
