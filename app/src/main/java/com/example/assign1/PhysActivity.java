package com.example.assign1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhysActivity extends AppCompatActivity {
    private Button backBtn;
    private ImageButton bookBtn,youtubeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phys);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            bookBtn=findViewById(R.id.physbookBtn);
            youtubeBtn=findViewById(R.id.physyoutubeBtn);
            backBtn=findViewById(R.id.backBtnphys);
            return insets;
        });
    }
    public void backBtnOnClick(View view){

        Intent intent = new Intent(PhysActivity.this, mainScreen.class);
        startActivity(intent);
    }
    public void youtubeBtnOnClick(View view) {
        Intent intent = new Intent(PhysActivity.this, YoutublePhys.class);
        startActivity(intent);

    }
    public void bookBtnOnClick(View view) {
        Intent intent = new Intent(PhysActivity.this,PhysBook.class);
        startActivity(intent);

    }
    public void questionsBtnOnClick(View view) {
        Intent intent = new Intent(PhysActivity.this, PhysQuestions.class);
        startActivity(intent);

    }
}