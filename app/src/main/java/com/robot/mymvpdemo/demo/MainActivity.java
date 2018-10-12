package com.robot.mymvpdemo.demo;

import android.os.Bundle;

import com.robot.mymvpdemo.R;
import com.robot.mymvpdemo.base.BaseActivity;
import com.robot.mymvpdemo.databinding.ActivityMainBinding;

/**
 * @author leo
 */
public class MainActivity extends BaseActivity<MainPresenter,ActivityMainBinding> implements MainContract.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.setView();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setText(String text) {
        binding.tvHello.setText(text);
    }
}
