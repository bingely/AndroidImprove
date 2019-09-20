package com.bingley.dbapplicaion.dbflow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author bingley
 * @date 2019/9/20.
 */
@Database(version = AppDataBase.VERSION)
public class AppDataBase {
    public static final String NAME="AppDataBase";
    public static final int VERSION = 1;
}
