package com.example.myfitnesspal;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

abstract public class MyBaseActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    public static String UserNameString;
    public static String UserEmailString;
    public static String UserIdString;
    public static String UserPasswordString;
    private Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseHelper = new DataBaseHelper(this);
    }
    public void viewAllFunction() {
        cursor = dataBaseHelper.getAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                UserNameString=cursor.getString(1);
                UserEmailString=cursor.getString(2);
                UserPasswordString=cursor.getString(3);
                UserIdString=cursor.getString(0);
                Log.d("viewAllFunction", "User Id : "+cursor.getString(0));
                Log.d("viewAllFunction", "User Name: "+cursor.getString(1));
                Log.d("viewAllFunction", "User Email: "+cursor.getString(2));
                Log.d("viewAllFunction", "User Password: "+cursor.getString(3));
            }
        }
    }
}
