package com.github.clucle.todo_app.presenter;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class TodoPresenter {
  /* Presenter */
  private View view;

  /* Data */
  private ArrayList<String> mTodoList;

  /* Observer, Observable */
  private PublishSubject<String> addItemSubject = PublishSubject.create();
  private CompositeDisposable mDisposable = new CompositeDisposable();

  public interface View {
    void notifyAddTodoItem(int sz);
  }

  public TodoPresenter(View view) {
    this.view = view;
    mDisposable.add(
        addItemSubject.subscribe(todo -> {
              mTodoList.add(todo);
              this.view.notifyAddTodoItem(mTodoList.size() - 1);
            }
        )
    );
    loadTodoItem();
  }

  private void loadTodoItem() {
    mTodoList = new ArrayList<>();
  }

  public ArrayList<String> getTodoList() {
    return mTodoList;
  }

  public void addTodoItem(String todoItem) {
    addItemSubject.onNext(todoItem);
  }

  public CompositeDisposable getDisposable() {
    return mDisposable;
  }
}
