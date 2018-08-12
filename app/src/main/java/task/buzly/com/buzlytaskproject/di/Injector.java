package task.buzly.com.buzlytaskproject.di;

import task.buzly.com.buzlytaskproject.di.component.AppComponent;
import task.buzly.com.buzlytaskproject.di.component.DaggerAppComponent;
import task.buzly.com.buzlytaskproject.di.module.AppModule;



public enum Injector {

    INSTANCE;

    private AppComponent appComponent;

    public void initAppComponent(AppModule appModule) {
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

