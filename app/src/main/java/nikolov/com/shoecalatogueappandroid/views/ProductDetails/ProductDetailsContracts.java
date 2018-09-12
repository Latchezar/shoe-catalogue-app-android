package nikolov.com.shoecalatogueappandroid.views.ProductDetails;

import nikolov.com.shoecalatogueappandroid.models.Product;

public interface ProductDetailsContracts {
    interface View {
        void showProduct(Product product);
        void setPresenter(Presenter presenter);
        void showError(Exception e);
        void showLoading();
        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);
        void loadProduct();
    }
}
