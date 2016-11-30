package com.fengchao.retrofitdemo.cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.fengchao.retrofitdemo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CookActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private ListView listView;

    //http://apis.juhe.cn/cook/index?key=761ebc844c1c84e0facf47324313fff8&cid=1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        listView = ((ListView) findViewById(R.id.lv));

        retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIinter apIinter = retrofit.create(APIinter.class);
        Call<Cook> cookCall = apIinter.getCook("/cook/index", "761ebc844c1c84e0facf47324313fff8", 1);
        cookCall.enqueue(new Callback<Cook>() {
            @Override
            public void onResponse(Call<Cook> call, Response<Cook> response) {
                Result result = response.body().getResult();
                List<CookBean> cookBeanList = result.getCookBeanList();
                listView.setAdapter(new MyAdapter(cookBeanList,CookActivity.this));
            }

            @Override
            public void onFailure(Call<Cook> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
