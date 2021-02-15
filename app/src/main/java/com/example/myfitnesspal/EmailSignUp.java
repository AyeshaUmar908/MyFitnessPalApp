package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailSignUp extends AppCompatActivity {


    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);

        final ProgressDialog progressDialog;



        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Email");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        emailSignUp = findViewById(R.id.et1);
        usernameSignUp = findViewById(R.id.et3);
        passwordSignUp = findViewById(R.id.et2);

        signUpButton = findViewById(R.id.Next);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        myDB = new DataBaseHelper(this);
        insertUser();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // ProgressDialog.dismiss();
    }

    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                 if(TextUtils.isEmpty(emailSignUp.getText().toString().trim())){
                    Toast.makeText(EmailSignUp.this, "No Empty Field Allowed", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(passwordSignUp.getText().toString().trim())){
                    Toast.makeText(EmailSignUp.this, "No Empty Field Allowed", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(usernameSignUp.getText().toString().trim())){
                    Toast.makeText(EmailSignUp.this, "No Empty Field Allowed", Toast.LENGTH_SHORT).show();

                }

                else{
                   signUpButton.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignUp.getText().toString());

                             opencongrats();
                       }


                   });
                }




            }

            private void opencongrats() {
                Intent intent = new Intent(EmailSignUp.this, Congrats.class);
                startActivity(intent);
            }


        });
    }
}