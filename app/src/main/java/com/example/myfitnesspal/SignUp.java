package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class SignUp extends AppCompatActivity {

    private Button btnemail;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sign_up);



         Toolbar toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setTitle("Sign Up");
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);


         btnemail=findViewById(R.id.email);
         btnemail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                openEmailSignUp();
             }
         });

     }

    private void openEmailSignUp() {
        Intent intent = new Intent(SignUp.this, EmailSignUp.class);
        startActivity(intent);
    }


}