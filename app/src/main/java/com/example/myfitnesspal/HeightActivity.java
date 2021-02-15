package com.example.myfitnesspal;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HeightActivity extends AppCompatActivity  {

    Button next;
    EditText mShowDialog, height, weightEt;
    Dialog heightDialog;
    Button set;
    String feet, inch, centiMeter = "0";
    boolean isFeetLay;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);


        progress = new ProgressDialog(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("You");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"kg ", "lb ", "st "};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        height = findViewById(R.id.height_ed);
        weightEt = findViewById(R.id.weighEt);

        next = findViewById(R.id.Next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!TextUtils.isEmpty(height.getText().toString())) {
                    if(!TextUtils.isEmpty(weightEt.getText().toString())) {
                        final ProgressDialog dialog = new ProgressDialog(HeightActivity.this);
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
                    } else {
                        errorDialog("weight");
                    }
                } else {
                    errorDialog("height");
                }
            }
        });


height.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        openHeightDialod();
    }
});
    }

    private void openHome() {
        Intent intent = new Intent(HeightActivity.this, Home.class);
        startActivity(intent);
    }

    private void errorDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(HeightActivity.this);
        builder.setCancelable(true);
        builder.setMessage("Please provide "+msg+".");
        builder.setTitle("Error");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void openHeightDialod() {
        isFeetLay = true;
        heightDialog = new Dialog(this);
        heightDialog.setContentView(R.layout.height_dialog);
        heightDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final LinearLayout cm, ft, in;
        cm = heightDialog.findViewById(R.id.cm);
        ft = heightDialog.findViewById(R.id.ft);
        in = heightDialog.findViewById(R.id.in);
        final EditText ftEt = heightDialog.findViewById(R.id.ftEt);
        final EditText inchEt = heightDialog.findViewById(R.id.inchEt);
        final EditText centiEt = heightDialog.findViewById(R.id.centiEt);
        Spinner dropdown = heightDialog.findViewById(R.id.scal_spin);
        String[] items = new String[]{"Feet & Inches", "Centimeters"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        cm.setVisibility(View.GONE);
                        ft.setVisibility(View.VISIBLE);
                        in.setVisibility(View.VISIBLE);
                        isFeetLay = true;

                        break;
                    case 1:
                        cm.setVisibility(View.VISIBLE);
                        ft.setVisibility(View.GONE);
                        in.setVisibility(View.GONE);
                        isFeetLay = false;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button set = heightDialog.findViewById(R.id.set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFeetLay) {
                    inch = inchEt.getText().toString();
                    feet = ftEt.getText().toString();
                    centiMeter = "0";
                    height.setText(String.format("%s ft %s in", feet, inch));
                } else {
                    inch = "0";
                    feet = "0";
                    centiMeter = centiEt.getText().toString();
                    height.setText(centiMeter + " cm");
                }
                heightDialog.dismiss();
            }
        });


        heightDialog.show();


    }


}