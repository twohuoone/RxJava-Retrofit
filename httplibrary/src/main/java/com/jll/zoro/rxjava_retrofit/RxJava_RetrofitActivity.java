package com.jll.zoro.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jll.zoro.rxjava_retrofit.info.MovieEntity;
import com.jll.zoro.rxjava_retrofit.info.Subject;
import com.jll.zoro.rxjava_retrofit.interfaceInfo.MovieService;
import com.jll.zoro.rxjava_retrofit.interfaceInfo.SubscriberOnNextListener;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

public class RxJava_RetrofitActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout activityRxJavaRetrofit;
    private TextView showData;
    private LoadDialog loadDialog;
    private HttpMethods httpMethods;
    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java__retrofit);

        loadDialog = new LoadDialog(this);
        activityRxJavaRetrofit = (LinearLayout) findViewById(R.id.activity_rx_java__retrofit);
        findViewById(R.id.getData).setOnClickListener(this);
        showData = (TextView) findViewById(R.id.showData);
        httpMethods = new HttpMethods();
        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subjects) {
                showData.setText(subjects.get(9).getTitle());
            }
        };
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.getData) {//TODO implement
            getData_2();

        }
    }
    //封装单独处理onNext()
    private void getData_2() {
        httpMethods.getTopMovie(new ProgressSubscriber(getTopMovieOnNext,this),0,10);
    }

    //将请求进行封装
    private void getData_1() {
        Subscriber<List<Subject>> sub = new Subscriber<List<Subject>>() {
            @Override
            public void onStart() {
                super.onStart();
                loadDialog.start();
            }

            @Override
            public void onCompleted() {
                loadDialog.stop();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Subject> movieEntity) {
                showData.setText(movieEntity.get(4).getTitle()+"----Fire");
            }
        };
//        HttpMethods.getInstance().getTopMovie(sub,0,10);
//        httpMethods.getTopMovie(sub,0,10);

    }

    //没有任何封装
    public void getData() {
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieService service = retrofit.create(MovieService.class);
        Subscriber<MovieEntity> sub = new Subscriber<MovieEntity>() {
            @Override
            public void onStart() {
                super.onStart();
                loadDialog.start();
            }

            @Override
            public void onCompleted() {
                loadDialog.stop();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                showData.setText(movieEntity.getTitle());
            }
        };
//        service.getTopMovie(0,10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(sub);
    }
}
