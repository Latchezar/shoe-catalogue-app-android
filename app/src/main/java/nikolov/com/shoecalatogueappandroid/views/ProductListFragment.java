package nikolov.com.shoecalatogueappandroid.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.Map;

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
public class ProductListFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView mProductListView;
    private ArrayAdapter mProductListAdapter;
    private Repository mHttpRepository;
    private HttpRequester mHttpRequester;
    private JsonParser mJsonParser;
    private ProductService mProductService;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        mProductListView = view.findViewById(R.id.product_list);
        mProductListAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1);


        mProductListView.setAdapter(mProductListAdapter);
        mProductListView.setOnItemClickListener(this);
        mHttpRequester = new OkHttpRequester();
        mJsonParser = new GsonJsonParser(Product.class, Product[].class);

        mHttpRepository = new HttpRepository(Constants.SERVER_URL_BASE, mHttpRequester, mJsonParser);
        mProductService = new HttpProductService(mHttpRepository);





        return view;
    }

    public static Fragment newInstance() {
        return new ProductListFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
