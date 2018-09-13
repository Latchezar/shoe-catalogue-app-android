package nikolov.com.shoecalatogueappandroid.views.productList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import javax.inject.Inject;

import nikolov.com.shoecalatogueappandroid.R;
import nikolov.com.shoecalatogueappandroid.models.Product;

public class ProductListAdapter extends ArrayAdapter<Product> {
    @Inject
    public ProductListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(
                R.layout.product_item,
                parent,
                false
        );

        TextView nameTextView = view.findViewById(R.id.tv_name);
        TextView priceTextView = view.findViewById(R.id.tv_price);

        Product product = getItem(position);

        nameTextView.setText(product.getName());
        priceTextView.setText(product.getPrice());

        return view;
    }
}
