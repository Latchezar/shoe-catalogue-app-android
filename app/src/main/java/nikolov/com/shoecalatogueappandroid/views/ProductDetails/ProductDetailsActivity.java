package nikolov.com.shoecalatogueappandroid.views.ProductDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nikolov.com.shoecalatogueappandroid.AndroidApplication;
import nikolov.com.shoecalatogueappandroid.R;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;

public class ProductDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_KEY = "PRODUCT_EXTRA_KEY";

    private ProductDetailsFragment mProductDetailsFragment;
    private ProductDetailsPresenter mProductDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Repository<Product> repository = AndroidApplication.getRepository(Product.class, Product[].class);

        mProductDetailsPresenter = new ProductDetailsPresenter(repository);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra(ProductDetailsActivity.EXTRA_KEY);
        mProductDetailsPresenter.setProductId(product.getId());

        mProductDetailsFragment = ProductDetailsFragment.newInstance();
        mProductDetailsFragment.setPresenter(mProductDetailsPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mProductDetailsFragment)
                .commit();

        setContentView(R.layout.activity_product_details);
    }
}
