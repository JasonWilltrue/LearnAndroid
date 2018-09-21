package com.example.jason.onecode_litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.sql.Connection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //create
    public void createBase_Btn(View view) {
        Connector.getDatabase();
    }
    //add data
    public void addData_Btn(View view) {
        Book book = new Book();
        book.setName("The Da Vinci Code");
        book.setAuthor("Dan");
        book.setPages(454);
        book.setPrice(19.90);
        book.setPress("Unkonw");
        book.save();
    }

    public void updataData_Btn(View view) {
        Book book = new Book();
//        book.setPrice(14.55);
//        book.setPress("Anchor");
//        book.updateAll("name=? and author = ?","The lost Symbol","Dan Borwn");
//        更新默认值;
        book.setToDefault("pages");
        book.updateAll();
    }

    public void deleteData_Btn(View view) {
        DataSupport.deleteAll(Book.class,"price<?","15");
    }

    public void query_Btn(View view) {
        List<Book> books = DataSupport.findAll(Book.class);
        for(Book book:books){
            Log.d("520it", "book name is"+book.getName());
            Log.d("520it", "book author is"+book.getAuthor());
            Log.d("520it", "book pages is"+book.getPages());
            Log.d("520it", "book price is"+book.getPrice());
            Log.d("520it", "book press is"+book.getPress());
        }
    }



}
