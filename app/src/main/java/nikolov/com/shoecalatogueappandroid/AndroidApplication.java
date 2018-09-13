package nikolov.com.shoecalatogueappandroid;

import java.util.HashMap;
import java.util.Map;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import nikolov.com.shoecalatogueappandroid.diconfig.DaggerAppComponent;
import nikolov.com.shoecalatogueappandroid.http.HttpRequester;
import nikolov.com.shoecalatogueappandroid.http.OkHttpRequester;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.parsers.GsonJsonParser;
import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;
import nikolov.com.shoecalatogueappandroid.repositories.HttpRepository;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;


public class AndroidApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
        //return null;
    }
}
