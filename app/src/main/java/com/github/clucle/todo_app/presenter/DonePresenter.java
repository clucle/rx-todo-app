package com.github.clucle.todo_app.presenter;

public class DonePresenter {
  private View view;

  public interface View {
  }

  public DonePresenter(View view) {
    this.view = view;
  }
}
