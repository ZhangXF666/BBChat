package com.example.zhangxinfang.bbchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.welcome_text);



    }
    public void Welcome(View view){
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }


}
