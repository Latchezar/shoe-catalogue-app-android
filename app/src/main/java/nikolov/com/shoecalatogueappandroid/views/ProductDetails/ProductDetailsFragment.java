package nikolov.com.shoecalatogueappandroid.views.ProductDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nikolov.com.shoecalatogueappandroid.R;
import nikolov.com.shoecalatogueappandroid.models.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment implements ProductDetailsContracts.View {

    private ProductDetailsContracts.Presenter mPresenter;
    private TextView mNameTextView;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);

        mNameTextView = view.findViewById(R.id.tv_name);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProduct();
    }

    @Override
    public void showProduct(final Product product) {
        runOnUi(() -> {
            //mNameTextView.setText(product.getName());
            mNameTextView.setText("Test Product");
        });
    }

    @Override
    public void setPresenter(ProductDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }

    public static ProductDetailsFragment newInstance() {
        return new ProductDetailsFragment();
    }
}
