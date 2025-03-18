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

public class SignupActivity extends AppCompatActivity {
    private TextView txtLogin;
    private AppCompatButton btnSignup;

    private EditText edtEmail,edtPassword ,edtName,edtConfirmPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        findView();
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignupActivity.this, LoginActivity.class);
                intent.putExtra("data","Login");
                startActivity(intent);
                finish();


            }
        });
        String data =getIntent().getStringExtra("data");
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();


    }
    private void findView(){
        edtEmail=findViewById(R.id.edtEmail);
        edtName= findViewById(R.id.edtName);
        edtPassword=findViewById(R.id.edtPassword);
        edtConfirmPassword= findViewById(R.id.edtConfirmPassword);
        btnSignup=findViewById(R.id.btnSignup);
        txtLogin = findViewById(R.id.txtLogin);

    }
}



