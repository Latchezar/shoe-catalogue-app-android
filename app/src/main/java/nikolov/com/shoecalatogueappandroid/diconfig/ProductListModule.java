package nikolov.com.shoecalatogueappandroid.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nikolov.com.shoecalatogueappandroid.views.productList.ProductListFragment;
import nikolov.com.shoecalatogueappandroid.views.productList.ProductListPresenter;
import nikolov.com.shoecalatogueappandroid.views.productList.ProductsListContract;

@Module
public abstract class ProductListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ProductListFragment produductListFragment();

    @ActivityScoped
    @Binds
    abstract ProductsListContract.Presenter productListPresenter(ProductListPresenter presenter);
}
