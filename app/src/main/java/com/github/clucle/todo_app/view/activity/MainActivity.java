package com.github.clucle.todo_app.view.activity;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
  @BindView(R.id.tab_layout_main)
  TabLayout tabLayoutMain;
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

    tabLayoutMain.setupWithViewPager(vpMain);
  }

  private class ViewPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Todo", "Done" };

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
      return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return tabTitles[position];
    }
  }
}
