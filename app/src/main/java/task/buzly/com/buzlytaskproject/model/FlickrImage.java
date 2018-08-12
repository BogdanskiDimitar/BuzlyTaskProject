package task.buzly.com.buzlytaskproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

import task.buzly.com.buzlytaskproject.util.Const;



public class FlickrImage implements Parcelable {
    private long id;
    private String owner;
    private String secret;
    private int server;
    private int farm;
    private String title;
    private int isPublic;
    private int isFriend;
    private int isFamily;

    public FlickrImage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(int isFriend) {
        this.isFriend = isFriend;
    }

    public int getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(int isFamily) {
        this.isFamily = isFamily;
    }

    public String buildImageUrl(){
        return String.format(Locale.getDefault(), Const.FLICKR_API_URL_IMAGES, getFarm(), getServer(), getId(), getSecret() , Const.FLICKR_API_PARAM_IMAGE_SIZE);
    }

    protected FlickrImage(Parcel in) {
        id = in.readLong();
        owner = in.readString();
        secret = in.readString();
        server = in.readInt();
        farm = in.readInt();
        title = in.readString();
        isPublic = in.readInt();
        isFriend = in.readInt();
        isFamily = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(owner);
        dest.writeString(secret);
        dest.writeInt(server);
        dest.writeInt(farm);
        dest.writeString(title);
        dest.writeInt(isPublic);
        dest.writeInt(isFriend);
        dest.writeInt(isFamily);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FlickrImage> CREATOR = new Parcelable.Creator<FlickrImage>() {
        @Override
        public FlickrImage createFromParcel(Parcel in) {
            return new FlickrImage(in);
        }

        @Override
        public FlickrImage[] newArray(int size) {
            return new FlickrImage[size];
        }
    };
}