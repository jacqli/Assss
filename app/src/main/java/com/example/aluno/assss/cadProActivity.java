package com.example.aluno.assss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadProActivity extends AppCompatActivity {
    private EditText nome;
    private EditText preco;
    private EditText estoque;
    private Button salvar;
    private Button listarProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pro);


        nome = (EditText) findViewById(R.id.editNome);
        preco = (EditText) findViewById(R.id.editValor);
        salvar = (Button) findViewById(R.id.btnSalvar);
        listarProdutos = (Button) findViewById(R.id.btnListar);

        // Evento de clique no botão salvar
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tenta executar o código abaixo
                try {
                    // Criar objeto para salvar os valores dos campos
                    Produto p = new Produto();

                    // Definir o nome do produto, buscando o valor digitado no campo e convertendo para String
                    p.setNome( nome.getText().toString() );

                    // Busca o valor e converte para Double
                    p.setPreco( Double.parseDouble( preco.getText().toString() ) );

                    p.setEstoque(30);

                    // Salvar objeto no banco
                    p.save();

                    // Exibe uma mensagem para o usuário
                    Toast.makeText(cadProActivity.this, p.getNome() + " cadastrado!", Toast.LENGTH_SHORT).show();

                    // Limpa os campos
                    nome.setText("");
                    preco.setText("");

                    // Da foco no campo nome
                    nome.requestFocus();



                    // Caso o código acima apresente algum erro, faz o código abaixo
                } catch (Exception e){

                    // Apresenta uma mensagem na tela
                    Toast.makeText(cadProActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

                }



            }
        });


        listarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chama a outra tela
                startActivity( new Intent(cadProActivity.this, listaActivity.class) );
                Intent a = new Intent(cadProActivity.this , listaActivity.class);
                a.putExtra("as", 12);

            }
        });
    }
}
