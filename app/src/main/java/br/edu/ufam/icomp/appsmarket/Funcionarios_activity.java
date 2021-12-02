package br.edu.ufam.icomp.appsmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Funcionarios_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);
    }

    public void onClickAddFuncionario(View view){
        EditText id = findViewById(R.id.et_funcionarioid);
        EditText nome = findViewById(R.id.et_funcionarionome);
        EditText sobrenome = findViewById(R.id.et_funcionariosobrenome);
        EditText idFunc = findViewById(R.id.et_funcionariofuncid);
        EditText senha = findViewById(R.id.et_funcionariosenha);

        Funcionario tmp = new Funcionario(Integer.parseInt(id.getText().toString()),nome.getText().toString(),sobrenome.getText().toString(),Integer.parseInt(idFunc.getText().toString()),senha.getText().toString());
        FuncionarioDAO aux = new FuncionarioDAO(Funcionarios_activity.this);
        try {
            aux.addFuncionario(tmp);
        }
        catch (Exception e){

        }

    }

    public void onClickGetFuncionario(View view){
        EditText nome = findViewById(R.id.et_funcionarionome);

        Funcionario tmp = new Funcionario(1,nome.getText().toString()," ",-1," ");
        FuncionarioDAO aux = new FuncionarioDAO(Funcionarios_activity.this);
        try {
            tmp = aux.getFuncionario(tmp.getNome());
        }
        catch (Exception e){

        }

    }

    public void onClickAttFuncionario(View view){
        EditText id = findViewById(R.id.et_funcionarioid);
        EditText nome = findViewById(R.id.et_funcionarionome);
        EditText sobrenome = findViewById(R.id.et_funcionariosobrenome);
        EditText idFunc = findViewById(R.id.et_funcionariofuncid);
        EditText senha = findViewById(R.id.et_funcionariosenha);

        Funcionario tmp = new Funcionario(Integer.parseInt(id.getText().toString()),nome.getText().toString(),sobrenome.getText().toString(),Integer.parseInt(idFunc.getText().toString()),senha.getText().toString());
        FuncionarioDAO aux = new FuncionarioDAO(Funcionarios_activity.this);
        try {
            aux.updateFuncionario(tmp);
        }
        catch (Exception e){

        }

    }

    public void onClickDelFuncionario(View view){

        EditText nome = findViewById(R.id.et_funcionarionome);


        Funcionario tmp = new Funcionario(1,nome.getText().toString()," ",-1," ");
        FuncionarioDAO aux = new FuncionarioDAO(Funcionarios_activity.this);
        try {
            aux.delFuncionario(tmp.getNome());
        }
        catch (Exception e){

        }

    }
}