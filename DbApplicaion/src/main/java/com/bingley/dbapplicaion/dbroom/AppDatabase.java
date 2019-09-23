package com.bingley.dbapplicaion.dbroom;

import android.arch.persistence.room.RoomDatabase;

/**
 * @author bingley
 * @date 2019/9/20.
 */
//@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
