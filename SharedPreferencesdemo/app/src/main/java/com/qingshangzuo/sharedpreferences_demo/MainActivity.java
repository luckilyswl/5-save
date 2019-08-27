package com.qingshangzuo.sharedpreferences_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText user, pwd;
    private Button login;
    private CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);


        final android.content.SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.SharedPreferences.Editor editor = sp.edit();
                editor.putString("userName",user.getText().toString());
                //字符串转化int
                editor.putInt("userPwd",Integer.parseInt(pwd.getText().toString()));
                editor.putBoolean("cb1",cb1.isChecked());
                editor.putBoolean("cb2",cb2.isChecked());
                editor.commit();
                Intent intent = new Intent(MainActivity.this,SharedPreferences.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.content.SharedPreferences sp1 = getSharedPreferences("switch",MODE_PRIVATE);
        final boolean switch1 = sp1.getBoolean("switch1",false);
        final boolean switch2 = sp1.getBoolean("switch2",false);
        cb1.setChecked(switch1);
        cb2.setChecked(switch2);
    }
}
