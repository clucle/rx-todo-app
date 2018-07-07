package com.github.clucle.todo_app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clucle.todo_app.R;
import com.github.clucle.todo_app.presenter.TodoPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TodoFragment extends Fragment implements TodoPresenter.View {

  private Unbinder unbinder;
  private TodoPresenter todoPresenter;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_todo, container, false);

    todoPresenter = new TodoPresenter(this);
    unbinder = ButterKnife.bind(this, view);

    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
