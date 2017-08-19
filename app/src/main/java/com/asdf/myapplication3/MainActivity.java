package com.asdf.myapplication3;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.asdf.myapplication3.base.BaseActivity;
import com.asdf.myapplication3.base.BasePresenter;
import com.asdf.myapplication3.base.SimpleCommonCallBack;
import com.asdf.myapplication3.base.TempBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import haibao.com.api.data.param.bookshelf.CreateEditPlayListParam;
import haibao.com.api.data.param.bookshelf.PlayListOrderParam;
import haibao.com.api.data.response.bookShelfResponse.PlayListBean;
import haibao.com.api.data.response.bookShelfResponse.PlayListCoverResponse;
import haibao.com.api.data.response.content.ContentCommentsResponse;
import haibao.com.api.data.response.content.GetContentsContentIdLikeUsersResponse;
import haibao.com.api.data.response.global.Content;
import haibao.com.api.data.response.global.Resource;
import haibao.com.api.helper.MultipartBuilder;
import haibao.com.api.service.BookshelfApiWrapper;
import haibao.com.api.service.ContentApiApiWrapper;
import haibao.com.utilscollection.io.AssetsUtils;
import haibao.com.utilscollection.manager.ToastUtils;
import me.shaohui.advancedluban.Luban;
import okhttp3.MultipartBody;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subscriptions.CompositeSubscription;


public class MainActivity extends BaseActivity {
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public int onSetLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public BasePresenter onSetPresent() {
        return null;
    }

