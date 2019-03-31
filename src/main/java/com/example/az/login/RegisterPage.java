package com.example.az.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.az.login.MainActivity.userNmb;
import static com.example.az.login.MainActivity.userPs;

public class RegisterPage extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        editText = (EditText) findViewById(R.id.editText4);
        editText2 = (EditText) findViewById(R.id.editText);
        editText3 = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(true) {
                    //判断昵称是否不为空
                    if (userNmb != "") {
                        userNmb = editText.getText().toString();
                    } else {
                        Toast.makeText(RegisterPage.this, "昵称不能为空！", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //判断两次密码是否相同
                    if (editText2.getText().equals(editText3.getText())) {
                        userPs = editText.getText().toString();
                    } else {
                        //Toast.makeText(RegisterPage.this, "密码不匹配", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegisterPage.this, editText2.getText()+"@"+editText3.getText(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(RegisterPage.this, editText3.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //创建空白意图
                    Intent intent = new Intent();
                    //装入要传递的数据
                    intent.putExtra("userData", userNmb + "@" + userPs);
                    //设置按当前intent的结果码
                    setResult(RESULT_OK, intent);

                    //注册成功直接跳转登陆到用户界面
                    startActivity(new Intent(RegisterPage.this, LoginPage.class));

                    finish();
                }
            }
        });

    }
}
