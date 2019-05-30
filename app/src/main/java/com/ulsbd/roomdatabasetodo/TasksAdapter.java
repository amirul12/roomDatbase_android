package com.ulsbd.roomdatabasetodo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Md. Amirul Islam on 29-May-19.
 * Email : amirul.islam@uslbd.com
 * Unisoft™ Systems Limited
 */
public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private Context mCtx;
    private List<Task> taskList;

    public TasksAdapter(Context mCtx, List<Task> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_task_row,viewGroup,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task t = taskList.get(position);
        holder.textViewTask.setText(t.getTask());
        holder.textViewDesc.setText(t.getDesc());
        holder.textViewFinishBy.setText(t.getFinishBy());

        if (t.isFinished()){
            holder.textViewStatus.setText("Completed");
        }else {
            holder.textViewStatus.setText("Not Completed");
        }




    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewStatus = itemView.findViewById(R.id.tvStatus);
            textViewTask = itemView.findViewById(R.id.tvTask);
            textViewDesc = itemView.findViewById(R.id.tvDesc);
            textViewFinishBy = itemView.findViewById(R.id.tvFinishBy);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Task task = taskList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
            intent.putExtra("task",task);
            mCtx.startActivity(intent);

        }
    }
}