    @Override
    protected void onDestroy() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
        super.onDestroy();
    }

    @Override
    public void initData() {
        mCompositeSubscription = new CompositeSubscription();
        findViewById(R.id.youixn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button a = null;
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
    }


    public void create(View v) {
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("helleo_work");
//                subscriber.onCompleted();
//            }
//        });
        //可以看到，这里传入了一个 OnSubscribe 对象作为参数。OnSubscribe 会被存储在返回的 Observable 对象中，它的作用相当于一个计划表，
        // 当 Observable 被订阅的时候，OnSubscribe 的 call() 方法会自动被调用，事件序列就会依照设定依次触发（对于上面的代码，就是观察者
        // Subscriber将会被调用一次 onNext() 和一次 onCompleted()）。这样，由被观察者调用了观察者的回调方法，就实现了由被观察者向观察者的事件传递，即观察者模式。
    }

    public void createSubscriber(View v) {
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("helleo_work");
//                subscriber.onCompleted();
//            }
//        });
//
//        Subscriber<String> mySubscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
//            }
//        };
//        //当调用Observable.subscribe()，会返回一个Subscription对象。这个对象代表了被观察者和订阅者之间的联系。
//        Subscription mSubscription = observable.subscribe(mySubscriber);
    }

    public void SubscriptionSubscriber(View view) {
//        Subscription subscription = Observable.just("youxin").subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
//            }
//        });
//
//        subscription.unsubscribe();

        //RxJava的另外一个好处就是它处理unsubscribing的时候，会停止整个调用链。如果你使用了一串很复杂的操作符，
        // 调用unsubscribe将会在他当前执行的地方终止。不需要做任何额外的工作！

    }

    public void toOperators(View view) {
        startActivity(new Intent(this, OperatorsActivity.class));
    }

    public void zip(View view) {
        Observable<Content> mObservable1 = ContentApiApiWrapper
                .getInstance()
                .GetContentsContentId("173090");
        Observable<GetContentsContentIdLikeUsersResponse> mObservable2 = ContentApiApiWrapper
                .getInstance()
                .GetContentsContentIdLikeUsers("173090", 1, 10);
        Observable<ContentCommentsResponse> mObservable3 = ContentApiApiWrapper
                .getInstance()
                .GetContentsContentIdComments("173090", 01, 20);

        showLoadingDialog();
        Observable.zip(mObservable1, mObservable2, mObservable3, new Func3<Content, GetContentsContentIdLikeUsersResponse, ContentCommentsResponse, TempBean>() {
            @Override
            public TempBean call(Content content, GetContentsContentIdLikeUsersResponse getContentsContentIdLikeUsersResponse, ContentCommentsResponse contentCommentsResponse) {
                TempBean bean = new TempBean();
                bean.data1 = content;
                bean.data2 = getContentsContentIdLikeUsersResponse;
                bean.data3 = contentCommentsResponse;
                Log.e("youxin", Thread.currentThread().getName() + "----call");
                return bean;
            }
        }).subscribe(new SimpleCommonCallBack<TempBean>(mCompositeSubscription) {
            @Override
            public void onCallError(Exception e) {

            }

            @Override
            public void onCallNext(TempBean tempBean) {
                hideLoadingDialog();
                Log.e("youxin", Thread.currentThread().getName() + "----onNext");
                Content bean1 = (Content) tempBean.data1;
                GetContentsContentIdLikeUsersResponse bean2 = (GetContentsContentIdLikeUsersResponse) tempBean.data2;
                ContentCommentsResponse bean3 = (ContentCommentsResponse) tempBean.data3;
                Log.e("youxin1", bean1.toString());
                if (bean2 != null && bean2.items != null) {
                    Log.e("youxin2", bean2.items.toString());
                }
                if (bean3 != null && bean3.items != null) {
                    Log.e("youxin3", bean3.items.toString());
                }
            }
        });
//                .subscribe(new Subscriber<TempBean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                hideLoadingDialog();
//                Log.e("youxin", e.toString());
//            }
//
//            @Override
//            public void onNext(TempBean tempBean) {
//                hideLoadingDialog();
//                Log.e("youxin", Thread.currentThread().getName()+"----onNext");
//                Content bean1 = (Content) tempBean.data1;
//                GetContentsContentIdLikeUsersResponse bean2 = (GetContentsContentIdLikeUsersResponse) tempBean.data2;
//                ContentCommentsResponse bean3 = (ContentCommentsResponse) tempBean.data3;
//                Log.e("youxin1", bean1.toString());
//                if (bean2 != null && bean2.items != null) {
//                    Log.e("youxin2", bean2.items.toString());
//                }
//                if (bean3 != null && bean3.items != null) {
//                    Log.e("youxin3", bean3.items.toString());
//                }
//            }
//        });


    }

    public void fiatMap(View view) {
//        Observable<Content> mObservable1 = ContentApiApiWrapper
//                .getInstance()
//                .GetContentsContentId("173090");
//        Observable<GetContentsContentIdLikeUsersResponse> mObservable2 =ContentApiApiWrapper
//                .getInstance()
//                .GetContentsContentIdLikeUsers("173090", 1, 10);
//        Observable<ContentCommentsResponse> mObservable3 = ContentApiApiWrapper
//                .getInstance()
//                .GetContentsContentIdComments(  "173090", 01, 20);

        showLoadingDialog();
        Subscription mSubscription = ContentApiApiWrapper
                .getInstance()
                .GetContentsContentId("173090")
                .concatMap(new Func1<Content, Observable<GetContentsContentIdLikeUsersResponse>>() {
                    @Override
                    public Observable<GetContentsContentIdLikeUsersResponse> call(Content content) {
                        Log.e("youxin1", content.toString());
                        Observable<GetContentsContentIdLikeUsersResponse> mObservable2 = ContentApiApiWrapper
                                .getInstance()
                                .GetContentsContentIdLikeUsers("173090", 1, 10);
                        return mObservable2;
                    }
                }).concatMap(new Func1<GetContentsContentIdLikeUsersResponse, Observable<ContentCommentsResponse>>() {
                    @Override
                    public Observable<ContentCommentsResponse> call(GetContentsContentIdLikeUsersResponse bean2) {
                        if (bean2 != null && bean2.items != null) {
                            Log.e("youxin2", bean2.items.toString());
                        }
                        Observable<ContentCommentsResponse> mObservable3 = ContentApiApiWrapper
                                .getInstance()
                                .GetContentsContentIdComments("173090", 01, 20);
                        return mObservable3;
                    }
                }).subscribe(new SimpleCommonCallBack<ContentCommentsResponse>(mCompositeSubscription) {
                    @Override
                    public void onCallError(Exception e) {
                        hideLoadingDialog();
                    }

                    @Override
                    public void onCallNext(ContentCommentsResponse bean3) {
                        hideLoadingDialog();
                        if (bean3 != null && bean3.items != null) {
                            Log.e("youxin2", bean3.items.toString());
                        }
                    }
                });
        mCompositeSubscription.add(mSubscription);
    }

    public void edit(View view) {
        final String playlist_id = "409";
        final String name = "youxin";
        final String photoPath = "/storage/emulated/0/ayb/image/1503122365538.jpg";
        PlayListBean rt = AssetsUtils.getBean("playlistbean.json", PlayListBean.class);
        List<Resource> list = rt.resources;

        Observable<PlayListBean> editObservable = editPhotoAndName(name, photoPath, playlist_id);
        Observable<List<Resource>> orderObservable = setPlayListOrder(playlist_id, list);
        showLoadingDialog();
        Subscription mSubscription = Observable
                .zip(editObservable, orderObservable, new Func2<PlayListBean, List<Resource>, TempBean>() {
                    @Override
                    public TempBean call(PlayListBean playListBean, List<Resource> resources) {
                        TempBean bean = new TempBean();
                        bean.data1 = playListBean;
                        bean.data2 = resources;
                        return bean;
                    }
                })
                .subscribe(new SimpleCommonCallBack<TempBean>(mCompositeSubscription) {
                    @Override
                    public void onCallError(Exception e) {
                        hideLoadingDialog();
                        Log.e("youxin2", e.toString());
                    }
                    @Override
                    public void onCallNext(TempBean bean) {
                        hideLoadingDialog();
                        PlayListBean playListBean = (PlayListBean) bean.data1;
                        ArrayList<Resource> resources = (ArrayList<Resource>) bean.data2;
                        if (playListBean != null) {
                            Log.e("youxin2", playListBean.toString());
                        }
                        if (resources != null) {
                            Log.e("youxin3", resources.toString());
                        }
                    }

                    @Override
                    public void onCompleted() {
                        Log.e("youxin4", "onCompleted");
                    }
                });
        mCompositeSubscription.add(mSubscription);


    }


    public Observable<PlayListBean> editPhotoAndName(final String name, String photoPath, final String playlist_id) {
        return Observable.just(photoPath)
                .concatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String photoPath) {
                        //压缩图片 上传图片
                        return compressAndUpdateImage(photoPath);
                    }
                })
                .concatMap(new Func1<String, Observable<PlayListBean>>() {
                    @Override
                    public Observable<PlayListBean> call(String cover) {
                        //编辑 信息
                        return eidtInfo(name, cover, playlist_id);
                    }
                });
    }

    //压缩并上传图片
    public Observable<String> compressAndUpdateImage(String photoPath) {
        if (TextUtils.isEmpty(photoPath)) {
            return Observable.just("");
        }
        File file = new File(photoPath);
        if (!file.exists()) {
            ToastUtils.showShort("文件为空");
            hideLoadingDialog();
            return Observable.empty();
        }
        Observable<String> fileObservable = Luban.compress(MainActivity.this, file)
                .setMaxSize(500)
                .putGear(Luban.CUSTOM_GEAR)
                .asObservable()
                .concatMap(new Func1<File, Observable<PlayListCoverResponse>>() {
                    @Override
                    public Observable<PlayListCoverResponse> call(File file) {
                        List<File> mFileList = new ArrayList<>();
                        mFileList.add(file);
                        MultipartBody body = MultipartBuilder.getInstance().filesToMultipartBody(mFileList);
                        return BookshelfApiWrapper.getInstance().updataPlaylistCover(body);
                    }
                })
                .map(new Func1<PlayListCoverResponse, String>() {
                    @Override
                    public String call(PlayListCoverResponse playListCoverResponse) {
                        return playListCoverResponse.cover;
                    }
                });
        return fileObservable;
    }

    public Observable<PlayListBean> eidtInfo(String name, String cover, String playlist_id) {
        CreateEditPlayListParam param = new CreateEditPlayListParam();
        boolean flag1 = true;
        boolean flag2 = true;
        if (!TextUtils.isEmpty(name)) {
            param.playlist_name = name;
            flag1 = false;
        }
        if (cover != null && !TextUtils.isEmpty(cover)) {
            param.playlist_cover = cover;
            flag2 = false;
        }
        if (flag1 && flag2) {
            return Observable.empty();
        }
        return BookshelfApiWrapper.getInstance().editPlayList(playlist_id, param);
    }

    private Observable<List<Resource>> setPlayListOrder(String playlist_id, List<Resource> list) {
        if (list == null || list.size() == 0) {
            return Observable.empty();
        }
        ArrayList<PlayListOrderParam> paramList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Resource mResource = list.get(i);
            PlayListOrderParam param = new PlayListOrderParam();
            param.resource_id = mResource.getResource_id();
            param.order_num = i;
            paramList.add(param);
        }
        return BookshelfApiWrapper
                .getInstance()
                .setPlayListOrder(playlist_id, paramList);
    }


}
