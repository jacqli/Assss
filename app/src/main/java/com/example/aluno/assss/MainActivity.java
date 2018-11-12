package com.example.aluno.assss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

public class MainActivity extends AppCompatActivity {

private Button enterar;
    private Button cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SugarContext.init(getApplicationContext());
        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterar = (Button) findViewById(R.id.ent2);
        cadastro = (Button) findViewById(R.id.cad);


        enterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , testeActivity.class));
                Intent a = new Intent(MainActivity.this , testeActivity.class);
                a.putExtra("as", 12);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , cadProActivity.class));
                Intent a = new Intent(MainActivity.this , cadProActivity.class);
                a.putExtra("as", 12);
            }
        });
    }
}
