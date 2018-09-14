package nikolov.com.shoecalatogueappandroid.views.productList;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import nikolov.com.shoecalatogueappandroid.Constants;
import nikolov.com.shoecalatogueappandroid.R;
import nikolov.com.shoecalatogueappandroid.http.HttpRequester;
import nikolov.com.shoecalatogueappandroid.http.OkHttpRequester;
import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.parsers.GsonJsonParser;
import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;
import nikolov.com.shoecalatogueappandroid.repositories.HttpRepository;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;
import nikolov.com.shoecalatogueappandroid.services.HttpProductService;
import nikolov.com.shoecalatogueappandroid.services.base.ProductService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements ProductsListContract.View, AdapterView.OnItemClickListener{
    private ProductsListContract.Navigator mNavigator;

    @BindView(R.id.product_list)
    ListView mProductListView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.filter)
    EditText mFilterEditText;

    @Inject
    ArrayAdapter<Product> mProductListAdapter;

    @Inject
    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        ButterKnife.bind(this, view);

        mProductListView.setAdapter(mProductListAdapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void setPresenter(ProductsListContract.Presenter presenter) {

    }

    @Override
    public void showProducts(List<Product> products) {

    }

    @Override
    public void showEmptyProductsList() {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showProductDetails(Product product) {

    }

    void setNavigator(ProductsListContract.Navigator navigator){
        mNavigator = navigator;
    }
}
