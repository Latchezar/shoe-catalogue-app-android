package nikolov.com.shoecalatogueappandroid;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class Application extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;

        //return DaggerAppComponent.builder().application(this).build();
    }
}
