package com.example.jason.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DbOpenHelper extends SQLiteOpenHelper implements BaseColumns {

    //    数据库名称
    public static final String DB_NAME = "contact.ab";
    //    数据库版本
    public static final int DB_VERSION = 1;

    //     数据库表的内容
    public static final String TABLE_NAME = "contactionfo";
    public static final String _USERNAME = "username";
    public static final String _PHONE = "phone";

    public static final String CREATE_CONTACT = "create table "+ TABLE_NAME
            +"("+_ID+" integer primary key autoincrement,"
            +_USERNAME+"text,"
            +_PHONE+"text)";


    //     curos 用来创建游标对象的工厂类
    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //创建数据库表  创建多个数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT);
    }

//    升级数据库    添加删除数据库表  修改数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("520it", "onUpgrade: "+ "old版本"+oldVersion+","+"new版本"+newVersion);
    }
}
