package com.github.clucle.todo_app.entity;

import java.text.SimpleDateFormat;

public class Done extends Todo {
  private String doneDate;

  public Done(String _title, String _registerDate, String _doneDate) {
    super(_title, _registerDate);
    this.doneDate = _doneDate;
  }

  public String getDoneDate() {
    return doneDate;
  }
}
