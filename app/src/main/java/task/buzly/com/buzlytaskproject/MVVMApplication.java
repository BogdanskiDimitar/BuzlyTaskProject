package task.buzly.com.buzlytaskproject;

import android.app.Application;

import task.buzly.com.buzlytaskproject.di.Injector;
import task.buzly.com.buzlytaskproject.di.module.AppModule;


public class MVVMApplication extends Application {

    private static final String TAG = MVVMApplication.class.getSimpleName();

    private static MVVMApplication singletonApplication;

    public MVVMApplication() {
        super();

        singletonApplication = this;
    }

    public static MVVMApplication get() {
        return singletonApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);

        Injector.INSTANCE.initAppComponent(appModule);
    }
}



