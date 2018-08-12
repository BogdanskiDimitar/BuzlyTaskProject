package task.buzly.com.buzlytaskproject.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import task.buzly.com.buzlytaskproject.MVVMApplication;
import task.buzly.com.buzlytaskproject.service.BaseOkHttpClient;
import task.buzly.com.buzlytaskproject.service.FlickrService;
import task.buzly.com.buzlytaskproject.viewmodel.ViewModelFactory;



@Module
public class AppModule {

    private final MVVMApplication application;
    private static ViewModelFactory viewModelFactory;

    public AppModule(MVVMApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public MVVMApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public ViewModelFactory provideViewModelFactory() {
        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactory();
        }

        return viewModelFactory;
    }

    @Singleton
    @Provides
    FlickrService provideFlickrService() {
        return new Retrofit.Builder()
                .baseUrl(FlickrService.HTTPS_API_FLICKR_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(BaseOkHttpClient.fetchBaseOkHttpClient())
                .build()
                .create(FlickrService.class);
    }
}

