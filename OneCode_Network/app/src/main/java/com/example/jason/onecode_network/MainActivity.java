package com.example.jason.onecode_network;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.send_request){
//            sendRequestWithHttpURLConnection();
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithHttpURLConnection(){
          new Thread(new Runnable() {
              @Override
              public void run() {
                  HttpURLConnection connection = null;
                  BufferedReader reader = null;
                  try {
                      URL url = new URL("http://www.qq.com");
                      connection = (HttpURLConnection) url.openConnection();
                      connection.setRequestMethod("GET");
                      connection.setConnectTimeout(8000);
                      connection.setReadTimeout(8000);
                      InputStream in = connection.getInputStream();
                      //下面读取 输入流
                      reader = new BufferedReader(new InputStreamReader(in));
                      StringBuilder response = new StringBuilder();
                      String line;
                      while ((line = reader.readLine()) != null){
                          response.append(line);
                      }
                      Log.d("520it", "run: "+response);
                      showResponse(response.toString());
                  } catch (Exception e) {
                      e.printStackTrace();
                  }finally {
                      if(reader != null){
                          try {
                              reader.close();
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
                      if(connection != null){
                          connection.disconnect();
                      }
                  }


              }
          }).start();
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            // 指定访问的服务器地址是电脑本机
                            .url("http://192.168.8.93/getdata.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    Log.d("520it", "response: "+response);
                    String responseData = response.body().string();
                    Log.d("520it", "run: "+responseData);
                    parseJSONWithJSONObject(responseData);
//                    showResponse(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private  void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }

    /**
     * 解析json数据
     */
    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("520it", "id is " + id);
                Log.d("520it", "name is " + name);
                Log.d("520it", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
