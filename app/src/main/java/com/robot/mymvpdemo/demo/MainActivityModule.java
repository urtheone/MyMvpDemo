package com.robot.mymvpdemo.demo;

import com.robot.mymvpdemo.base.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author leo
 */
@Module
public abstract class MainActivityModule {

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter mainPresenter);

    @ActivityScoped
    @Provides
    static MainContract.Model mainModel(MainModel mainModel){
        return mainModel;
    }
    @ActivityScoped
    @Provides
    static MainContract.View mainView(MainActivity activity){
        return activity;
    }
}
