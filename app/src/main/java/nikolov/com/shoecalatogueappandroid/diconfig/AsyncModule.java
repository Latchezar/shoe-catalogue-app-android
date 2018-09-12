package nikolov.com.shoecalatogueappandroid.diconfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.async.AsyncRunner;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public AsyncRunner asyncRunner(){
        return new AsyncRunner();
    }
}
