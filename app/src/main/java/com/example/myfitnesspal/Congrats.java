package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Congrats extends AppCompatActivity {

    private Button btnstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        Toolbar toolbar = findViewById(R.id.toolbara);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Account Created");

        btnstart=findViewById(R.id.Home);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    private void openHome() {
        Intent intent = new Intent(Congrats.this, Goal.class);
        startActivity(intent);
    }
}