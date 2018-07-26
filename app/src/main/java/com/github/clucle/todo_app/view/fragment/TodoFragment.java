package com.github.clucle.todo_app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.clucle.todo_app.R;
import com.github.clucle.todo_app.presenter.TodoPresenter;
import com.github.clucle.todo_app.view.adapter.TodoListAdapter;
import com.github.clucle.todo_app.view.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TodoFragment extends Fragment implements TodoPresenter.View {

  @BindView(R.id.recycler_view_todo)
  RecyclerView recyclerViewTodo;
  @BindView(R.id.btn_add_todo)
  Button btnAddTodo;

  private RecyclerView.LayoutManager mLayoutManager;
  private RecyclerView.Adapter mAdapter;
  private ArrayList<String> mDataset;

  private Unbinder unbinder;
  private TodoPresenter todoPresenter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    todoPresenter = new TodoPresenter(this);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_todo, container, false);

    unbinder = ButterKnife.bind(this, view);

    mDataset = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      mDataset.add("hi : " + i);
    }
    mLayoutManager = new LinearLayoutManager(getContext());
    mAdapter = new TodoListAdapter(mDataset);
    recyclerViewTodo.setHasFixedSize(false);

    recyclerViewTodo.setLayoutManager(mLayoutManager);
    recyclerViewTodo.setAdapter(mAdapter);

    final int itemVerticalSpace = 24;
    final RecyclerView.ItemDecoration itemDecoration = new VerticalSpaceItemDecoration(itemVerticalSpace);
    recyclerViewTodo.addItemDecoration(itemDecoration);

    btnAddTodo.setOnClickListener(addTodoListener);

    return view;
  }

  View.OnClickListener addTodoListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      mDataset.add("lol");
      mAdapter.notifyItemInserted(mDataset.size() - 1);
      mAdapter.notifyDataSetChanged();
    }
  };

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
