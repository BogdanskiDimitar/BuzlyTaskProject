package task.buzly.com.buzlytaskproject.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import task.buzly.com.buzlytaskproject.util.interfaces.Callbacks;



public abstract class BaseActivity extends AppCompatActivity implements Callbacks {
    protected FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void changeFragment(Class<? extends Fragment> fragment, Bundle args, boolean shouldAddtoBackStack) {
        if (fragmentManager == null)
            this.fragmentManager = getSupportFragmentManager();
        try {
            Fragment reflectedFragment = (Fragment) Class.forName(fragment.getName()).newInstance();
            if (args != null)
                reflectedFragment.setArguments(args);

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(getFrameLayout().getId(), reflectedFragment);
            if (shouldAddtoBackStack)
                transaction.addToBackStack(reflectedFragment.getClass().getSimpleName());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1)
            this.finish();
        else
            super.onBackPressed();
    }

    protected abstract FrameLayout getFrameLayout();

}


