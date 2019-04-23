package com.example.pagechangedemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private oneFragment mOneFragment;
    private twoFragment mTwoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initView() {
        mTableLayout = findViewById(R.id.tl_tabs);
        mViewPager = findViewById(R.id.vp_view);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),MainActivity.this,fragments,titles));
        mTableLayout.setupWithViewPager(mViewPager);//此方法就是让tablayout和ViewPager联动
    }

    private void initData() {
        fragments.add(mOneFragment.newInstance("one"));
        fragments.add(mTwoFragment.newInstance("two"));
        titles.add("one");
        titles.add("two");
    }
}
