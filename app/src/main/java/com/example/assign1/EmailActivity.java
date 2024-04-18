package com.example.assign1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmailActivity extends AppCompatActivity {
    private EditText subject,content;
    private Button send,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          subject=findViewById(R.id.subjectTxt);
          content=findViewById(R.id.contentTxt);
          send=findViewById(R.id.sendBtn);
          back=findViewById(R.id.back);
            return insets;
        });
    }
    public void sendBtnOnClick(View view){
        String s,c;
        s=subject.getText().toString();
        c=content.getText().toString();
        if(s.equals("")&&c.equals("")){
            Toast.makeText(EmailActivity.this,"ALL fields are required",Toast.LENGTH_SHORT).show();

        }
        else{
            sendEmail(s,c);
        }
    }
    public void sendEmail(String s,String c){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"batoolalshine@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,s);
        intent.putExtra(Intent.EXTRA_TEXT,c);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose email client"));

    }
    public void backBtnOnClick(View view){
        Intent intent = new Intent(EmailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}