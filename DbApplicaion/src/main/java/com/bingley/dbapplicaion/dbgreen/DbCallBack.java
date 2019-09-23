package com.bingley.dbapplicaion.dbgreen;

import java.util.List;

/**
 * db 操作回调
 * @author bingley
 * @date 2019/7/30.
 */
public interface DbCallBack<T> {

    void onSuccess(List<T> result);
    void onFailed();
    void onNotification(boolean result);
}
