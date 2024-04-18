package com.example.assign1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button enterBtn,emailBtn,call;
    private EditText nameTxt;
    private String name;
    static int PERMISSION_CODE=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.startScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            enterBtn=findViewById(R.id.enterBtn);
            emailBtn=findViewById(R.id.emailBtn);
            call=findViewById(R.id.callBtn);
            nameTxt=findViewById(R.id.nameTxt);
            return insets;

        });
    }
    public void enterBtnOnClick(View view){
        if (nameTxt.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Error, enter your name here !", Toast.LENGTH_SHORT).show();
                  }
        else{
         name = "Hello " +nameTxt.getText().toString()+" !";

        Intent intent = new Intent(MainActivity.this, mainScreen.class);
        intent.putExtra( mainScreen.Name,name);
        startActivity(intent);}
    }
    public void emailBtnOnClick(View view){
        Intent intent = new Intent(MainActivity.this, EmailActivity.class);
        startActivity(intent);
    }
    public void callBtnOnClick(View view){
        String phoneNumber="+970569706467";

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }
    }