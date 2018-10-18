package com.imooc.coolweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.coolweather.db.City;
import com.imooc.coolweather.db.County;
import com.imooc.coolweather.db.Province;
import com.imooc.coolweather.util.HttpUtil;
import com.imooc.coolweather.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Choose_AreaFragment extends Fragment {
    /**
     * 遍历省市县的碎片
     */
    public static final  int LEVEL_PROVINCE = 0;
    public static final  int LEVEL_CITY =1;
    public static final  int LEVEL_COUNTY =2;

    private TextView titleText;
    private Button backButton;
    private ListView listView;

    private List<String> datalist = new ArrayList<>();

    private ArrayAdapter<String> adpater;

    //列表
    private List<Province> provinceList;
    private List<City> cityList;
    private List<County> countyList;

    //选中id
    private Province selectedProvince;
    private City selectedCity;
    private County selectedCounty;

    //当前选中的等级
    private int currentLevel;

    //进度显示
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //找到省份视图
        View view = inflater.inflate(R.layout.choose_area,container,false);

        titleText = (TextView)view.findViewById(R.id.title_text);
        backButton =(Button)view.findViewById(R.id.back_btn);
        listView =(ListView)view.findViewById(R.id.list_view);

        adpater = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,datalist);

        listView.setAdapter(adpater);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentLevel == LEVEL_PROVINCE){
                    selectedProvince = provinceList.get(position);
                    //查询
                    queryCities();
                }else if(currentLevel == LEVEL_CITY){
                    selectedCity = cityList.get(position);
                    queryCounties();
                }else if(currentLevel == LEVEL_COUNTY){
                    //如果点击县区之后跳转到天气页面
                    String weatherId = countyList.get(position).getWeatherId();
                    Intent intent = new Intent(getActivity(),WeatherActivity.class);
                    intent.putExtra("weather_id",weatherId);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

        });

        //返回按钮
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel == LEVEL_COUNTY){
                    queryCities();
                }else if(currentLevel == LEVEL_CITY){
                    queryProvinces();
                }
            }
        });
        //查询省份
        queryProvinces();
    }

    /**
     * 查询全国所有的省
     */

    private void queryProvinces(){
        //改变标题字体
        titleText.setText("中国");
        //返回按钮隐藏
        backButton.setVisibility(View.GONE);
        //读取省份数据
        provinceList = DataSupport.findAll(Province.class);
        //判断是否有数据
        if(provinceList.size()>0){
            //清空list
            datalist.clear();
            //获取每一个省份名称
            for(Province province : provinceList){
                datalist.add(province.getProvinceName());
            }
            //刷新数据列表
            adpater.notifyDataSetChanged();
            listView.setSelection(0);
            //当前级别
            currentLevel = LEVEL_PROVINCE;
        }else{
            String address = "http://guolin.tech/api/china";
            querFormServer(address,"province");
        }
    }

    private void queryCities() {
        titleText.setText(selectedProvince.getProvinceName());
        backButton.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("provinceid = ?",String.valueOf(selectedProvince.getId()))
                .find(City.class);
        if(cityList.size()>0){
            datalist.clear();
            for(City city : cityList){
                datalist.add(city.getCityName());
            }
            adpater.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_CITY;
        }else {
            int provinceCode = selectedProvince.getProvinceCode();
            String address = "http://guolin.tech/api/china/"+provinceCode;
            querFormServer(address,"city");
        }
    }

    private void queryCounties() {
        titleText.setText(selectedCity.getCityName());
        backButton.setVisibility(View.VISIBLE);
        countyList = DataSupport.where("cityid = ?",String.valueOf(selectedCity.getId())).find
                (County.class);
        if(countyList.size()>0){
            datalist.clear();
            for(County county:countyList){
                datalist.add(county.getCountyName());
            }
            adpater.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_COUNTY;
        }else{

            int provinceCode = selectedProvince.getProvinceCode();
            int cityCode = selectedCity.getCityCode();
            String address = "http://guolin.tech/api/china/"+provinceCode+"/"+cityCode;
            querFormServer(address,"county");
        }
    }

    /**
     * 根据传入的地址 和类型去服务器拿数据
     * @param address
     * @param type
     */
    private void querFormServer(String address, final String type) {
        //显示进度
       showProgressDialog();
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //通过run方法返回主线程处理逻辑
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(getContext(),"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                boolean result = false;
                if("province".equals(type)){
                    result = Utility.handleProvinceResponse(responseText);

                }else if("city".equals(type)){
                    result = Utility.handleCityResponse(responseText,selectedProvince.getId());
                }else if("county".equals(type)){
                    result = Utility.handleCountyResponse(responseText,selectedCity.getId());
                }

                if(result){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            if("province".equals(type)){
                                queryProvinces();
                            }else if("city".equals(type)){
                               queryCities();
                            }else if("county".equals(type)){
                               queryCounties();
                            }
                        }
                    });
                }

            }
        });


    }

    private void showProgressDialog() {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在拼命加载中.....");
            //返回不起作用
            progressDialog.setCanceledOnTouchOutside(true);
        }
        progressDialog.show();
    }


    private void closeProgressDialog() {
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }

}
