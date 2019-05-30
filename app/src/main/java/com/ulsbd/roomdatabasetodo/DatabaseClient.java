package com.ulsbd.roomdatabasetodo;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Md. Amirul Islam on 29-May-19.
 * Email : amirul.islam@uslbd.com
 * Unisoft™ Systems Limited
 */
public class DatabaseClient {

    private Context mContext;
    private static DatabaseClient mInstance;


    /*App database object*/

    AppDatabase appDatabase;

    public DatabaseClient(Context mContext) {
        this.mContext = mContext;
        appDatabase = Room.databaseBuilder(mContext,AppDatabase.class,"myToDo").build();
    }


    public static synchronized DatabaseClient getInstance(Context mContext){

        if (mInstance == null){
           mInstance = new DatabaseClient(mContext);
        }
        return mInstance;
    }


    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
