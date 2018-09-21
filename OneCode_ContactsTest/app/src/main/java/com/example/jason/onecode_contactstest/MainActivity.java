package com.example.jason.onecode_contactstest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ui控件
        ListView contactsView = (ListView) findViewById(R.id.contacts_view);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);

        contactsView.setAdapter(adapter);
        //权限控制 判断用户是否已经授权
        /**
         *   context 上下文
         *    Manifest.permission.READ_CONTACTS 具体权限名
         *
         */
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            //如果没有授权则
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission
                    .READ_CONTACTS}, 1);
        } else {
            Log.d("520it", "走这里");
            readContacts();

        }
    }

    private void readContacts() {
        Cursor cursor = null;
        try {
            //查询联系人
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone
                    .CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    //获取联系人
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract
                            .CommonDataKinds.Phone.DISPLAY_NAME));
                    //手机号
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract
                            .CommonDataKinds.Phone.NUMBER));
                    contactsList.add(displayName + "\n" + number);
                    Log.d("520it", "联系人" + contactsList);

                }
                // 通知listview刷新
                adapter.notifyDataSetChanged();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /**
     * 提示框选择之后 无论结果如何都会走回调这里
     * 授权结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults 授权结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]
            grantResults) {

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts();
                } else {
                    Toast.makeText(this, "你拒绝了授权", Toast.LENGTH_SHORT).show();
                }
                break;
            default:

        }
    }

}
