package nikolov.com.shoecalatogueappandroid.views;

import java.util.Map;

import nikolov.com.shoecalatogueappandroid.models.Product;

public interface ProductsListContract {
    interface View{
        void setPresenter(Presenter presenter);

        void showProducts(Map<Integer, Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductDetails(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProducts();

        void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}
