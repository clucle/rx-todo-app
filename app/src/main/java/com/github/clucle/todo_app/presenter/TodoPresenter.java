package com.github.clucle.todo_app.presenter;

public class TodoPresenter {
  private View view;

  public interface View {
  }

  public TodoPresenter(View view) {
    this.view = view;
  }
}
