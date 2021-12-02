package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.Date;

public class CupomDAO {
    private Context context;
    private SQLiteDatabase database;

    public CupomDAO(Context context){
        this.context = context;
        this.database = (new BancoDeDados(context)).getWritableDatabase();
    }

    public boolean addCupom(Cupom cupom){
        String sql = "INSERT INTO cupons(funcionario_id,meiodepagamento,dataemitida) VALUES ("+ cupom.getIdFuncionario() + ",'" + cupom.getMeioDePagamento()+ "'', " + cupom.getData() +");";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Cupom Adiconado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Cupom getCupom(int cupom_id){
        String sql = "SELECT * FROM cupons WHERE cupom_id=" + cupom_id + ";)";
        Cursor cursor = database.rawQuery(sql,null);

        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int idFuncionario = cursor.getInt(1);
            String data = cursor.getString(2);
            String meioPag = cursor.getString(3);
            return new Cupom();

        }
        return null;
    }

    public boolean updateCupom(Cupom cupom){
        String sql = "UPDATE cupons SET funcionario_id=" + cupom.getIdFuncionario()+ ", meiodepagemento='" + cupom.getMeioDePagamento() + "', dataemitida=" + cupom.getData() + "WHERE cupom_id=" + cupom.getIdCupom() + ";";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Cupom Atualizado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean delCupom(int id){
        String sql = "DELETE FROM cupons WHERE id=" + id + ";";

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Cupom Atualizado!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
