package com.robot.mymvpdemo;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.robot.mymvpdemo.base.di.DaggerAppComponent;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.Stack;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * @author leo
 * @date 2017/1/11
 */

public class App extends DaggerApplication {
    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = false;
    private static App mInstance;
    /**
     * 用来保存所有已打开的Activity
     */
    private static Stack<Activity> sActivityStack = new Stack<>();
//    private User userInfo;
    private int jpush_sequence = 1;
//    private DaoSession daoSession;

    public static synchronized App getInstance() {
        return mInstance;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initBugly();
//        initJpush();
//        initGreenDao();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "1062721bfb", BuildConfig.DEBUG);
    }

//    private void initGreenDao() {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "robot-db-encrypted" : "robot-db");
//        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("Super_robot") : helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();
//    }

//    public DaoSession getDaoSession() {
//        return daoSession;
//    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

//    private void initJpush() {
//        JPushInterface.setDebugMode(BuildConfig.DEBUG);
//        JPushInterface.init(this);
//    }

    public void addActivity(Activity activity) {
        if (activity != null) {
            sActivityStack.push(activity);
        }
    }

    public void removeActivity(Activity activity) {
        if (activity != null && sActivityStack.contains(activity)) {
            sActivityStack.remove(activity);
        }
    }

    public void clearActivities() {
        int len = sActivityStack.size();
        for (int i = 0; i < len; i++) {
            Activity activity = sActivityStack.pop();
            activity.finish();
        }
    }

    public void clearOtherActivities(Activity activity) {
        int len = sActivityStack.size();
        for (int i = 0; i < len; i++) {
            Activity activity1 = sActivityStack.peek();
            if (activity1 != activity) {
                Log.e("bbb", "清理Activity" + activity1.getClass().getSimpleName());
                sActivityStack.pop();
                activity1.finish();
            }
            //            Log.e("bbb", "暂时保留Activity" + activity.getClass().getSimpleName());
            //            continue;
        }
    }

    public void clearActivity(Activity activity) {
        int len = sActivityStack.size();
        for (int i = 0; i < len; i++) {
            Activity activity1 = sActivityStack.peek();
            if (activity1 == activity) {
                Log.e("bbb", "清理Activity" + activity.getClass().getSimpleName());
                sActivityStack.pop();
                activity1.finish();
            }
        }
    }


    /**
     * 获取用户的信息
     */
//    public User getUserInfo() {
//        if (userInfo != null) {
//            Log.e("bbb", "--getUserInfo--app中缓存的用户信息---" + userInfo.toString());
//            return userInfo;
//        } else {
//            String s = SPHelper.getInstance().getUserId();
//            Log.e("bbb", "--getUserInfo--sp中存储的用户id---" + s);
//            if (TextUtils.isEmpty(s) || "null".equals(s)) {
//                return null;
//            }
//            UserDao userDao = daoSession.getUserDao();
//            daoSession.clear();
//            Query<User> userQuery = userDao.queryBuilder().where(UserDao.Properties.Id.eq(Integer.valueOf(s))).build();
//            userInfo = userQuery.unique();
//            if (userInfo != null) {
//                Log.e("bbb", "--getUserInfo--数据库中的用户信息------" + userInfo.toString());
//            } else {
//                Log.e("bbb", "--getUserInfo-----用户信息为空-----");
//            }
//        }
//        return userInfo;
//    }


    /**
     * 保存登录成功之后用户的信息
     *
     * @param result
     */
//    public void setUserInfo(User result) {
//        if (result != null) {
//            Log.e("bbb", "--setUserInfo--设置用户信息---传入的参数---" + result.toString());
//            UserDao userDao = daoSession.getUserDao();
//            Query<User> userQuery = userDao.queryBuilder().where(UserDao.Properties.Id.eq(result.getId())).build();
//            User user = userQuery.unique();
//            if (user != null) {
//                Log.e("bbb", "----查询到的之前的旧数据----" + user.toString());
//                result.setTableId(user.getTableId());
//                userInfo = result;
//            }
//            SPHelper.getInstance().setUserId(String.valueOf(result.getId()));
//            userDao.save(result);
//            Log.e("bbb", "--setUserInfo--设置用户信息---保存成功---");
//            Intent intent = new Intent(App.getInstance().getApplicationContext(), RobotService.class);
//            intent.setAction(Constants.ACTION_LOGIN_SMARTHOME);
//            startService(intent);
//        }
//    }

}
