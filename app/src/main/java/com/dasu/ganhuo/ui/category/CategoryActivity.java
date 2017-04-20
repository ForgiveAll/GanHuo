package com.dasu.ganhuo.ui.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;

import com.dasu.ganhuo.R;
import com.dasu.ganhuo.mode.logic.category.CategoryController;
import com.dasu.ganhuo.ui.base.SwipeRefreshPagerActivity;

/**
 * Created by dasu on 2017/4/14.
 *
 * 分类浏览的主界面
 */

public class CategoryActivity extends SwipeRefreshPagerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initVariable();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private CategoryController mCategoryController;
    private CategoryPagerAdapter mPagerAdapter;

    private void initVariable() {
        mCategoryController = new CategoryController(this);
        mPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager(), mCategoryController.getCategoryList());
    }

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mBackBtn;
    private SwipeRefreshLayout mRefreshLayout;

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.layout_category_title);
        mViewPager = (ViewPager) findViewById(R.id.vp_category_content);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mBackBtn = (ImageView) findViewById(R.id.ibtn_category_back);
        mBackBtn.setOnClickListener(onBackBtnClick());
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.layout_category_content);
    }

    @Override
    public SwipeRefreshLayout findSwipeRefreshLayout() {
        return mRefreshLayout;
    }

    @Override
    public ViewPager findViewPager() {
        return mViewPager;
    }

    private View.OnClickListener onBackBtnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        };
    }
}
