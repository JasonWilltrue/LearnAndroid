package com.example.jason.onecode_databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }

    public void createBase_Btn(View view) {
        dbHelper.getWritableDatabase();
    }


    public void addData_Btn(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
//        开始加入第一组数据
        values.put("name", "The da vinci Code");
        values.put("author", "Dan");
        values.put("pages", 455);
        values.put("price", 20.35);
        db.insert("Book", null, values); //插入第一条数据
        values.clear();
        values.put("name", "The lost Symbol");
        values.put("author", "Jack");
        values.put("pages", 100);
        values.put("price", 10.11);
        db.insert("Book", null, values);
    }

    public void updataData_Btn(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", 10.99);
        //需要更新的是第几行
        String[] updateCode = new String[]{"The da vinci Code"};
        db.update("Book", values, "name=?", updateCode);
    }

    public void deleteData_Btn(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] deleteCode = new String[]{"455"};
        db.delete("Book", "page>?", deleteCode);
    }

    public void query_Btn(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do {
              //遍历所有对象取出数据打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d("520it", "book name is: "+name);
                Log.d("520it", "book author is: "+author);
                Log.d("520it", "book pages is: "+pages);
                Log.d("520it", "book price is: "+price);

            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}
