package com.robot.mymvpdemo.demo;

import com.robot.mymvpdemo.base.BaseResponse;
import com.robot.mymvpdemo.base.HouseKeeper;
import com.robot.mymvpdemo.base.mvp.IModel;
import com.robot.mymvpdemo.base.mvp.IPresenter;
import com.robot.mymvpdemo.base.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author leo
 */
public class MainContract{
    interface View extends IView<Presenter> {
       void setText(String text);
    }
    interface Presenter extends IPresenter<View> {
    }
    interface Model extends IModel{
        Observable<BaseResponse<List<HouseKeeper>>> getHoseKeepers();
    }
}
