package com.ulsbd.roomdatabasetodo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Md. Amirul Islam on 29-May-19.
 * Email : amirul.islam@uslbd.com
 * Unisoft™ Systems Limited
 */

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();
}
