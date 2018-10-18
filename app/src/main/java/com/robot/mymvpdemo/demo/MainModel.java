package com.robot.mymvpdemo.demo;

import com.robot.mymvpdemo.base.BaseResponse;
import com.robot.mymvpdemo.base.HouseKeeper;
import com.robot.mymvpdemo.base.di.ActivityScoped;
import com.robot.mymvpdemo.base.mvp.BaseModel;
import com.robot.mymvpdemo.base.mvp.IRepositoryManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author leo
 */
@ActivityScoped
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<BaseResponse<List<HouseKeeper>>> getHoseKeepers() {
        return mRepositoryManager.obtainRetrofitService(MainService.class).getHouseKeepers();
    }
}
