package nikolov.com.shoecalatogueappandroid.views.productList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import nikolov.com.shoecalatogueappandroid.async.AsyncRunner;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.services.base.ProductService;

public class ProductListPresenter implements ProductsListContract.Presenter {
    private final ProductService mProductService;
    private final AsyncRunner mAsyncRunner;
    private ProductsListContract.View mView;

    @Inject
    public ProductListPresenter (
            ProductService productService,
            AsyncRunner asyncRunner
    ){
        mProductService = productService;
        mAsyncRunner = asyncRunner;
    }


    @Override
    public void subscribe(ProductsListContract.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();

            mAsyncRunner.runInBackground(() -> {
                try {
                    Map<Integer, Product> products = mProductService.getAllProducts();
                    presentProductsToView(products);
                } catch (IOException e) {
                    e.printStackTrace();
                    mView.showError(e);
                }
                mView.hideLoading();
            });
    }

    private void presentProductsToView(Map<Integer, Product> products) {
        if (products.isEmpty()){
            mView.showEmptyProductsList();
        } else {
            List<Product> productList = new ArrayList<>(products.values());
            mView.showProducts(productList);
        }
    }


    @Override
    public void selectProduct(Product product) {
        mView.showProductDetails(product);
    }
}
