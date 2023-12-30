package com.example.inventory_mate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> implements Filterable {

    private List<InventoryItem> items;
    private List<InventoryItem> itemsFull;

    public InventoryAdapter(List<InventoryItem> items) {
        this.items = items;
        this.itemsFull = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento de inventario
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_item, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        // Vincular los datos del elemento de inventario a las vistas correspondientes
        InventoryItem item = items.get(position);
        holder.itemNameTextView.setText(item.getItemName());
        holder.itemQuantityTextView.setText(String.valueOf(item.getItemQuantity()));
        holder.itemPriceTextView.setText(String.valueOf(item.getItemPrice()));
        holder.itemSkuTextView.setText(item.getSku());
        holder.itemSupplierTextView.setText(item.getSupplier());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Filter getFilter() {
        return itemsFilter;
    }

    private Filter itemsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Filtrar los elementos según el texto de búsqueda
            List<InventoryItem> filteredItems = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                // Si no hay texto de búsqueda, mostrar todos los elementos
                filteredItems.addAll(itemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (InventoryItem item : itemsFull) {
                    // Filtrar por nombre del elemento
                    if (item.getItemName().toLowerCase().contains(filterPattern)) {
                        filteredItems.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredItems;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // Actualizar la lista de elementos filtrados y notificar al adaptador
            items.clear();
            items.addAll((List<InventoryItem>) results.values);
            notifyDataSetChanged();
        }
    };

    public void updateItems(List<InventoryItem> updatedItems) {
        // Actualizar la lista de elementos y notificar al adaptador
        items.clear();
        items.addAll(updatedItems);
        notifyDataSetChanged();
    }

    public static class InventoryViewHolder extends RecyclerView.ViewHolder {
        private TextView itemNameTextView;
        private TextView itemQuantityTextView;
        private TextView itemPriceTextView;
        private TextView itemSkuTextView;
        private TextView itemSupplierTextView;

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);
            // Obtener las referencias de las vistas en el diseño del elemento de inventario
            itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
            itemQuantityTextView = itemView.findViewById(R.id.item_quantity_text_view);
            itemPriceTextView = itemView.findViewById(R.id.item_price_text_view);
            itemSkuTextView = itemView.findViewById(R.id.item_sku_text_view);
            itemSupplierTextView = itemView.findViewById(R.id.item_supplier_text_view);
        }
    }
}
