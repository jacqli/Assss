package com.example.aluno.assss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class lista2Activity extends AppCompatActivity {


    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);

        lista = (ListView) findViewById(R.id.listaVer);

        List<Produto> produtos = Produto.listAll(Produto.class);
        String[] nomes = new String[produtos.size()];

        for (int i = 0; i < produtos.size(); i++) {
        nomes[i] = produtos.get(i).getNome() + " valor: "+ produtos.get(i).getPreco();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        lista.setAdapter(adapter);
    }
}
