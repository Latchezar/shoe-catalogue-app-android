package nikolov.com.shoecalatogueappandroid.diconfig;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.Constants;
import nikolov.com.shoecalatogueappandroid.http.HttpRequester;
import nikolov.com.shoecalatogueappandroid.http.OkHttpRequester;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester(){
        return new OkHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl(){
        return Constants.SERVER_URL_BASE;
    }
}
