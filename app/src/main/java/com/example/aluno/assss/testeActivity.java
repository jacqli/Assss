package com.example.aluno.assss;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class testeActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button add;
    private Button fechar;
    private TextView texto;
    private EditText pagamento;
    private TextView troco;
    private String itensV = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        spinner = (Spinner) findViewById(R.id.fidget);
        add = (Button) findViewById(R.id.bAdd);
        fechar = (Button) findViewById(R.id.bFeche);
        texto = (TextView) findViewById(R.id.textItens);
        pagamento = (EditText) findViewById(R.id.tPagamento);
        troco =        (TextView) findViewById(R.id.tTroco);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itensV += (String) spinner.getSelectedItem() +",\n";
            texto.setText(itensV);
            }
        });
        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String[] p1 = itensV.split(",");

                troco.setText(p1[1]);
            }
        });
    }


}
