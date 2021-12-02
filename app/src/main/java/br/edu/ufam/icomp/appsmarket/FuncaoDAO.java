package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class FuncaoDAO {
    private Context context;
    private SQLiteDatabase database;

    public  FuncaoDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public boolean addFuncao(Funcao funcao){
        String sql = "INSERT INTO funcao(nome,categoria,salario) VALUES(" + "'" + funcao.getNome() + "', " + funcao.getCategoria() + ", " + funcao.getSalario() + ");";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funcao Adicionada!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Funcao getFuncaoPorNome(String nome){
        String sql = "SELECT * FROM funcao WHERE nome='" + nome + "';";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomeF = cursor.getString(1);
            int categoria = cursor.getInt(2);
            float salario = cursor.getFloat(3);

            return new Funcao(id,nomeF,categoria,salario);
        }
        return null;


    }

    public Funcao getFuncaoPorId(int funcao_id){
        String sql = "SELECT * FROM funcao WHERE funcao_id=" + funcao_id + ";";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomeF = cursor.getString(1);
            int categoria = cursor.getInt(2);
            float salario = cursor.getFloat(3);

            return new Funcao(id,nomeF,categoria,salario);
        }
        return null;
    }

    public boolean updateFuncao(Funcao funcao){
        String sql = "UPDATE funcoes SET nome='" + funcao.getNome()+ "'', categoria=" + funcao.getCategoria() + ", salario='" + funcao.getSalario() + "' WHERE funcao_id=" + funcao.getIdFuncao() + ";";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funcao atualizada!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public boolean delFuncao(String nome){
        String sql = "DELETE FROM funcao WHERE nome=" + nome + ";";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funçao exlcuída!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
