package task.buzly.com.buzlytaskproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import task.buzly.com.buzlytaskproject.di.Injector;
import task.buzly.com.buzlytaskproject.model.FlickrImage;
import task.buzly.com.buzlytaskproject.model.FlickrRecentsResponse;
import task.buzly.com.buzlytaskproject.service.FlickrService;



public class FlickrViewModel extends AndroidViewModel {
    @Inject
    FlickrService flickrService;

    private MutableLiveData<List<FlickrImage>> imageLiveData = new MutableLiveData<>();

    public FlickrViewModel(@NonNull Application application) {
        super(application);

        Injector.INSTANCE.getAppComponent().inject(this);
    }

    public void fetchImages() {
        flickrService.getRecentImagesList().enqueue(new Callback<FlickrRecentsResponse>() {
            @Override
            public void onResponse(Call<FlickrRecentsResponse> call, Response<FlickrRecentsResponse> response) {
                imageLiveData.setValue(response.body().getPhotosObject().getPhotos());
            }

            @Override
            public void onFailure(Call<FlickrRecentsResponse> call, Throwable t) {
                imageLiveData.setValue(null);
            }
        });
    }

    public MutableLiveData<List<FlickrImage>> getImageLiveData() {
        return imageLiveData;
    }
}
