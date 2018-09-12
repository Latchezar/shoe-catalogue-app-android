package nikolov.com.shoecalatogueappandroid.diconfig;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;
import nikolov.com.shoecalatogueappandroid.services.HttpProductService;
import nikolov.com.shoecalatogueappandroid.services.base.ProductService;

@Module
public class ServiceModule {
    @Provides
    public ProductService productService(Repository<Product> repository){
        return new HttpProductService(repository);
    }
}
