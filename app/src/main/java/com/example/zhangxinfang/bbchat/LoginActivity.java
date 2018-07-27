package com.example.zhangxinfang.bbchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.zhangxinfang.bbchat.R.id.password;

public class LoginActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "loginActivity";
    private static final int REQUEST_CODE_TO_REGISTER = 0x001;
    //界面控件
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button turnRegisteButton;
    private Button turnForgetPasswordButton;
    String result = "";
    // 整个平台的Controller，负责管理整个SDK的配置、操作等处理
//    private UMSocialService mController = UMServiceFactory
//            .getUMSocialService(AppConstants.DESCRIPTOR);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);

        accountEdit = this.findViewById(R.id.account);
        accountEdit.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        accountEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        passwordEdit = this.findViewById(R.id.password);
        passwordEdit.setImeOptions(EditorInfo.IME_ACTION_DONE);//完成
        passwordEdit.setImeOptions(EditorInfo.IME_ACTION_GO);//去往
        passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
        passwordEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_GO) {
                    clickLogin();
                }
                return false;
            }
        });
    }

    private void clickLogin() {
        String account = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if (checkInput(account, password)) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //android4.0后的新的特性，网络数据请求时不能放在主线程中。
                    //使用线程执行访问服务器，获取返回信息后通知主线程更新UI或者提示信息。
                    final Handler handler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            if (msg.what == 1) {
                                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_LONG).show();
//                                TextUtils.showShort(LoginActivity.this, result);
                                if (result.contains("|")) {
                                    Toast.makeText(LoginActivity.this, "密码错误......", Toast.LENGTH_LONG).show();

                                } else {
                                    final Intent it = new Intent(LoginActivity.this, HomepageActivity.class); //你要转向的Activity
                                    Timer timer = new Timer();
                                    TimerTask task = new TimerTask() {
                                        @Override
                                        public void run() {
                                            startActivity(it); //执行
                                        }
                                    };
                                    timer.schedule(task, 1000); //1秒后
                                }
                            }
                        }
                    };
                    new Thread() {
                        public void run() {
                            try {
                                Login(accountEdit.getText().toString(), passwordEdit.getText().toString());
                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }
                            Message m = new Message();
                            m.what = 1;
                            handler.sendMessage(m);
                        }
                    }.start();
                }
            });

        }
    }

    public Boolean Login(String account,String password) throws IOException,JSONException{
        try{
            String httpUrl="";
            URL url=new URL(httpUrl);//创建一个URL
            HttpURLConnection connection  = (HttpURLConnection)url.openConnection();//通过该url获得与服务器的连接
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");//设置请求方式为post
            connection.setConnectTimeout(3000);//设置超时为3秒
            //设置传送类型
            connection.setRequestProperty("json", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            //提交数据
            String data = "&passwd=" + URLEncoder.encode(password, "UTF-8")+ "&number=" + URLEncoder.encode(account, "UTF-8")+ "&cardid=";//传递的数据
            connection.setRequestProperty("Content-Length",String.valueOf(data.getBytes().length));
            Toast.makeText(this,"数据提交成功......",Toast.LENGTH_LONG).show();
//            ToastUtils.showShort(this, "数据提交成功......");
            //获取输出流
            OutputStream os = connection.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            //获取响应输入流对象
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(is);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            //读取服务器返回信息
            while ((line = bufferedReader.readLine()) != null){
                strBuffer.append(line);
            }
            result = strBuffer.toString();
            is.close();
            connection.disconnect();
        }catch (Exception e){
            return true;
        }
        return true;
    }

    public boolean checkInput (String account, String password){
        if (account == null || account.trim().equals("")) {
            //trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾的空格都被删除了
            //trim().equals("")判断字符串两边是否有空白字符，有则false,否则true
            Toast.makeText(this, R.string.tip_account_empty_toast, Toast.LENGTH_SHORT).show();
            //Toast.makeText使用方法:      https://blog.csdn.net/qq_28301007/article/details/52335360
        } else {
            // 账号不匹配手机号格式（11位数字且以1开头）
//            if ( !RegexUtils.checkMobile(account)) {
//                Toast.makeText(this, R.string.tip_account_regex_not_right_toast,
//                        Toast.LENGTH_LONG).show();
//            }
            if (password == null || password.trim().equals("")) {
                Toast.makeText(this, R.string.tip_password_can_not_be_empty_toast,
                        Toast.LENGTH_LONG).show();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick (View v){
          Intent intent = null;
          switch (v.getId()){
              case R.id.btn_login:
                  clickLogin();
                  break;
              case R.id.btn_turn_register:
                  enterRegister();
                  break;
              case R.id.btn_turn_forget_password:
                  enterForgetPwd();
                  break;
              default:
                  break;
          }

    }
    /**
     * 跳转到注册页面
     */
    private void enterRegister() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivityForResult(intent, REQUEST_CODE_TO_REGISTER);

    }
    /**
     * 跳转到忘记密码
     */
    private void enterForgetPwd() {
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        startActivity(intent);

    }

}
