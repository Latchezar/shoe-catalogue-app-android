package nikolov.com.shoecalatogueappandroid.diconfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.async.AsyncRunner;
import nikolov.com.shoecalatogueappandroid.async.AsyncRunnerImpl;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public AsyncRunner asyncRunner(){
        return new AsyncRunnerImpl();
    }
}
