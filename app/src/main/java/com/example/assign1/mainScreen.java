package com.example.assign1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mainScreen extends AppCompatActivity {
    public static final String Name="Name";
    private TextView helloTxt;
    private String name;
    private Button backBtn;
    private ImageButton mathBtn,physBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            helloTxt=findViewById(R.id.helloTxt);
            backBtn=findViewById(R.id.backBtn);
            mathBtn=findViewById(R.id.mathBtn);
            physBtn=findViewById(R.id.physBtn);
            Intent i = getIntent();
            name=i.getStringExtra(Name);
            helloTxt.setText(name );
            return insets;
        });
    }
    public void backBtnOnClick(View view){

        Intent intent = new Intent(mainScreen.this, MainActivity.class);
        startActivity(intent);
    }
    public void mathBtnOnClick(View view){

        Intent intent = new Intent(mainScreen.this, MathActivity.class);
        startActivity(intent);
    }
    public void physBtnOnClick(View view){

        Intent intent = new Intent(mainScreen.this, PhysActivity.class);
        startActivity(intent);
    }


}