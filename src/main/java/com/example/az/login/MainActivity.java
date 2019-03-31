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
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                //startActivityForResult(intent, REQUEST_CODE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterPage.class));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resuleCode, Intent data) {
        //筛选当前页面请求码所对应的数据
        if(requestCode == REQUEST_CODE) {
            //
            if(resuleCode == RESULT_OK) {
                String dataUser = data.getStringExtra("userData");
                String s[] = dataUser.split("@");
                Toast.makeText(MainActivity.this, s[0], Toast.LENGTH_SHORT).show();
            }
        }
    }
}
