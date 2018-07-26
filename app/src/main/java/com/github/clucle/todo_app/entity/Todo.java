package com.github.clucle.todo_app.entity;

import java.text.SimpleDateFormat;

public class Todo {
  private String title;
  private String registerDate;

  public Todo(String _title, String _registerDate) {
    this.title = _title;
    this.registerDate = _registerDate;
  }

  public String getTitle() {
    return title;
  }

  public String getRegisterDate() {
    return registerDate;
  }
}
