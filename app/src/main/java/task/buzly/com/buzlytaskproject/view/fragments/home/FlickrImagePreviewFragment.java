package task.buzly.com.buzlytaskproject.view.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import task.buzly.com.buzlytaskproject.R;
import task.buzly.com.buzlytaskproject.model.FlickrImage;
import task.buzly.com.buzlytaskproject.util.Const;
import task.buzly.com.buzlytaskproject.view.fragments.BaseFragment;



public class FlickrImagePreviewFragment extends BaseFragment {
    @BindView(R.id.loading_progressbar)
    ProgressBar loadingProgressBar;
    @BindView(R.id.flickr_imageview)
    ImageView flickrImageView;
    @BindView(R.id.title_textview)
    TextView titleTextView;

    private FlickrImage flickrImage;

    public static FlickrImagePreviewFragment newInstance(FlickrImage flickrImage) {
        Bundle args = new Bundle();
        args.putParcelable(Const.ARG_FLICKR_IMAGE, flickrImage);

        FlickrImagePreviewFragment fragment = new FlickrImagePreviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_flickr_image_preview;
    }

    @Override
    protected void onCreateViewCallback(View rootView, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getFragmentArguments();
    }

    private void getFragmentArguments() {
        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(Const.ARG_FLICKR_IMAGE)) {
                this.flickrImage = args.getParcelable(Const.ARG_FLICKR_IMAGE);

                if(flickrImage != null) {
                    loadFlickrImage(flickrImage.buildImageUrl());
                    loadFlickrTitle(flickrImage.getTitle());
                }
            }
        }
    }

    private void loadFlickrImage(final String url){
        Picasso.get()
                .load(url)
                .into(flickrImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        loadingProgressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    private void loadFlickrTitle(final String title){
        titleTextView.setText(title);
    }
}
