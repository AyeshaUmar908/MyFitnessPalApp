package com.example.myfitnesspal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DateFormat;
import java.util.Calendar;

public class IntroActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button next;
    boolean isDateSelected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("You");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        next = findViewById(R.id.Next1);
        final RadioButton fBtn= findViewById(R.id.radioButtonFemale);
        final RadioButton mBtn= findViewById(R.id.radioButtonMale);
        final EditText Birthdate = findViewById(R.id.birthday);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mBtn.isChecked()||fBtn.isChecked())
                    if(isDateSelected)
                    openHeight();
                    else
                        errorDialog("Please provide birthday.");
                else
                    errorDialog("Please select a gender.");
            }
        });


        Birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    private void openHeight() {
        Intent intent = new Intent(IntroActivity.this, HeightActivity.class);
        startActivity(intent);
    }


    private void errorDialog(String msg) {
        AlertDialog.Builder builder=new AlertDialog.Builder(IntroActivity.this);
        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.setTitle("Error");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        EditText Birthdate = findViewById(R.id.birthday);
        Birthdate.setText(currentDateString);
        isDateSelected= true;
    }
}