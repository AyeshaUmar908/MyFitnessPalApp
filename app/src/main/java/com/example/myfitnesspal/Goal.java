package com.example.myfitnesspal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Goal extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton Button1, Button2, Button3;
    private Button submit;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("Goal");
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Next = findViewById(R.id.Next1);




        radioGroup = findViewById(R.id.radiogroup);
        Button1 =  findViewById(R.id.radioButtonlose);
        Button2 =  findViewById(R.id.radioButtonmaintan);
        Button3 =  findViewById(R.id.radioButtongain);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntro();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntro();
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntro();
            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Button1.isChecked() || Button2.isChecked()|| Button3.isChecked())
                openIntro();
                else
                    errorDialog();
            }
        });
    }

    private void errorDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Goal.this);
        builder.setCancelable(true);
        builder.setMessage("Please select a goal type.");
        builder.setTitle("Error");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    private void openIntro() {

        Intent intent = new Intent(Goal.this, IntroActivity.class);
        startActivity(intent);
    }

}
