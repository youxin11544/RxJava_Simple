package com.asdf.myapplication3.base;

/**
 * DESCRIPTION: 缓存管理类，存储和清除缓存数据。
 *
 *              注意：暂时不带有对缓存时间的判断。
 * Author: Cry
 * DATE: 16/12/25 上午10:58
 */

public interface CacheManageFactory<T> {    //这里先把泛型写了。

    /**
     * 存放缓存的数据
     * @param key key
     * @param t t
     */
    void putCache(String key, T t);

    /**
     * 清除所有缓存
     */
    void clearAll();
}
