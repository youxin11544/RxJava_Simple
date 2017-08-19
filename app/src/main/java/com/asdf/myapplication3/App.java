package com.asdf.myapplication3;

import android.app.Application;

import haibao.com.api.Http;
import haibao.com.utilscollection.UtilsCollection;

/**
 * Created by wanjian on 2017/2/14.
 *
 * Example
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilsCollection.core = this;
        Http.initialize(this,"1.0.0");
//        Cockroach.install(new Cockroach.ExceptionHandler() {
//           // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ }
//           // ，以防handlerException内部再次抛出异常，导致循环调用handlerException
//            @Override
//            public void handlerException(final Thread thread, final Throwable throwable) {
//                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Log.d("Cockroach", thread + "\n" + throwable.toString());
//                            throwable.printStackTrace();
//                            Toast.makeText(App.this, "Exception Happend\n" + thread + "\n" + throwable.toString(), Toast.LENGTH_SHORT).show();
////                        throw new RuntimeException("..."+(i++));
//                        } catch (Throwable e) {
//
//                        }
//                    }
//                });
//            }
//        });
//
//        // 卸载代码
//        Cockroach.uninstall();
    }
}
