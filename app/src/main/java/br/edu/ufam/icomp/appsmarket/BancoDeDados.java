package br.edu.ufam.icomp.appsmarket;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {

    public  static  final  int DATABASE_VERSION = 2;
    public  static  final  String DATABASE_NAME = "Data.db";

    private static final String SQL_ADD_ADMIN_USER = "INSERT INTO funcionarios(nome,sobrenome,funcao_id,senha) VALUES ('admin','admin',1,'admin');";
    private static final String SQL_ADD_FUNC = "INSERT INTO funcao(nome,categoria,salario) VALUES ('administrador',0,2000.4);";
    private static final String SQL_ADD_CAIXA_USER = "INSERT INTO funcionarios(nome,sobrenome,funcao_id,senha) VALUES ('caixa','caixa',2,'caixa');";
    private static final String SQL_ADD_FUNC_CAIXA = "INSERT INTO funcao(nome,categoria,salario) VALUES ('caixa',4,1000.4);";
    private static  final String SQL_CREATE_TABLE_FUNCAO = "CREATE TABLE funcao(funcao_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,nome TEXT NOT NULL, categoria INTEGER, salario REAL);";
    private static  final  String SQL_CREATE_TABLE_FUNCIONARIO = "CREATE TABLE funcionarios(funcionario_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, sobrenome TEXT NOT NULL, funcao_id INTEGER NOT NULL, senha TEXT NOT NULL,FOREIGN KEY(funcao_id) REFERENCES funcao(funcao_id));";
    private static  final  String SQL_CREATE_TABLE_FORNECEDORES = "CREATE TABLE fornecedores(fornecedor_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,nome TEXT,telefone TEXT, cnpj INTEGER );";
    private static  final  String SQL_CREATE_TABLE_PRODUTO = "CREATE TABLE produtos(produto_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,nome TEXT NOT NULL, medida TEXT,codigodebarra INTEGER, fabricante TEXT, valorvenda REAL, valorcompra REAL);";
    private static  final  String SQL_CREATE_TABLE_ESTOQUE = "CREATE TABLE estoque(produto_id INTEGER NOT NULL PRIMARY KEY, quantidademinima INTEGER, quantidadeemestoque INTEGER, FOREIGN KEY(produto_id) REFERENCES produtos(produto_id));";
    private static  final  String SQL_CREATE_TABLE_CUPONS= "CREATE TABLE cupons(cupom_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, dataemitida DATE, meiodepagamento TEXT, funcionario_id INTEGER,FOREIGN KEY(funcionario_id) REFERENCES funcionarios(funcionario_id));";
    private static  final  String SQL_CREATE_TABLE_PRODUTOSVENDIDOS = "CREATE TABLE produtosvendidos(cupom_id INTEGER, produto_id INTEGER, quantidade INTEGER,valor REAL, PRIMARY KEY (cupom_id,produto_id));";

    public BancoDeDados(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FUNCAO);
        db.execSQL(SQL_CREATE_TABLE_FUNCIONARIO);
        db.execSQL(SQL_CREATE_TABLE_FORNECEDORES);
        db.execSQL(SQL_CREATE_TABLE_PRODUTO);
        db.execSQL(SQL_CREATE_TABLE_ESTOQUE);
        db.execSQL(SQL_CREATE_TABLE_CUPONS);
        db.execSQL(SQL_CREATE_TABLE_PRODUTOSVENDIDOS);
        db.execSQL(SQL_ADD_FUNC);
        db.execSQL(SQL_ADD_ADMIN_USER);
        db.execSQL(SQL_ADD_FUNC_CAIXA);
        db.execSQL(SQL_ADD_CAIXA_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
