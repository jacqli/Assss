package com.example.aluno.assss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class listaActivity extends AppCompatActivity {

    private TextView textProdutos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        textProdutos = (TextView) findViewById(R.id.textProdutos);

        // Buscar todos os produtos do banco
        List<Produto> produtos = Produto.listAll(Produto.class);

        // Guardar um texto com todos os produtos e valores
        String texto = "";

        // Percorrer a lista de produtos para montar o texto da tela
        for(Produto p : produtos){

            // Exemplo:
            // Salgado - R$3.80 e \n para quebrar a linha do TextView
            // texto = texto + "";
            texto += p.getNome() + " - R$" + p.getPreco() + " - " +p.getEstoque()+"\n";

        }

        // Define o texto no textview
        textProdutos.setText(texto);
    }
}
