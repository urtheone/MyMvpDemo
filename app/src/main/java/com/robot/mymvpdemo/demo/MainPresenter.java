package com.robot.mymvpdemo.demo;

import android.util.Log;

import com.robot.mymvpdemo.base.BaseResponse;
import com.robot.mymvpdemo.base.HouseKeeper;
import com.robot.mymvpdemo.base.mvp.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author leo
 */
public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View> implements MainContract.Presenter {
    @Inject
    public MainPresenter(MainContract.Model model,MainContract.View view){
        super(model,view);
    }
    public void setView(){
        Observer<BaseResponse<List<HouseKeeper>>> observer = mModel.getHoseKeepers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<BaseResponse<List<HouseKeeper>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"开始请求");
                    }

                    @Override
                    public void onNext(BaseResponse<List<HouseKeeper>> response) {
                        mRootView.setText(response.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"请求网络错误"+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"请求网络完成");
                    }
                });
    }
}
