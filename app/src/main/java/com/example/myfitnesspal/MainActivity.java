package com.example.myfitnesspal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends MyBaseActivity {

    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAllFunction();
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }


        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();
            }
        });
    }



    private void openSignup() {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);

    }

    private void openLogIn() {
        Intent intent = new Intent(MainActivity.this, LogIn.class);
        startActivity(intent);
    }




}