package com.example.aluno.assss;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class testeActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button add;
    private Button fechar;
    private Button limpar;
    private TextView texto;
    private EditText pagamento;
    private String itensV = "";
    private double total = 0;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        formatter = new DecimalFormat("#0.00");

        spinner = (Spinner) findViewById(R.id.fidget);
        add = (Button) findViewById(R.id.bAdd);
        fechar = (Button) findViewById(R.id.bFeche);
        limpar = (Button) findViewById(R.id.Limpar);
        texto = (TextView) findViewById(R.id.textItens);
        pagamento = (EditText) findViewById(R.id.tPagamento);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                itensV += (String) spinner.getSelectedItem() +",\n";
                String[] p1 = itensV.split(",");
                for(int c = 0; c<p1.length-1; c++){
                  total += Double.parseDouble(p1[c].substring(p1[c].indexOf("$")).replace(",", "").replace("$", ""));
               //     System.out.println( p1[c].substring(p1[c].indexOf("$")));
                }
                texto.setText(itensV+formatter.format(total));

            }
        });
        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itensV == "") {
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(testeActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(testeActivity.this);
                    }
                    builder.setTitle("erro")
                            .setMessage("selecione um item ")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }else if(pagamento.getText().toString().isEmpty()){
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(testeActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(testeActivity.this);
                    }
                    builder.setTitle("erro")
                            .setMessage("coloque o pagamento")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }else{
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(testeActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(testeActivity.this);
                    }
                    builder.setTitle("sucesso")
                            .setMessage("o troco é R$: " + (Double.parseDouble(pagamento.getText().toString()) - total))
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("");
                itensV = "";
                total = 0;
            }
        });
    }


}
