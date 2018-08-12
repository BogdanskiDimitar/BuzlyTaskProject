package task.buzly.com.buzlytaskproject.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import task.buzly.com.buzlytaskproject.util.interfaces.Callbacks;



public abstract class BaseFragment extends Fragment {
    public Callbacks mCallbacks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);

        onCreateViewCallback(rootView, inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallbacks = (Callbacks) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    protected abstract int getLayoutId();
    protected abstract void onCreateViewCallback(final View rootView, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}


