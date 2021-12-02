package br.edu.ufam.icomp.appsmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Funcoes_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoes);
    }

    public void onClickAddFuncao(View view){
        EditText fid = findViewById(R.id.et_funcaoid);
        EditText fnome = findViewById(R.id.et_funcaoname);
        EditText fcat = findViewById(R.id.et_funccat);
        EditText fsal = findViewById(R.id.et_funcsal);

        int id = Integer.parseInt(fid.getText().toString());
        int cat = Integer.parseInt(fcat.getText().toString());
        double sal = Double.parseDouble(fsal.getText().toString());


        Funcao tmp = new Funcao(id,fnome.getText().toString(),cat,sal);
        FuncaoDAO aux = new FuncaoDAO(Funcoes_activity.this);

        try {
            aux.addFuncao(tmp);
            Toast.makeText(Funcoes_activity.this, "FOI!!!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(Funcoes_activity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onClickGetFuncao(View view){
        EditText fid = findViewById(R.id.et_funcaoid);
        EditText fnome = findViewById(R.id.et_funcaoname);
        EditText fcat = findViewById(R.id.et_funccat);
        EditText fsal = findViewById(R.id.et_funcsal);

        int id = Integer.parseInt(fid.getText().toString());
        int cat = Integer.parseInt(fcat.getText().toString());
        double sal = Double.parseDouble(fsal.getText().toString());


        Funcao tmp = new Funcao(id,fnome.getText().toString(),cat,sal);
        FuncaoDAO aux = new FuncaoDAO(Funcoes_activity.this);

        try {
            tmp = aux.getFuncaoPorNome(fnome.getText().toString());
        }
        catch (Exception e){

        }


    }

    public void onClickAttFuncao(View view){
        EditText fid = findViewById(R.id.et_funcaoid);
        EditText fnome = findViewById(R.id.et_funcaoname);
        EditText fcat = findViewById(R.id.et_funccat);
        EditText fsal = findViewById(R.id.et_funcsal);

        int id = Integer.parseInt(fid.getText().toString());
        int cat = Integer.parseInt(fcat.getText().toString());
        double sal = Double.parseDouble(fsal.getText().toString());


        Funcao tmp = new Funcao(id,fnome.getText().toString(),cat,sal);
        FuncaoDAO aux = new FuncaoDAO(Funcoes_activity.this);

        try {
            aux.updateFuncao(tmp);
        }
        catch (Exception e){

        }

    }

    public void onClickDelFuncao(View view){
        EditText fnome = findViewById(R.id.et_funcaoname);

        FuncaoDAO aux = new FuncaoDAO(Funcoes_activity.this);

        try {
            aux.delFuncao(fnome.getText().toString());
        }
        catch (Exception e){

        }

    }




}