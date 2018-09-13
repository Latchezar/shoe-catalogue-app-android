package nikolov.com.shoecalatogueappandroid.views.ProductDetails;

import java.io.IOException;

import nikolov.com.shoecalatogueappandroid.async.AsyncRunner;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;
import nikolov.com.shoecalatogueappandroid.services.base.ProductService;

public class ProductDetailsPresenter implements ProductDetailsContracts.Presenter {

    private final ProductService mProductsService;
    private final AsyncRunner mAsyncRunner;
    private ProductDetailsContracts.View mView;
    private int mProductId;


    public ProductDetailsPresenter(ProductService productsService, AsyncRunner asyncRunner) {
        mProductsService = productsService;
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(ProductDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProduct() {
        //mView.showLoading();
        AsyncRunner.runInBackground(() -> {
            try {
                Product product = mProductsService.getProductById(mProductId);
                mView.showProduct(product);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }

            //mView.hideLoading();
        });
    }

    public void setProductId(int productId) {
        mProductId = productId;
    }
}
