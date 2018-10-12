package com.example.jason.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private ArrayList<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.创建一个列表
        ListView listView = (ListView)findViewById(R.id.list_view);
        //2.创建一些数据
        initFruits();
        //3 将数据导入ListView
        // 创建实例化一个adapter 将数据传入其中
        NewFuritAdapter adapter = new NewFuritAdapter(fruitList);
//        FuritAdapter adapter = new FuritAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(adapter);

        




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void initFruits() {
        for (int i = 0; i < 12; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}


//private  String[] data= {"apple","Banana","orange","watermelon","pear","Grape","Cheey","Mango","c","d","e","f","g","a","重复","apple","Banana","orange","watermelon","pear","Grape"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
////                MainActivity.this,android.R.layout.simple_list_item_1,data
////        );
////        ListView listView = (ListView)findViewById(R.id.list_view);
////        listView.setAdapter(adapter);