package com.example.zhangxinfang.bbchat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText accountEdit,passwordEdit;
    private Button loginButton;
    private UserInfo userInfo;
    private CheckBox CK_save, CK_auto;
    private static final String USER_NAME = "account";
    private static final String PASSWORD = "password";

    private String account;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfo = new UserInfo(this);
        loginButton = (Button) findViewById(R.id.btn_login);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
//        CK_save = (CheckBox) findViewById(R.id.savePassword);
//        CK_auto = (CheckBox) findViewById(R.id.autoLogin);
        loginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                account=accountEdit.getText().toString();
                password=passwordEdit.getText().toString();
                if (account.equals("123") && password.equals("123")) {
//                    if (CK_save.isChecked()) {
//                        userInfo.setUserInfo(USER_NAME, account);
//                        userInfo.setUserInfo(PASSWORD, password);
//                        userInfo.setUserInfo(ISSAVEPASS, true);
//                    }
//                    if (CK_auto.isChecked()) {
//                        userInfo.setUserInfo(AUTOLOGIN, true);
//
//                    }
                    Intent i = new Intent();
                    i.setClass(MainActivity.this,SignUpActivity.class);
                    startActivity(i);

                }
            }
        });
    }
}
