package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnLogin, btnCadastrarse, btnInicio;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin= findViewById(R.id.btnLogin);
        btnCadastrarse = findViewById(R.id.btnCadastrarse);
        btnInicio = findViewById(R.id.btnInicio);


        edtEmail.requestFocus();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().toString().isEmpty()|| edtPassword.getText().toString().isEmpty()){
                    mensagem("preencha os campos");
                            //Toast.makeText(MainActivity.this, "Preencha os campos", Toast.LENGTH_LONG).show();
                    //edtEmail.requestFocus();
                } else if (edtEmail.getText().toString().equals("login@dominio.com") &&
                            edtPassword.getText().toString().equals("123")) {
                    Intent intent = new Intent(getApplicationContext(),Principal.class);
                    startActivity(intent);

                }else {
                    mensagem("Login incorreto!");
                    //Toast.makeText(MainActivity.this, "Login incorreto!", Toast.LENGTH_LONG).show();
                    //edtEmail.requestFocus();
                }
            }
        });
        btnCadastrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),Cadastro.class);
            startActivity(intent);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Inicial.class);
                startActivity(intent);
            }
        });
    }
    private void mensagem(String info){
        Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
        edtEmail.requestFocus();
    }


}