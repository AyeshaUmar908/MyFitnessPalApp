package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends MyBaseActivity {

    private EditText edittextemail;
    private EditText edittextpasssword;
    private Button Loginbtn;
    private TextView forgotpassword;
    private DataBaseHelper myDb;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Log In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Loginbtn = findViewById(R.id.loginbtn);
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(LogIn.this);
                dialog.setTitle("wait");
                dialog.setMessage("processing");
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openHome();
                        if (dialog.isShowing())
                            dialog.dismiss();
                    }
                }, 2000);

            }
        });

        forgotpassword=findViewById(R.id.tvforgotpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, ForgotPassword.class );
                startActivity(intent);
            }
        });


        edittextemail= findViewById(R.id.etemail);
        edittextpasssword=findViewById(R.id.etpassword);
        Loginbtn=findViewById(R.id.loginbtn);

        myDb = new DataBaseHelper(this);

        loginUser();


        edittextemail.addTextChangedListener(loginTextWatcher );
        edittextpasssword.addTextChangedListener(loginTextWatcher);

    }

    private void openHome() {
        Intent intent = new Intent(LogIn.this, Home.class);
        startActivity(intent);
    }

    private void loginUser(){


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edittextemail.getText().toString().equals(UserEmailString)){

                    edittextemail.setError("InValid Email");
                }else if (!edittextpasssword.getText().toString().equals(UserPasswordString) ){
                    edittextpasssword.setError("InValid Password");
                }else {
                    startActivity(new Intent(LogIn.this,Home.class));
                }



            }
        });
    }




    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput=edittextemail.getText().toString().trim();
            String passwordInput=edittextpasssword.getText().toString().trim();

            Loginbtn.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}