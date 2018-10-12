package com.robot.mymvpdemo.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robot.mymvpdemo.base.mvp.IPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * 若把初始化内容放到initData实现,就是采用Lazy方式加载的Fragment
 * 若不需要Lazy加载则initData方法内留空,初始化内容放到initViews即可
 * <p>
 * -注1: 如果是与ViewPager一起使用，调用的是setUserVisibleHint。
 * --可以调用mViewPager.setOffscreenPageLimit(size),若设置了该属性 则viewpager会缓存指定数量+1的Fragment
 * -注2: 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
 * -注3: 针对初始就show的Fragment 为了触发onHiddenChanged事件 达到lazy效果 需要先hide再show
 * @author leo
 */
public abstract class BaseFragment<P extends IPresenter> extends DaggerFragment {

    @Inject
    @Nullable
    protected P mPresenter;

    protected String fragmentTitle;
    protected boolean isFirstLoad = true;//是否第一次加载
    protected LayoutInflater inflater;
    private boolean isVisible;//是否可见状态
    private boolean isPrepared;//标志位，View已经初始化完成。

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        isFirstLoad = true;
        int layoutId = getFragmentLayoutId();
        if (layoutId == 0) {
            throw new IllegalArgumentException("have you ever set the fragment layout Id？");
        }
        View view = inflater.inflate(layoutId, container, false);
        initView(view, inflater, container, savedInstanceState);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    protected abstract int getFragmentLayoutId();

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 使用时不要覆盖掉lazyLoad方法
     */
    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirstLoad) {
            return;
        }
        isFirstLoad = false;
        initData();
    }

    protected abstract void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();

    public String getTitle() {
        return TextUtils.isEmpty(fragmentTitle) ? "" : fragmentTitle;
    }

    public void setTitle(String title) {
        fragmentTitle = title;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }
}
