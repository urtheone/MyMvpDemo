package com.robot.mymvpdemo.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.robot.mymvpdemo.App;
import com.robot.mymvpdemo.base.mvp.IPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


/**
 * @author leo
 */
public abstract class BaseActivity<P extends IPresenter,V extends ViewDataBinding> extends DaggerAppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();

    @Inject
    @Nullable
    protected P mPresenter;
    protected V binding;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().addActivity(this);
        mContext = this;
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * this activity layout res
     * 设置layout布局,在子类重写该方法.
     *
     * @return res layout xml id
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        App.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onResume() {
        if (mPresenter != null) {
            mPresenter.takeView(this);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (mPresenter != null){
            mPresenter.dropView();
        }
        super.onPause();
    }
}
