package nikolov.com.shoecalatogueappandroid.diconfig;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.parsers.GsonJsonParser;
import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;

@Module
public class ParserModule {
    @Provides
    public JsonParser<Product> productJsonParser(){
        return new GsonJsonParser<>(Product.class, Product[].class);
    }
}
