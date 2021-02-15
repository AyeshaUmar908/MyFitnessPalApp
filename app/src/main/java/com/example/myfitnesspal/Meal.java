package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Meal extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        drawerLayout=findViewById(R.id.drawer_layout);

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
        Home.redirectActivity(this, Reminder.class);

    }
    public void ClickMeal(View view){
       recreate();
    }
    public  void ClickNutrition(View view){
        Home.redirectActivity(this,Nutrition.class);

    }
    public void ClickLogOut(View view){
        Home.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }

}