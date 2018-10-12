package com.robot.mymvpdemo.base;

import android.os.Environment;

import com.robot.mymvpdemo.App;

import java.io.File;

/**
 * 常量
 * @author leo
 */
public class Constants {
    //================= KEY ====================
    public static final String KEY_ALIPAY = "aex07566wvayrgxicnaraae";
    public static final String BUGLY_ID = "257700f3f8";
    //================= PATH ====================
    public static final String FILE_PROVIDER_AUTHORITY="com.robot.mymvpdemo.fileprovider";
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

}
