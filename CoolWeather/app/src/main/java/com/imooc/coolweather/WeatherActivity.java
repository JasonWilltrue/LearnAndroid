package com.imooc.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.imooc.coolweather.gson.Weather;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        /**
         * 将请求数据展示在界面上
         */

    }

    /**
     * 根据天气id请求城市天气信息
     * @param weatherId
     */
    public void requestWeather(final String weatherId){


    }

    /**
     * 处理并展示实体类中数据
     * @param weather
     */
    public void showWeatherInfo(Weather weather){

    }


}
