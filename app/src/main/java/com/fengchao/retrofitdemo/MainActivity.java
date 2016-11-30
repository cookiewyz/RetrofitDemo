package com.fengchao.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<String> {

    private TextView textView;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = ((TextView) findViewById(R.id.main_txt));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL_LIWU)
                .addConverterFactory(new Converter.Factory() {
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                })
                .build();

        APIService apiService = retrofit.create(APIService.class);

       /* Call<String> apiServiceBaidu = apiService.getBaidu();

        apiServiceBaidu.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                textView.setText(response.body()) ;
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });*/


        //  get请求带参数
        Call<String> message = apiService.getMessage(1, 1, 1, 10, 1);

        //get请求路径切换 带参数
        Call<String> path = apiService.getPath("101", 1, 1, 1, 10, 1);
        Call<String> path1 = apiService.getPath("5", 2, 1, 2, 10, 0);

        Call<String> data = apiService.getData();
        path1.enqueue(this);
        //post请求
        /*Call<CookBean> beanCall = apiService.getCookBean(1, 10, 1);
        beanCall.enqueue(new Callback<CookBean>() {
            @Override
            public void onResponse(Call<CookBean> call, Response<CookBean> response) {

            }

            @Override
            public void onFailure(Call<CookBean> call, Throwable t) {

            }
        });*/


        new  Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        textView.setText(response.body());
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        t.printStackTrace();
    }
}
