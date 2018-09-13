package nikolov.com.shoecalatogueappandroid;

import java.util.HashMap;
import java.util.Map;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import nikolov.com.shoecalatogueappandroid.diconfig.DaggerAppComponent;


public class AndroidApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
