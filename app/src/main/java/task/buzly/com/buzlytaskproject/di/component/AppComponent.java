package task.buzly.com.buzlytaskproject.di.component;

import javax.inject.Singleton;

import dagger.Component;
import task.buzly.com.buzlytaskproject.di.module.AppModule;
import task.buzly.com.buzlytaskproject.view.fragments.home.HomeFragment;
import task.buzly.com.buzlytaskproject.viewmodel.FlickrViewModel;
import task.buzly.com.buzlytaskproject.viewmodel.ViewModelFactory;



@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(ViewModelFactory viewModelFactory);

    void inject(FlickrViewModel flickrViewModel);

    void inject(HomeFragment homeFragment);
}

