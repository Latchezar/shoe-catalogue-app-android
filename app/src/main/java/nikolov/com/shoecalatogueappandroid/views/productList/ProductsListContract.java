package nikolov.com.shoecalatogueappandroid.views.productList;

import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.models.Product;

public interface ProductsListContract {
    interface View{
        void setPresenter(Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductDetails(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProducts();

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}
