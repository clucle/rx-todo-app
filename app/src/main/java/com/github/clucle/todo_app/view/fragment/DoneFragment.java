package com.github.clucle.todo_app.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clucle.todo_app.R;
import com.github.clucle.todo_app.presenter.DonePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DoneFragment extends Fragment implements DonePresenter.View {

  private Unbinder unbinder;
  private DonePresenter donwPresenter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_done, container, false);

    donwPresenter = new DonePresenter(this);
    unbinder = ButterKnife.bind(this, view);

    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
