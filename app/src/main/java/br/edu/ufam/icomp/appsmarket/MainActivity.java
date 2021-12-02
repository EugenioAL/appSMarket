package br.edu.ufam.icomp.appsmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        Intent intentCaixa = new Intent(this,CaixaActivity.class);
        Intent intentGerente = new Intent(this,GerenteActivity2.class);

        Button btn_entrar;
        EditText et_name;
        EditText et_senha;

        btn_entrar = findViewById(R.id.botaoEntrar);
        et_name = findViewById(R.id.userName);
        et_senha = findViewById(R.id.userPassword);

        String nome = et_name.getText().toString();
        String senha = et_senha.getText().toString();

        FuncionarioDAO tmp = new FuncionarioDAO(MainActivity.this);
        Funcionario func_tmp = tmp.getFuncionario(nome);
        try {
            if (func_tmp.getSenha().equals(senha)) {
                FuncaoDAO auxDAO = new FuncaoDAO(MainActivity.this);
                Funcao aux = auxDAO.getFuncaoPorId(func_tmp.getIdFuncao());
                if (aux.getCategoria() > 1) {
                    intentCaixa.putExtra("login", nome);
                    startActivity(intentCaixa);
                }
                else {
                    intentGerente.putExtra("login", nome);
                    startActivity(intentGerente);
                }
            } else {
                Toast.makeText(MainActivity.this, "Senha errada!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }



    }

}