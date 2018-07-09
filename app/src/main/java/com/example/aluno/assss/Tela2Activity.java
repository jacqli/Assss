package com.example.aluno.assss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Tela2Activity extends AppCompatActivity {
    private Button add;
    private Button fechar;
    private TextView textItens;
    private Spinner itens;
    private List<String> list = new ArrayList<String>();
    private double[] prec = {3.80,1.50,2,0.75};
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

list.add("salgado");
        list.add("refrigerante");
        list.add("bolo");
        list.add("pacoca");
        add = (Button) findViewById(R.id.bEntrar);
        fechar = (Button) findViewById(R.id.bAdd);
        textItens = (TextView) findViewById(R.id.textItens);
        itens = (Spinner) findViewById(R.id.itens);
     //   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, , android.R.layout.simple_spinner_item);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }
}
