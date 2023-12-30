// Generated by view binder compiler. Do not edit!
package com.example.inventory_mate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.inventory_mate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class InventoryItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView itemNameTextView;

  @NonNull
  public final TextView itemPriceTextView;

  @NonNull
  public final TextView itemQuantityTextView;

  @NonNull
  public final TextView itemSkuTextView;

  @NonNull
  public final TextView itemSupplierTextView;

  private InventoryItemBinding(@NonNull LinearLayout rootView, @NonNull TextView itemNameTextView,
      @NonNull TextView itemPriceTextView, @NonNull TextView itemQuantityTextView,
      @NonNull TextView itemSkuTextView, @NonNull TextView itemSupplierTextView) {
    this.rootView = rootView;
    this.itemNameTextView = itemNameTextView;
    this.itemPriceTextView = itemPriceTextView;
    this.itemQuantityTextView = itemQuantityTextView;
    this.itemSkuTextView = itemSkuTextView;
    this.itemSupplierTextView = itemSupplierTextView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static InventoryItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static InventoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.inventory_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static InventoryItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.item_name_text_view;
      TextView itemNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemNameTextView == null) {
        break missingId;
      }

      id = R.id.item_price_text_view;
      TextView itemPriceTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemPriceTextView == null) {
        break missingId;
      }

      id = R.id.item_quantity_text_view;
      TextView itemQuantityTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemQuantityTextView == null) {
        break missingId;
      }

      id = R.id.item_sku_text_view;
      TextView itemSkuTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemSkuTextView == null) {
        break missingId;
      }

      id = R.id.item_supplier_text_view;
      TextView itemSupplierTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemSupplierTextView == null) {
        break missingId;
      }

      return new InventoryItemBinding((LinearLayout) rootView, itemNameTextView, itemPriceTextView,
          itemQuantityTextView, itemSkuTextView, itemSupplierTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
