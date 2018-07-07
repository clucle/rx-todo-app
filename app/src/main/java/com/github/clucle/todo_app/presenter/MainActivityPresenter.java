package com.github.clucle.todo_app.presenter;

public class MainActivityPresenter {
  private View view;

  public interface View {
  }

  public MainActivityPresenter(View view) {
    this.view = view;
  }
}
