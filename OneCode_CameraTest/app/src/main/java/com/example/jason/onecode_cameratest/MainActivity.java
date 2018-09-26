package com.example.jason.onecode_cameratest;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO =1;
    public  static  final int CHOOSE_PHOTOT =2;
    private ImageView picture;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ui控件
        picture = (ImageView) findViewById(R.id.picture);
    }

    public void takePhoto_Btn(View view) {
        //创建一个file用于存放摄像头图片
        File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
        try{
            if(outputImage.exists()){
                outputImage.delete();
            }
            outputImage.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        //判断安卓版本是否低于7.0
        if(Build.VERSION.SDK_INT >= 24){
            imageUri = FileProvider.getUriForFile(MainActivity.this,"com.example.jason" +
                    ".onecode_cameratest.fileprovider",outputImage);
        }else{
            imageUri = Uri.fromFile(outputImage);

        }
        Log.d("520it", "imagUri路径: "+imageUri);
        //隐试intent
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //指定图片的输出地址
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        //它会有更onActivityResult的回调
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTOT:
                if (resultCode == RESULT_OK) {
                    if (Build.VERSION.SDK_INT >=19)
                    {
                        handleImageOnKitat(data);
                    }else{
                        handleImageBeforeKitka(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 打开相册
     * @param view
     */
    public void openPhoto_Btn(View view) {
        //权限判断
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission
                .WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission
                    .WRITE_EXTERNAL_STORAGE},1);

        }else{
            openAlum();
        }
    }

    private void openAlum(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTOT);
    }

    @Override
    public  void onRequestPermissionsResult(int requestCode,String[] permissions,int[]
            grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openAlum();
                }else{
                    Toast.makeText(MainActivity.this,"权限拒绝",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

    @TargetApi(19)
    private void handleImageOnKitat(Intent data){
            String imagePath = null;
            Uri uri = data.getData();
            if(DocumentsContract.isDocumentUri(this,uri)){
                String docId = DocumentsContract.getDocumentId(uri);
                if("com.android.providers.media.documents".equals(uri.getAuthority())){
                    String id = docId.split(":")[1]; //解析出数字格式的id
                    //TODO 继续写
                    String selection = MediaStore.Images.Media._ID + "="+id;
                    imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            selection);

                }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                    Uri contentUri = ContentUris.withAppendedId(Uri.parse
                            ("content://downloads/public_downloads"),Long.valueOf(docId));
                    imagePath = getImagePath(contentUri,null);
                }
            }else if("content".equalsIgnoreCase(uri.getScheme())){
                imagePath = getImagePath(uri,null);
            }else if("file".equalsIgnoreCase(uri.getScheme())){
                imagePath = uri.getPath();
            }
            displayImage(imagePath);
    }

    public void  handleImageBeforeKitka(Intent data){
        Uri uri = data.getData();
        String  imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }


    private String getImagePath(Uri uri,String selection){
        String path = null;
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));

            }
            cursor.close();
        }
        return  path;
    }


    private void displayImage(String imagePath){
        if(imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap);
        }else{
            Toast.makeText(this,"获取图片失败",Toast.LENGTH_SHORT).show();
        }
    }



}
