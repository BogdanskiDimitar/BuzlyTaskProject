package task.buzly.com.buzlytaskproject.model;

import com.google.gson.annotations.Expose;


public class FlickrRecentsResponse {
    @Expose
    private FlickrImages photos;
    @Expose private String stat;

    public FlickrImages getPhotosObject(){return photos;}

    public void setPhotosObject(FlickrImages photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
