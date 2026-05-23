package com.example.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText emailInput,passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput=findViewById(R.id.emailInput);
        passwordInput=findViewById(R.id.passwordInput);
        loginButton=findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {

            String email=emailInput.getText().toString();
            String password=passwordInput.getText().toString();

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,
                        "Enter email and password",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent =
                        new Intent(LoginActivity.this,
                                MainActivity.class);

                startActivity(intent);
            }

        });

    }
}