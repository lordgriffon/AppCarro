package com.example.appcarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Activity extends AppCompatActivity {

    DatabaseHelper db;

    EditText txtLogin,txtEmail,txtSenha,txtConfirma;
    Button btnRegistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        db = new DatabaseHelper(this);

        txtLogin =findViewById(R.id.rLogin) ;
        txtEmail =findViewById(R.id.rEmail) ;
        txtSenha =findViewById(R.id.rSenha) ;
        txtConfirma =findViewById(R.id.rCSenha) ;

        btnRegistar = findViewById(R.id.btnRegristro);



        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login,email,senha,confirmaSenha;

                login = txtLogin.getText().toString();
                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();
                confirmaSenha = txtConfirma.getText().toString();

                if (login.equals("") || email.equals("") || senha.equals("") || confirmaSenha.equals("")){
                    Toast.makeText(getApplicationContext(), "Favor inserir valores!!", Toast.LENGTH_SHORT).show();
                }else{
                    if (senha.equals(confirmaSenha)){
                        Boolean checarLogin = db.validarLogin(login);
                        Boolean chegarEmail = db.validarEmail(email);

                        if(checarLogin == true && chegarEmail == true){
                            Boolean inserir = db.insertLogin(login,email,senha);
                            if(inserir == true){
                                Toast.makeText(getApplicationContext(), "Registro inserido com sucesso!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Login ou Email inserido já existe!!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Senha não confere!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void voltarLogin(View view) {

        Intent intent = new Intent(Registro_Activity.this,Login_Activity.class);
        startActivity(intent);
    }
}
