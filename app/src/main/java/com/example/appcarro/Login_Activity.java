package com.example.appcarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText txtLogin,txtSenha;
    Button btnLogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        txtLogin = findViewById(R.id.idTxtlogin);
        txtSenha = findViewById(R.id.idTxtSenha);

        db = new DatabaseHelper(this);

        btnLogin = findViewById(R.id.btnEntrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login,senha;

                login = txtLogin.getText().toString();
                senha = txtSenha.getText().toString();

                Boolean chegarAcesso = db.validarUsuario(login,senha);

                if (chegarAcesso==false){
                    Log.i("btnLogin","Cliquei no botão entrar do login");
                    Intent intent = new Intent(getApplicationContext(),CadastraVeiculoActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Acesso negado!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public void sair(View view) {
        finishAffinity();
    }

    public void cadastrar(View view) {

        Intent intent = new Intent(Login_Activity.this,Registro_Activity.class);
        startActivity(intent);
    }

}
