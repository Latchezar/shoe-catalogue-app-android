package nikolov.com.shoecalatogueappandroid.views.ProductDetails;

import java.io.IOException;

import nikolov.com.shoecalatogueappandroid.async.AsyncRunner;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;

public class ProductDetailsPresenter implements ProductDetailsContracts.Presenter {

    private final Repository<Product> mProductsRepository;
    private ProductDetailsContracts.View mView;
    private int mProductId;

    public ProductDetailsPresenter(Repository<Product> productRepository) {
        mProductsRepository = productRepository;
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
                Product product = mProductsRepository.getById(mProductId);
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
