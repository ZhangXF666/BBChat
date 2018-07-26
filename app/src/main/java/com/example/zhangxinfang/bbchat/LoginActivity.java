package com.example.zhangxinfang.bbchat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.zhangxinfang.bbchat.R.id.password;

public class LoginActivity extends Activity implements View.OnClickListener {
    private static final String TAG="loginActivity";
    //界面控件
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button turnRegisteButton;
    private Button turnForgetPasswordButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }
    private void initViews(){
        loginButton=findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);

        accountEdit=this.findViewById(R.id.account);
        accountEdit.setImeOptions(EditorInfo.IME_ACTION_NEXT);//???
        accountEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//???

        passwordEdit = this.findViewById(R.id.password);
        passwordEdit.setImeOptions(EditorInfo.IME_ACTION_DONE);//完成
        passwordEdit.setImeOptions(EditorInfo.IME_ACTION_GO);//去往
        passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
        passwordEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_DONE||actionId==EditorInfo.IME_ACTION_GO){
                    clickLogin();
                }
                return false;
            }
        });
    }
    private void clickLogin(){
        String account = accountEdit.getText().toString();
        String password=passwordEdit.getText().toString();
        if(checkInput(account,password)){
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //android4.0后的新的特性，网络数据请求时不能放在主线程中。
                    //使用线程执行访问服务器，获取返回信息后通知主线程更新UI或者提示信息。

                }
            });
        }
    }
    public boolean checkInput(String account,String password){
        if (account==null||account.trim().equals("")){
               //trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾的空格都被删除了
               //trim().equals("")判断字符串两边是否有空白字符，有则false,否则true
            Toast.makeText(this,R.string.tip_account_regex_not_right,Toast.LENGTH_SHORT).show();
               //Toast.makeText使用方法:      https://blog.csdn.net/qq_28301007/article/details/52335360
        }

    }
    @Override
    public void onClick(View view) {


    }
}
