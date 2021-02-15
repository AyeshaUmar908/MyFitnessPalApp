package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Reminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    DrawerLayout drawerLayout;
    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;

    private String format = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        drawerLayout=findViewById(R.id.drawer_layout);


        Button button = (Button)findViewById(R.id.btnrrem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepicker = new TimePickerClock();
                timepicker.show(getSupportFragmentManager(),"time Picker");
            }
        });
    }
    public void ClickMenu(View view){
        Home.openDrawer(drawerLayout);
    }
    public void  ClickLogo(View view){
        Home.closeDrawer(drawerLayout);
    }
    public  void ClickHome(View view){
        Home.redirectActivity(this,Home.class);
    }
    public void ClickHelp(View view){
        Home.redirectActivity(this, Help.class);

    }
    public void ClickSetting(View view){
        Home.redirectActivity(this, Settings.class);
    }
    public void ClickMessage(View view){
        Home.redirectActivity(this,Message.class);

    }
    public void ClickReminder(View view){
        recreate();

    }
    public void ClickMeal(View view){
        Home.redirectActivity(this,Meal.class);
    }
    public  void ClickNutrition(View view){
        Home.redirectActivity(this, Nutrition.class);

    }
    public void ClickLogOut(View view){
        Home.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        TextView textView = (TextView)findViewById(R.id.tvtime);
        textView.setText("Hour: "+i+ "Minute: "+i1);
    }
}

