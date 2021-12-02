package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class FuncionarioDAO {
    private Context context;
    private SQLiteDatabase database;

    public FuncionarioDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public boolean addFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionarios(nome,sobrenome,senha,funcao_id) VALUES ('"+ funcionario.getNome() + "','" + funcionario.getSobrenome() + "','" + funcionario.getSenha() + "'," + funcionario.getIdFuncao() +  ");";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funcionario Adicionado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        return false;
        }
    }

    public  boolean updateFuncionario(Funcionario funcionario){
        String sql = "UPDATE funcionarios SET nome ='" + funcionario.getNome() + "',sobrenome='" + funcionario.getSobrenome() + "',=" +funcionario.getIdFuncao() + ",senha='" + funcionario.getSenha() + " WHERE funcionario_id=" + funcionario.getIdFuncionario() + " WHERE nome="+ funcionario.getNome()+";";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Atualizado", Toast.LENGTH_SHORT).show();
            return true;
        }

        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;        }
    }

    public Funcionario getFuncionario(String nome){
        String sql = "SELECT * FROM funcionarios WHERE nome='" + nome + "';";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomeF = cursor.getString(1);
            String sobrenome = cursor.getString(2);
            int funcaoId = cursor.getInt(3);
            String senha = cursor.getString(4);
            return new Funcionario(id,nomeF,sobrenome,funcaoId,senha);

        }
        return null;
    }


    public boolean delFuncionario(String nome){
        String sql = "DELETE FROM funcionarios WHERE nome = '" + nome +  "';";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Funçionario exlcuída!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
