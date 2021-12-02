package br.edu.ufam.icomp.appsmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GerenteActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerente2);
    }

    public void onClickFuncao(View view){
        Intent intent = new Intent(this,Funcoes_activity.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_funcao);
        startActivity(intent);
    }

    public void onClickFuncionario(View view){
        Intent intent = new Intent(this,Funcionarios_activity.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_funcionario);
        startActivity(intent);

    }

    public void onClickFornecedores(View view){
        Intent intent = new Intent(this,Fornecedores_activity.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_fornecedores);
        startActivity(intent);

    }

    public void onClickProdutos(View view){
        Intent intent = new Intent(this,ProdutosActivity.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_produtos);
        startActivity(intent);

    }

    public void onClickEstoque(View view){
        Intent intent = new Intent(this,EstoqueActivity.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_estoque);
        startActivity(intent);

    }

    public void onClickCupons(View view){
        Intent intent = new Intent(this,CuponsActivicty.class);

        startActivity(intent);

    }

    public void onClickProdutosVendidos(View view){
        Intent intent = new Intent(this,ProdutosVendidosActivicty.class);

        Button btn_funcao;

        btn_funcao = findViewById(R.id.btn_produtosVendidos);
        startActivity(intent);

    }
}