package com.example.mpproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText edtForgotEmail;
    private AppCompatButton btnSend;
    private TextView txtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgot_password);
        findView();
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to LoginActivity
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtForgotEmail.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    // Passing email data to LoginActivity
                    Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                    intent.putExtra("emailData", email);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void findView() {
        edtForgotEmail = findViewById(R.id.edtForgotEmail);
        btnSend = findViewById(R.id.btnSend);
        txtLogin = findViewById(R.id.txtLogin);
    }

    }
