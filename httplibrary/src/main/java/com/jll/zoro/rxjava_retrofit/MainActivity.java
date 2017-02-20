package com.jll.zoro.rxjava_retrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements View.OnClickListener {

    private LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        findViewById(R.id.activity_rx_java).setOnClickListener(this);
        findViewById(R.id.activity_retrofit).setOnClickListener(this);
        findViewById(R.id.activity_rx_java_retrofit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.activity_rx_java) {//TODO implement
            Intent intent = new Intent(MainActivity.this, RxJavaActivity.class);
            this.startActivity(intent);

        } else if (i == R.id.activity_retrofit) {//TODO implement
            Intent intent_1 = new Intent(MainActivity.this, RetrofitActivity.class);
            this.startActivity(intent_1);

        } else if (i == R.id.activity_rx_java_retrofit) {//TODO implement
            Intent intent_2 = new Intent(MainActivity.this, RxJava_RetrofitActivity.class);
            this.startActivity(intent_2);

        }
    }
}

