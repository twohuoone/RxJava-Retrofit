package com.jll.zoro.rxjava_retrofit;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jll.zoro.rxjava_retrofit.info.Student;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String tag = "RxJavaActivity";
    private String ss = "";
    private static LoadDialog load_Dialog;
    private Student student = new Student();
    private List<Student> list_S = new ArrayList<>();
    private static final int DRAWABLE_RES = R.mipmap.ic_launcher;

    private Button button;
    private TextView text;
    private ImageView image;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            load_Dialog.stop();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        text = (TextView) findViewById(R.id.show);
        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.showData);
        button.setOnClickListener(this);
        load_Dialog = new LoadDialog(this);

        initStudent();
    }
    @Override
    public void onClick(View view) {
        setDrawable();
    }
    //输出信息
    private void outInfo() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                handler.sendEmptyMessageDelayed(1,2000);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(tag,"info==="+s);
            }
        };
        Observable.just(12)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer+"haha";
                    }
                }).subscribe(subscriber);
        Observable.just(16)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer integer) {
                        return Observable.just(integer+"hahahahah");
                    }
                }).subscribe(subscriber);
    }
    //输出Student数据
    private void outStudentInfo() {
        Subscriber<Student> subscriber = new Subscriber<Student>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student student) {
                Log.i(tag,"Student_C===="+student.getName());
            }
        };
        Observable.from(list_S)
                .subscribe(subscriber);
//        Observable.from(list_S)
//                .flatMap(new Func1<Student, Observable<Student.Course>>() {
//                    @Override
//                    public Observable<Student.Course> call(Student student) {
//                        return Observable.from(student.getList());
//                    }
//                }).subscribe(subscriber);
    }
    //初始化Student数据
    private void initStudent() {
        List<Student.Course> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student.Course course = new Student().new Course();
            course.setName("HAHA="+i);
            list.add(course);
        }
        student.setName("JLL");
        student.setAge("24");
        student.setList(list);
        list_S.add(student);
        list_S.add(student);
        list_S.add(student);
    }

    //由 id 取得图片并显示
    private void setDrawable() {
        Subscriber<Drawable> sub = new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {
                handler.sendEmptyMessageDelayed(1,2000);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                image.setImageDrawable(drawable);
//                text.setText(drawable);
                Log.i(tag, "Out===" + drawable);
            }

            @Override
            public void onStart() {
                super.onStart();
                load_Dialog.start();
            }
        };
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                subscriber.onNext(ContextCompat.getDrawable(RxJavaActivity.this, DRAWABLE_RES));
                subscriber.onNext(ContextCompat.getDrawable(RxJavaActivity.this, DRAWABLE_RES));
                subscriber.onCompleted();
            }
        })
//                .map(new Func1<Drawable, String>() {
//            @Override
//            public String call(Drawable drawable) {
//                return "hahahaha";
//            }
//        })
                .subscribe(sub);
//        observable.subscribe(sub);
    }

    //打印字符串数组
    private void outArray() {
        String[] array = new String[]{"1", "2", "3", "4", "5"};
        Observable.from(array).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(tag, "Out===" + s);
                ss += s + "--";
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {
                text.setText(ss);
            }
        });
    }

    //类似for语句的输出
    private void rxJava() {
        Observable observable2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello1");
                subscriber.onNext("Hi1");
                subscriber.onNext("Aloha1");
                subscriber.onCompleted();
            }
        });
        Observable observable = Observable.just("Hello", "Hi", "Aloha");
        String[] words = {"Hello3", "Hi3", "Aloha3"};
        Observable observable3 = Observable.from(words);
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(tag, "Out===" + s);
            }
        };
        observable.subscribe(subscriber);
        observable2.subscribe(subscriber);
        observable3.subscribe(subscriber);
        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                Log.d(tag, "Out1===" + s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                Log.d(tag, "completed");
            }
        };
        observable.subscribe(onNextAction);
    }

}

