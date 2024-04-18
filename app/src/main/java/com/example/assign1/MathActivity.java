package com.example.assign1;

import static android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MathActivity extends AppCompatActivity {
    private Button backBtn;
    private ImageButton bookBtn,youtubeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_math);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            backBtn=findViewById(R.id.backBtnMath);
            bookBtn=findViewById(R.id.mathbookBtn);
            youtubeBtn=findViewById(R.id.mathyoutubeBtn);
          //  String path="https://www.youtube.com/watch?v=nc2GLfzrfB8&list=PLLRZuGsakJcl4j-qgTKf221Q_oKuMNL0h";

            return insets;
        });
    }
    public void backBtnOnClick(View view){

        Intent intent = new Intent(MathActivity.this, mainScreen.class);
        startActivity(intent);
    }
    public void bookBtnOnClick(View view) {
        Intent intent = new Intent(MathActivity.this, MathBookActivity.class);
        startActivity(intent);

    }
    public void youtubeBtnOnClick(View view) {
        Intent intent = new Intent(MathActivity.this, YoutubeMath.class);
        startActivity(intent);

    }
    public void questionsBtnOnClick(View view) {
        Intent intent = new Intent(MathActivity.this, MathQuestionsActivity.class);
        startActivity(intent);

    }}