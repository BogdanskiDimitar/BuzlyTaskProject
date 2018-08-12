package task.buzly.com.buzlytaskproject.util.interfaces;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by DimitarBogdanski on 27-Jan-18.
 */
public interface Callbacks {
    void changeFragment(Class<? extends Fragment> fragment, Bundle args, boolean shouldAddToBackStack);
}
