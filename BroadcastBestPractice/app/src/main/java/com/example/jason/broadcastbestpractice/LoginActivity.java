package com.example.jason.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //获取id
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        //获取本地文本缓存信息
        readData();


        //点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取账号与密码
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                Log.d(TAG, "account: " + account + "  password:  " + password);
                //如果账号密码正确则跳转
                if (account.equals("admin") && password.equals("123456")) {
                    //保存数据-》文件系统-》》写到文件中去
                    saveData(account, password);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData() {
        try {
            //第一种文件路径
            //File file = new File("/data/data/com.example.jason.broadcastbestpractice/qqinfo.txt");
            File file = new File(getCacheDir(), "/qqinfo.txt");

            //判断文件是否存在
            if (file.exists() && file.length() > 0) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line.contains(",")) {
                    String[] datas = line.split(",");
                    accountEdit.setText(datas[0]);
                    passwordEdit.setText(datas[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void saveData(String account, String password) {
        try {
            File file = new File("/data/data/com.example.jason.broadcastbestpractice/qqinfo.txt");
            //字符流第一种方法
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            //第二种方法
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

//              有SharedPreferences方法写数据
//            SharedPreferences sp = getSharedPreferences("qqinfo.txt",MODE_PRIVATE);
            //给sp键值 p =
//            SharedPreferences.Editor editor = sp.edit();
//            editor.putString("username",account);
//            editor.putString("password",password);

            writer.write(account + "," + password);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
