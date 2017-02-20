package com.jll.zoro.rxjava_retrofit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jll.zoro.rxjava_retrofit.info.MovieEntity;
import com.jll.zoro.rxjava_retrofit.interfaceInfo.MovieService_Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView showData;
    private LoadDialog loadDialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loadDialog.stop();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        loadDialog = new LoadDialog(this);
        findViewById(R.id.getData).setOnClickListener(this);
        showData = (TextView) findViewById(R.id.showData);
    }
    //进行网络请求
    private void getMovie() {
        String baseUrl = "https://api.douban.com/v2/movie/";
        loadDialog.start();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieService_Retrofit movieService = retrofit.create(MovieService_Retrofit.class);
//        未将retrofit和Observable
        Call<MovieEntity> call = movieService.getTopMovie(0, 10);
        call.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                showData.setText(response.body().getSubjects().get(4).getTitle()+"---heihei");
                handler.sendEmptyMessageDelayed(1,2000);
            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                showData.setText(t.getMessage()+"---haha");
            }
        });
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.getData) {//TODO implement
            getMovie();

        }
    }
}

