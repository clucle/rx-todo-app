package com.github.clucle.todo_app.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clucle.todo_app.R;
import com.github.clucle.todo_app.presenter.TodoPresenter;
import com.github.clucle.todo_app.view.adapter.TodoListAdapter;
import com.github.clucle.todo_app.view.utils.VerticalSpaceItemDecoration;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class TodoFragment extends Fragment implements TodoPresenter.View {

  @BindView(R.id.recycler_view_todo)
  RecyclerView recyclerViewTodo;
  @BindView(R.id.fab_todo_add)
  FloatingActionButton fabTodoAdd;

  private RecyclerView.Adapter mAdapter;
  private Unbinder unbinder;
  private TodoPresenter todoPresenter;

  private CompositeDisposable mDisposable = new CompositeDisposable();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    todoPresenter = new TodoPresenter(this);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_todo, container, false);

    unbinder = ButterKnife.bind(this, view);

    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
    mAdapter = new TodoListAdapter(todoPresenter.getTodoList());
    recyclerViewTodo.setHasFixedSize(false);

    recyclerViewTodo.setLayoutManager(mLayoutManager);
    recyclerViewTodo.setAdapter(mAdapter);

    final int itemVerticalSpace = 24;
    final RecyclerView.ItemDecoration itemDecoration = new VerticalSpaceItemDecoration(itemVerticalSpace);
    recyclerViewTodo.addItemDecoration(itemDecoration);

    mDisposable.add(
        RxView.clicks(fabTodoAdd).subscribe(aVoid -> {
          // It may be show modal and get String
          todoPresenter.addTodoItem("lol");
        })
    );
    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
    mDisposable.dispose();
  }

  @Override
  public void notifyAddTodoItem(int sz) {
    mAdapter.notifyItemInserted(sz);
    mAdapter.notifyDataSetChanged();
  }
}
