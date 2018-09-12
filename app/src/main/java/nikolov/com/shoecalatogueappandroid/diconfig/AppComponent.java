package nikolov.com.shoecalatogueappandroid.diconfig;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import nikolov.com.shoecalatogueappandroid.AndroidApplication;

import javax.inject.Singleton;


@Singleton
@Component(modules = {
        ServiceModule.class,
        RepositoriesModule.class,
        ParserModule.class,
        HttpModule.class,
        AsyncModule.class,
        ProductListModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AndroidApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(AndroidApplication application);

        AppComponent build();
    }
}
