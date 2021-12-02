package br.edu.ufam.icomp.appsmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
    }

    public void onClickAddProduto(View view){
        EditText pid = findViewById(R.id.et_prodid);
        EditText pnome = findViewById(R.id.et_prodname);
        EditText pmed = findViewById(R.id.et_prodmedida);
        EditText pcod = findViewById(R.id.et_prodcodbar);
        EditText pfab = findViewById(R.id.et_prodfab);
        EditText valv = findViewById(R.id.et_prodvalvenda);
        EditText valc = findViewById(R.id.et_prodvalcompra);

        int id = Integer.parseInt(pid.getText().toString());
        String nome = pnome.getText().toString();
        String med = pmed.getText().toString();
        int cbar = Integer.parseInt(pcod.getText().toString());
        String fab = pfab.getText().toString();
        float pvenda = Float.parseFloat(valv.getText().toString());
        float pcompra = Float.parseFloat(valc.getText().toString());


        Produto tmp = new Produto(id,nome,med,fab,cbar,pvenda,pcompra);
        ProdutoDAO aux = new ProdutoDAO(ProdutosActivity.this);

        try {
            aux.addProduto(tmp);
            Toast.makeText(ProdutosActivity.this, "FOI!!!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(ProdutosActivity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void onClickGetProduto(View view){
        EditText pid = findViewById(R.id.et_prodid);
        EditText pnome = findViewById(R.id.et_prodname);
        EditText pmed = findViewById(R.id.et_prodmedida);
        EditText pcod = findViewById(R.id.et_prodcodbar);
        EditText pfab = findViewById(R.id.et_prodfab);
        EditText valv = findViewById(R.id.et_prodvalvenda);
        EditText valc = findViewById(R.id.et_prodvalcompra);

        int id = Integer.parseInt(pid.getText().toString());
        String nome = pnome.getText().toString();
        String med = pmed.getText().toString();
        int cbar = Integer.parseInt(pcod.getText().toString());
        String fab = pfab.getText().toString();
        float pvenda = Float.parseFloat(valv.getText().toString());
        float pcompra = Float.parseFloat(valc.getText().toString());


        Produto tmp = new Produto(id,nome,med,fab,cbar,pvenda,pcompra);
        ProdutoDAO aux = new ProdutoDAO(ProdutosActivity.this);

        try {
            aux.getProduto(tmp.getBarCodigo());
            Toast.makeText(ProdutosActivity.this, "FOI!!!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(ProdutosActivity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onClickAttProduto(View view){
        EditText pid = findViewById(R.id.et_prodid);
        EditText pnome = findViewById(R.id.et_prodname);
        EditText pmed = findViewById(R.id.et_prodmedida);
        EditText pcod = findViewById(R.id.et_prodcodbar);
        EditText pfab = findViewById(R.id.et_prodfab);
        EditText valv = findViewById(R.id.et_prodvalvenda);
        EditText valc = findViewById(R.id.et_prodvalcompra);

        int id = Integer.parseInt(pid.getText().toString());
        String nome = pnome.getText().toString();
        String med = pmed.getText().toString();
        long cbar = Long.parseLong(pcod.getText().toString());
        String fab = pfab.getText().toString();
        float pvenda = Float.parseFloat(valv.getText().toString());
        float pcompra = Float.parseFloat(valc.getText().toString());


        Produto tmp = new Produto(id,nome,med,fab,cbar,pvenda,pcompra);
        ProdutoDAO aux = new ProdutoDAO(ProdutosActivity.this);

        try {
            aux.updateProduto(tmp.getIdProduto());
            Toast.makeText(ProdutosActivity.this, "FOI!!!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(ProdutosActivity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onClickDelProduto(View view){
        EditText pid = findViewById(R.id.et_prodid);
        EditText pnome = findViewById(R.id.et_prodname);
        EditText pmed = findViewById(R.id.et_prodmedida);
        EditText pcod = findViewById(R.id.et_prodcodbar);
        EditText pfab = findViewById(R.id.et_prodfab);
        EditText valv = findViewById(R.id.et_prodvalvenda);
        EditText valc = findViewById(R.id.et_prodvalcompra);

        int id = Integer.parseInt(pid.getText().toString());
        String nome = pnome.getText().toString();
        String med = pmed.getText().toString();
        int cbar = Integer.parseInt(pcod.getText().toString());
        String fab = pfab.getText().toString();
        float pvenda = Float.parseFloat(valv.getText().toString());
        float pcompra = Float.parseFloat(valc.getText().toString());


        Produto tmp = new Produto(id,nome,med,fab,cbar,pvenda,pcompra);
        ProdutoDAO aux = new ProdutoDAO(ProdutosActivity.this);

        try {
            aux.delProduto(tmp.getBarCodigo());
            Toast.makeText(ProdutosActivity.this, "FOI!!!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(ProdutosActivity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}