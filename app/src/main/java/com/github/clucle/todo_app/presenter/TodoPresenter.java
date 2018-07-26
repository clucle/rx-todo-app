package com.github.clucle.todo_app.presenter;

import java.util.ArrayList;

public class TodoPresenter {
  /* Presenter */
  private View view;

  /* Data */
  private ArrayList<String> mTodoList;

  public interface View {
    void notifyAddTodoItem(int sz);
  }

  public TodoPresenter(View view) {
    this.view = view;
    loadTodoItem();
  }

  private void loadTodoItem() {
    mTodoList = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      mTodoList.add("hi : " + i);
    }
  }

  public ArrayList<String> getTodoList() {
    return mTodoList;
  }

  public void addTodoItem(String todoItem) {
    mTodoList.add(todoItem);
    view.notifyAddTodoItem(mTodoList.size() - 1);
  }
}
