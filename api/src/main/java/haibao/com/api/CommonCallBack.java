package haibao.com.api;


/**
 * 发送请求后的回调接口
 */
interface CommonCallBack<T> {
    /**
     * 请求完成之后的回调
     */
    void onCallCompleted();

    /**
     * 请求 错误 的回调
     * @param e 错误回调的异常实体
     */
    void onCallError(Exception e);

    /**
     * 请求 成功后下一步 的回调
     * @param t 泛型 具体的请求实体对象
     */
    void onCallNext(T t);
}
