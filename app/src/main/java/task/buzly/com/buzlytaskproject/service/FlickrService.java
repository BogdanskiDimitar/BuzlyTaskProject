package task.buzly.com.buzlytaskproject.service;

import retrofit2.Call;
import retrofit2.http.GET;
import task.buzly.com.buzlytaskproject.model.FlickrRecentsResponse;
import task.buzly.com.buzlytaskproject.util.Const;



public interface FlickrService {

    String HTTPS_API_FLICKR_URL = Const.FLICKR_API_BASE_URL;

    @GET("?method=flickr.photos.getrecent")
    Call<FlickrRecentsResponse> getRecentImagesList();
}
