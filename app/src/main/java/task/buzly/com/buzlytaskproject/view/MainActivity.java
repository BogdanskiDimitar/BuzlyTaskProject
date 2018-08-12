package task.buzly.com.buzlytaskproject.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.FrameLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import task.buzly.com.buzlytaskproject.R;
import task.buzly.com.buzlytaskproject.di.Injector;
import task.buzly.com.buzlytaskproject.view.fragments.home.HomeFragment;
import task.buzly.com.buzlytaskproject.viewmodel.ViewModelFactory;

public class MainActivity extends BaseActivity {
    @BindView(R.id.rootLayout)
    FrameLayout rootLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        changeFragment(HomeFragment.class, null, true);
    }

    @Override
    protected FrameLayout getFrameLayout() {
        return rootLayout;
    }
}
