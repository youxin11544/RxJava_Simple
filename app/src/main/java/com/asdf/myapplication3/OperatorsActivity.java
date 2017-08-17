package com.asdf.myapplication3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

public class OperatorsActivity extends AppCompatActivity {
    private String TAG = "OperatorsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);

    }

    public void just(View view) {
        //使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据：
        ////依次发送"just1"和"just2"
        Observable.just("1", "2").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, s);
                Toast.makeText(OperatorsActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void from(View view) {
        //from 操作符可转换futrue Iterable 和数组
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Observable.from(list).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, s);
                Toast.makeText(OperatorsActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void defer(View view) {
        Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("hello");
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("JG", s);
            }
        });
    }

    private void rang(View view) {
        //Action0：RxJava中的一个接口
        Observable.range(2, 5).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("JG", integer.toString());// 2,3,4,5,6 从2开始发射5个数据
            }
        });

        Observable.range(2, 5)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }
                });


    }

    private void map(View view) {
        //对Observable发射的每一项数据都应用一个函数来变换。
        Observable.just("2")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s);
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer s) {

                    }
                });
    }

    public void case1(View view) {
        Observable.just("1")
                .cast(String.class)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

    public void flatMap(View view) {
        // 将Observable发射的数据变换为Observables集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable，内部采用merge合并。
        Observable.just("1")
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return null;
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

    public void retry(View v) {
        Observable.just(1,"2",3)
                .cast(Integer.class)
                .retry(3)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.toString());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,integer+"");
                    }
                });
    }


    public void filter(View view) {
        Observable.just(1,3,15)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer s) {
                        return s>2;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer s) {
                        Log.e(TAG,s+"");
                    }
                });
    }

}