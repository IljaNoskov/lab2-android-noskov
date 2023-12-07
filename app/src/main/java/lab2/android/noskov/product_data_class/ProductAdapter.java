package lab2.android.noskov.product_data_class;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lab2.android.noskov.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<String> products;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        private final TextView product;

        private final Button addButton;

        public ProductViewHolder(View view) {
            super(view);
            product = (TextView) view.findViewById(R.id.product);
            addButton = (Button) view.findViewById(R.id.addButton);
        }

        public TextView getProduct() {
            return product;
        }

        public Button getAddButton() {
            return addButton;
        }
    }

    public ProductAdapter(List<String> products) {
        this.products = products;
    }

    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    public void onBindViewHolder(ProductViewHolder holder,
                                 int position) {
        holder.getProduct().setText(products.get(position));
        holder.getAddButton().setOnClickListener(v -> clear(position));
    }

    public int getItemCount() {
        return products.size();
    }

    public void save(String productName) {
        products.add(productName);
        notifyDataSetChanged();
    }

    public void clear(int position) {
        products.remove(position);
        notifyDataSetChanged();
    }

    public void clearAll() {
        products.clear();
        notifyDataSetChanged();
    }
}