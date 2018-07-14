package com.github.clucle.todo_app.view.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.clucle.todo_app.R;
import com.github.clucle.todo_app.view.fragment.DoneFragment;
import com.github.clucle.todo_app.view.fragment.TodoFragment;
import com.github.clucle.todo_app.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

  private MainActivityPresenter mainActivityPreseneter;
  private final String TAG = "[TODO_APP]";

  @BindView(R.id.constraint_layout_main)
  ConstraintLayout constraintLayoutMain;
  @BindView(R.id.top_nav_btn_todo)
  Button btnTodo;
  @BindView(R.id.top_nav_btn_done)
  Button btnDone;
  @BindView(R.id.vp_main)
  ViewPager vpMain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    mainActivityPreseneter = new MainActivityPresenter(this);

    vpMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    vpMain.setOffscreenPageLimit(1);
    vpMain.setCurrentItem(0);

    btnTodo.setTag(0);
    btnDone.setTag(1);
    btnTodo.setOnClickListener(movePageListener);
    btnDone.setOnClickListener(movePageListener);
  }

  View.OnClickListener movePageListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      int tag = (int) v.getTag();

      int i = 0;
      while (i < 2) {
        if (tag == i) {
          constraintLayoutMain.findViewWithTag(i).setSelected(true);
        } else {
          constraintLayoutMain.findViewWithTag(i).setSelected(false);
        }
        i++;
      }
      vpMain.setCurrentItem(tag);
    }
  };

  private class ViewPagerAdapter extends FragmentStatePagerAdapter {
    ViewPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new TodoFragment();
        case 1:
          return new DoneFragment();
        default:
          return null;
      }
    }

    @Override
    public int getCount() {
      return 2;
    }
  }
}
