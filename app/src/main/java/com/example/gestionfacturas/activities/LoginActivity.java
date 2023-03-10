package com.example.gestionfacturas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionfacturas.R;
import com.example.gestionfacturas.persistence.IDAOUser;
import com.example.gestionfacturas.models.UserModel;

public class LoginActivity extends AppCompatActivity {


    private EditText txtUser;
    private EditText txtPass;
    private Button btnLogin;
    private IDAOUser daoUser = IDAOUser.getInstance();
    private Context _context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _context = this;

        txtUser = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUser.getText().toString();
                String userPass = txtPass.getText().toString();

                UserModel user = daoUser.login(userName,userPass);

                if(user == null){
                    Toast.makeText(_context, "Usuario incorrecto", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent intent = new Intent(_context,MainActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
            }
        });
    }
}