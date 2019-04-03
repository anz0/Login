package com.example.az.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;
    public static String userNmb = "anz";
    public static String userPs = "000000";

    private Button button;
    private Button button2;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =  (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);//密码
        editText2 = (EditText) findViewById(R.id.editText2);//账号

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //判断账号和密码是否匹配

                if(editText2.getText().toString().equals(userNmb)) {
                    if(editText.getText().toString().equals(userPs)) {

                        startActivity(new Intent(MainActivity.this, LoginPage.class));
                        return;

                    }
                }

                Toast.makeText(MainActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,RegisterPage.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //筛选当前页面请求码所对应的数据
        if(requestCode == REQUEST_CODE) {
            //筛选出结果码相同的
            if(resultCode == RESULT_OK) {
                String dataUser = data.getStringExtra("userData");

                String s[] = dataUser.split("@");
                //用户刚刚注册的账户
                userNmb = s[0];
                userPs = s[1];
            }
        }
    }
}
