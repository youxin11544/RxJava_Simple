package com.asdf.myapplication3.base;


import rx.subscriptions.CompositeSubscription;

/**
 * Created by anzhuo002 on 2016/7/5.
 */

public interface BasePresenter {
  void unSubscribe();
  CompositeSubscription getCompositeSubscription();
}