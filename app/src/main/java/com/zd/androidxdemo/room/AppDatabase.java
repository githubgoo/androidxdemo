package com.zd.androidxdemo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @ClassName: AppDatabase
 * @Description:
 * @Author: zhangdi
 * @Date: 20-12-25 上午10:34
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
