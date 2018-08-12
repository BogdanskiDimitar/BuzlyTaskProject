package task.buzly.com.buzlytaskproject.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import task.buzly.com.buzlytaskproject.MVVMApplication;
import task.buzly.com.buzlytaskproject.di.Injector;



public class ViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    MVVMApplication application;

    public ViewModelFactory() {
        Injector.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FlickrViewModel.class)) {
            return (T) new FlickrViewModel(application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
