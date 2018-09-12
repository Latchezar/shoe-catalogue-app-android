package nikolov.com.shoecalatogueappandroid.diconfig;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.http.HttpRequester;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;
import nikolov.com.shoecalatogueappandroid.repositories.HttpRepository;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;

@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    public Repository<Product> productRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Product> jsonParser
            ){
        return new HttpRepository<>(baseServerUrl, httpRequester, jsonParser);
    }
}
