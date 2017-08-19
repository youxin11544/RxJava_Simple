package me.shaohui.advancedluban.haibao.Image;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.shaohui.advancedluban.Luban;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * 压缩照片,采用luban
 * Author: crazycodeboy
 * Date: 2016/11/5 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.devio.org/
 * GitHub:https://github.com/crazycodeboy
 * Eamil:crazycodeboy@gmail.com
 */
public class CompressWithLuBan  {
    private CompressListener listener;
    private long start;

    public void compressMulti(Context context,ArrayList<String> originalList,CompressListener mCompressListener) {
        this.listener = mCompressListener;
        List<File> files = new ArrayList<>();
        try {
            for(int i=0;i<originalList.size();i++) {
                File file = new File(originalList.get(i));
                files.add(file);
            }
            if (files.size() == 0) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Luban.compress(context, files)
                .setMaxSize(300)
                .putGear(Luban.CUSTOM_GEAR)
                .asListObservable()
                .doOnRequest(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        start = System.currentTimeMillis();
                    }
                })
                .subscribe(new Action1<List<File>>() {
                    @Override
                    public void call(List<File> files) {
                        handleCompressCallBack(files);
//                        Log.e("TAG:result", Formatter.formatFileSize(context, files.get(0).length()));
//                        Log.e("TAG:result","运行时间:" + (System.currentTimeMillis() - start) / 1000f + "s");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        listener.onCompressFailed(throwable.getMessage() +"----"+throwable.toString()+ " this is cmpress failures");
                    }
                });
    }

    public void compressMulti2(Context context,ArrayList<String> originalList,CompressListener mCompressListener) {
        this.listener = mCompressListener;
        List<File> files = new ArrayList<>();
        try {
            for(int i=0;i<originalList.size();i++) {
                File file = new File(originalList.get(i));
                files.add(file);
            }
            if (files.size() == 0) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Luban.compress(context, files)
                .setMaxSize(300)
                .putGear(Luban.CUSTOM_GEAR)
                .asListObservable()
                .doOnRequest(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        start = System.currentTimeMillis();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<File>>() {
                    @Override
                    public void call(List<File> files) {
                        handleCompressCallBack(files);
//                        Log.e("TAG:result", Formatter.formatFileSize(context, files.get(0).length()));
//                        Log.e("TAG:result","运行时间:" + (System.currentTimeMillis() - start) / 1000f + "s");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        listener.onCompressFailed(throwable.getMessage() +"----"+throwable.toString()+ " this is cmpress failures");
                    }
                });
    }

    private void handleCompressCallBack(List<File> files) {
        ArrayList<String> pahtList = new ArrayList<>();
        for (int i = 0;i < files.size(); i++) {
            pahtList.add(files.get(i).getPath());
        }
        listener.onCompressSuccess(pahtList,files);
    }
}
