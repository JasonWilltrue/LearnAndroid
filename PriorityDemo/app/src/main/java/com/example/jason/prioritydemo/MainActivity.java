package com.example.jason.prioritydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static void main(String[] args) {
        // 创建帐户，给定余额为1000
        Bank bank=new Bank("1100",1000);
        //创建线程对象
        SaveAccount sa=new SaveAccount(bank);
        DrawAccount da=new DrawAccount(bank);
        Thread save=new Thread(sa);
        Thread draw=new Thread(da);
        save.start();
        draw.start();
        try {
            draw.join();
            save.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(bank);
    }
}
