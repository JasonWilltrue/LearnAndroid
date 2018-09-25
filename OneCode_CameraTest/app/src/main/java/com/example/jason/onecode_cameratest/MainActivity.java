package com.example.jason.onecode_cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO =1;
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
        //隐试intent
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //指定图片的输出地址
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        //它会有更onActivityResult的回调
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
            if(resultCode == RESULT_OK){
                try{
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                            .openInputStream(imageUri));
                    picture.setImageBitmap(bitmap);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            break;
            default:
                break;
        }
    }
}
