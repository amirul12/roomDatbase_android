package com.ulsbd.roomdatabasetodo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Md. Amirul Islam on 29-May-19.
 * Email : amirul.islam@uslbd.com
 * Unisoft™ Systems Limited
 */

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task")
    private String task;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "finished_by")
    private String finishBy;

    @ColumnInfo(name = "finished")
    private boolean finished;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFinishBy() {
        return finishBy;
    }

    public void setFinishBy(String finishBy) {
        this.finishBy = finishBy;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
