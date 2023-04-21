package com.animee.rf_week02;

import android.app.Application;

import com.animee.rf_week02.db.DBManager;

/**
 * Application
 * 一个项目可能由多个activity对象, 但是只有一个application对象
 * 这是个全局对象,一旦项目被启动,这个对象会被创建, 项目光比, 被内存回收, 这个对象才会被回收.
 * 如何使用自己创建的Application对象
 * 1. 创建一个类, 继承Application
 * 2. 重构onCreate
 * 3. zaiAndroidManifest文件当中, 对于application标签, 进行name属性设置
 */
public class UniteApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 进行项目整体的初始化工作
        DBManager.initDB(getApplicationContext());
    }


}
