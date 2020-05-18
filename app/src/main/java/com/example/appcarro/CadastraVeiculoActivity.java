package com.example.appcarro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraVeiculoActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText nomeVeiculo,placaVeiculo,anoVeiculo,valorVeiculo,dataCompra,descricaoVeiculo;
    Button btnCadastrarVeiculo;
    Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_veiculo_layout);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rodney Lataria");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        db = new DatabaseHelper(this);

        nomeVeiculo = findViewById(R.id.cNomeVeiculo);
        placaVeiculo = findViewById(R.id.cPlacaVeiculo);
        anoVeiculo = findViewById(R.id.cAnoVeiculo);
        valorVeiculo = findViewById(R.id.cValorVeiculo);
        dataCompra = findViewById(R.id.cDataVeiculo);
        descricaoVeiculo = findViewById(R.id.cDescricaoVeiculo);

        btnCadastrarVeiculo = findViewById(R.id.cCadastrarVeiculo);

        btnCadastrarVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeCarro,placaCarro,dataCarro,descricaoCarro,anoCarro,valorCarro;

                nomeCarro = nomeVeiculo.getText().toString();
                placaCarro = placaVeiculo.getText().toString();
                dataCarro = dataCompra.getText().toString();
                descricaoCarro = descricaoVeiculo.getText().toString();

                anoCarro = anoVeiculo.getText().toString();
                valorCarro = valorVeiculo.getText().toString();

                Boolean inserir = db.insertCarro(nomeCarro,placaCarro,anoCarro,valorCarro,dataCarro,descricaoCarro);
                if (inserir == true){
                    Toast.makeText(getApplicationContext(), "Registro inserido com sucesso!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Erro ao inserir Registro!!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void buscar(View view) {
        Intent intent = new Intent(CadastraVeiculoActivity.this,ListarCarrosActivity.class);
        startActivity(intent);
    }
}
