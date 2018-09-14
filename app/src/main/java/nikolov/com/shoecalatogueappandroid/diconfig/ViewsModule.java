package nikolov.com.shoecalatogueappandroid.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import dagger.Module;
import dagger.Provides;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.views.productList.ProductListAdapter;

@Module
public class ViewsModule {
    @Provides
    public ArrayAdapter<Product> productArrayAdapter(Context context){
        return new ProductListAdapter(context);
    }
}
