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

    public static Repository<Product> superheroRepository;
    private static HttpRequester httpRequester;
    private static JsonParser<Product> superheroJsonParser;
    private static Map<String, Repository> repositoriesMap;
    private static Map<String, JsonParser> jsonParsersMap;

    static {
        repositoriesMap = new HashMap<>();
        jsonParsersMap = new HashMap<>();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    public static <T> Repository<T> getRepository(Class<T> klass, Class<T[]> arrayKlass) {
        String klassKey = klass.getSimpleName();
        if (!repositoriesMap.containsKey(klassKey)) {
            String serverUrl =
                    getServerBaseUrl() + "/" +
                            klass.getSimpleName()
                                    .toLowerCase() +
                            "s";

            HttpRequester httpRequester = getHttpRequester();
            JsonParser<T> jsonParser = getJsonParser(klass, arrayKlass);
            Repository<T> repository = new HttpRepository<>(
                    serverUrl,
                    httpRequester,
                    jsonParser
            );

            repositoriesMap.put(klassKey, repository);
        }

        return repositoriesMap.get(klassKey);
    }

    private static <T> JsonParser<T> getJsonParser(Class<T> klass, Class<T[]> arrayKlass) {
        return null;
    }

    public static HttpRequester getHttpRequester() {
        if (httpRequester == null) {
            httpRequester = new OkHttpRequester();
        }

        return httpRequester;
    }

    public static String getServerBaseUrl() {
        return "http://192.168.160.143:8080/api";
    }

    public static JsonParser<Product> getSuperheroJsonParser() {
        if (superheroJsonParser == null) {
            superheroJsonParser = new GsonJsonParser<>(
                    Product.class,
                    Product[].class
            );
        }
        return superheroJsonParser;
    }

}
