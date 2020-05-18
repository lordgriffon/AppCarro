package com.example.appcarro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Veiculos_Activity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veiculos_layout);


        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rodney Lataria");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mCadastrar:
                Intent intent = new Intent(Veiculos_Activity.this,CadastraVeiculoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAlterar:
                Toast.makeText(getApplicationContext(), "Cliquei em Alterar", Toast.LENGTH_LONG).show();
                break;
            case R.id.mVoltar:
                Intent voltar = new Intent(Veiculos_Activity.this,Login_Activity.class);
                startActivity(voltar);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
