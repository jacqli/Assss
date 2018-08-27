package com.example.aluno.assss;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class testeActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button add;
    private Button fechar;
    private TextView texto;
    private String itensV = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        spinner = (Spinner) findViewById(R.id.fidget);
        add = (Button) findViewById(R.id.bAdd);
        fechar = (Button) findViewById(R.id.bFeche);
        texto = (TextView) findViewById(R.id.textItens);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itensV += (String) spinner.getSelectedItem();
            texto.setText(itensV);
            }
        });

    }

}
