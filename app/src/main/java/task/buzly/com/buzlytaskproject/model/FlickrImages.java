package task.buzly.com.buzlytaskproject.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;



public class FlickrImages {
    @Expose
    private int page;
    @Expose
    private int pages;
    @Expose
    private int perpage;
    @Expose
    private String total;
    @Expose
    private ArrayList<FlickrImage> photo = new ArrayList<FlickrImage>();

    public FlickrImages() {
    }

    private FlickrImages(ArrayList<FlickrImage> photo) {
        this.photo = photo;
    }

    public ArrayList<FlickrImage> getPhotos() {
        return photo;
    }

    public void setPhotos(ArrayList<FlickrImage> photos) {
        this.photo = photos;
    }

    public void addPhoto(FlickrImage photoObj) {
        photo.add(photoObj);
    }
}