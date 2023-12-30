package com.example.inventory_mate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {
    private List<InventoryItem> items;
    private List<Boolean> itemSelections;

    public ReportAdapter(List<InventoryItem> items) {
        this.items = items;
        this.itemSelections = new ArrayList<>(items.size());
        for (int i = 0; i < items.size(); i++) {
            itemSelections.add(false);
        }
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño de un elemento de informe del inventario
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_item, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        // Vincular los datos del elemento de inventario con las vistas en el elemento de informe del inventario
        InventoryItem item = items.get(position);
        holder.itemNameTextView.setText(item.getItemName());
        holder.itemPriceTextView.setText(String.valueOf(item.getItemPrice()));
        holder.itemSkuTextView.setText(item.getSku());
        holder.itemSupplierTextView.setText(item.getSupplier());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void toggleItemSelection(int position) {
        // Alternar el estado de selección del elemento
        boolean isSelected = itemSelections.get(position);
        itemSelections.set(position, !isSelected);
        notifyItemChanged(position);
    }

    public List<InventoryItem> getSelectedItems() {
        // Obtener los elementos seleccionados en el informe del inventario
        List<InventoryItem> selectedItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (itemSelections.get(i)) {
                selectedItems.add(items.get(i));
            }
        }
        return selectedItems;
    }

    public static class ReportViewHolder extends RecyclerView.ViewHolder {
        private TextView itemNameTextView;
        private TextView itemPriceTextView;
        private TextView itemSkuTextView;
        private TextView itemSupplierTextView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            // Obtener las referencias a las vistas en el elemento de informe del inventario
            itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
            itemPriceTextView = itemView.findViewById(R.id.item_price_text_view);
            itemSkuTextView = itemView.findViewById(R.id.item_sku_text_view);
            itemSupplierTextView = itemView.findViewById(R.id.item_supplier_text_view);
        }
    }
}


