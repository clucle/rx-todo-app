package com.github.clucle.todo_app.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.clucle.todo_app.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

  private ArrayList<String> mDataSet;

  public TodoListAdapter(ArrayList<String> dataSet) {
    mDataSet = dataSet;
  }

  @NonNull
  @Override
  public TodoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull TodoListAdapter.ViewHolder holder, int position) {
    holder.title.setText(mDataSet.get(position));
  }

  @Override
  public int getItemCount() {
    return mDataSet.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_view_title)
    TextView title;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
