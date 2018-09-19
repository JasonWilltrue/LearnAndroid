package com.example.jason.xiaomasize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileReader;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //字符串转int类型  但前提条件是 str 必须只含数字
        //Integer.parseInt(String str);


        String[] list = {"10","210","100"};
        String arr1 = list[0];
        int leg = Integer.parseInt(list[1]);

//        BufferedReader br = new BufferedReader(new FileReader("friends.txt"));
//        String line;
//        while ((line = br.readLine()) != null){
//            String[] array = line.split(",");
//            String name = array[0]; //字符串
//            int  age  = Integer.parseInt(array[1]); //字符串转int类型
//            Hero hero = new Hero(name,age);
//            list.add(hero);
//        }

    }

}
