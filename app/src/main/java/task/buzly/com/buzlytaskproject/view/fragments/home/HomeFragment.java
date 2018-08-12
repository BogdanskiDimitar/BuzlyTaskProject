package task.buzly.com.buzlytaskproject.view.fragments.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import task.buzly.com.buzlytaskproject.R;
import task.buzly.com.buzlytaskproject.di.Injector;
import task.buzly.com.buzlytaskproject.model.FlickrImage;
import task.buzly.com.buzlytaskproject.view.fragments.BaseFragment;
import task.buzly.com.buzlytaskproject.view.fragments.home.adapter.HomeAdapter;
import task.buzly.com.buzlytaskproject.viewmodel.FlickrViewModel;
import task.buzly.com.buzlytaskproject.viewmodel.ViewModelFactory;



public class HomeFragment extends BaseFragment {
    @Inject
    ViewModelFactory viewModelFactory;
    @BindView(R.id.flickr_viewpager)
    ViewPager flickrViewPager;
    @BindView(R.id.empty_results_textview)
    TextView emptyResultsTextview;

    final Observer<List<FlickrImage>> imagesLiveDataObserver = new Observer<List<FlickrImage>>() {
        @Override
        public void onChanged(@Nullable final List<FlickrImage> flickrImageList) {
            initFlickrGalleryUI(flickrImageList);
        }
    };

    private FlickrViewModel viewModel;
    private HomeAdapter homeAdapter;

    @Override
    public void onStart() {
        super.onStart();
        Injector.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FlickrViewModel.class);

        setupImagesData();
    }

    @Override
    protected void onCreateViewCallback(View rootView, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View has been created
    }

    private void setupImagesData() {
        viewModel.getImageLiveData().observe(this, imagesLiveDataObserver);
        viewModel.fetchImages();
    }

    private void initFlickrGalleryUI(final List<FlickrImage> flickrImageList) {
        if (flickrImageList != null && flickrImageList.size() > 0) {
            toggleEmptyView(false);

            if (homeAdapter == null) {
                homeAdapter = new HomeAdapter(getChildFragmentManager(), flickrImageList);
                flickrViewPager.setAdapter(homeAdapter);
            } else {
                homeAdapter.setFlickrImageList(flickrImageList);
                homeAdapter.notifyDataSetChanged();
            }
        } else {
            //empty view here
            toggleEmptyView(true);
        }
    }

    private void toggleEmptyView(boolean toggle) {
        emptyResultsTextview.setVisibility(toggle ? View.VISIBLE : View.GONE);
        flickrViewPager.setVisibility(toggle ? View.GONE : View.VISIBLE);
    }
}
