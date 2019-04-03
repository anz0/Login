package com.example.az.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.az.login.MainActivity.userNmb;
import static com.example.az.login.MainActivity.userPs;

public class LoginPage extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView2.setText(userNmb + ": 欢迎你的到来!\n\n" + "请牢记你的密码: \n" + userPs);

    }
}
