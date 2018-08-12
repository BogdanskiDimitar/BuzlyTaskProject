package task.buzly.com.buzlytaskproject.view.fragments.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import task.buzly.com.buzlytaskproject.model.FlickrImage;
import task.buzly.com.buzlytaskproject.view.fragments.home.FlickrImagePreviewFragment;



public class HomeAdapter extends FragmentStatePagerAdapter {
    private List<FlickrImage> flickrImageList;

    public HomeAdapter(FragmentManager fm, List<FlickrImage> flickrImageList) {
        super(fm);

        this.flickrImageList = flickrImageList;
    }

    @Override
    public Fragment getItem(int position) {
        return FlickrImagePreviewFragment.newInstance(flickrImageList.get(position));
    }

    @Override
    public int getCount() {
        return flickrImageList.size();
    }

    public void setFlickrImageList(List<FlickrImage> flickrImageList) {
        this.flickrImageList = flickrImageList;
    }
}