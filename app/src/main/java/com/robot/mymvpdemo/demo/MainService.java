package com.robot.mymvpdemo.demo;

import com.robot.mymvpdemo.base.BaseResponse;
import com.robot.mymvpdemo.base.HouseKeeper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * @author leo
 */
public interface MainService {
    @POST("/japi/robot/lifeKeeping")
    Observable<BaseResponse<List<HouseKeeper>>> getHouseKeepers();
}
