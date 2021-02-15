package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textview.MaterialTextView;

public class Home extends MyBaseActivity {
    MaterialTextView UserName;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewAllFunction();
        initViewResource();
        

    }
    public  void initViewResource(){
        drawerLayout=findViewById(R.id.drawer_layout);
        UserName=findViewById(R.id.user_name);
        if (UserNameString!=null) {
            UserName.setText(UserNameString);
        }
    }
    public  void ClickMenu(View view)
    {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public  void  CliclLogo(View view){
        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }
    public  void ClickHome(View view){
        recreate();
    }

    public  void ClickNutrition(View view)
    {
        redirectActivity(this,Nutrition.class);
    }
    public void  ClickMeal(View view){
        redirectActivity(this,Meal.class);

    }
    public void ClickReminder(View view){
        redirectActivity(this,Reminder.class);
    }

    public void ClickMessage(View view)
    {
        redirectActivity(this,Message.class);
    }
    public void ClickSetting(View view){
        redirectActivity(this,Settings.class);
    }
    public void ClickHelp(View view){
        redirectActivity(this,Help.class);

    }

    public void ClickLogOut(View view){
        logout(this);
    }

    public static void logout(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Log Out");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}