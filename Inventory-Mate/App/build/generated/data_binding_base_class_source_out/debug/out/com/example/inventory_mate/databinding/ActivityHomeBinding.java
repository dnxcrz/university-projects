// Generated by view binder compiler. Do not edit!
package com.example.inventory_mate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.inventory_mate.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton addInventoryButton;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final MaterialButton inventoryButton;

  @NonNull
  public final TextView pageName;

  @NonNull
  public final MaterialButton reportButton;

  @NonNull
  public final View topBar;

  private ActivityHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton addInventoryButton, @NonNull BottomNavigationView bottomNavigation,
      @NonNull MaterialButton inventoryButton, @NonNull TextView pageName,
      @NonNull MaterialButton reportButton, @NonNull View topBar) {
    this.rootView = rootView;
    this.addInventoryButton = addInventoryButton;
    this.bottomNavigation = bottomNavigation;
    this.inventoryButton = inventoryButton;
    this.pageName = pageName;
    this.reportButton = reportButton;
    this.topBar = topBar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_inventory_button;
      MaterialButton addInventoryButton = ViewBindings.findChildViewById(rootView, id);
      if (addInventoryButton == null) {
        break missingId;
      }

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.inventory_button;
      MaterialButton inventoryButton = ViewBindings.findChildViewById(rootView, id);
      if (inventoryButton == null) {
        break missingId;
      }

      id = R.id.page_name;
      TextView pageName = ViewBindings.findChildViewById(rootView, id);
      if (pageName == null) {
        break missingId;
      }

      id = R.id.report_button;
      MaterialButton reportButton = ViewBindings.findChildViewById(rootView, id);
      if (reportButton == null) {
        break missingId;
      }

      id = R.id.top_bar;
      View topBar = ViewBindings.findChildViewById(rootView, id);
      if (topBar == null) {
        break missingId;
      }

      return new ActivityHomeBinding((ConstraintLayout) rootView, addInventoryButton,
          bottomNavigation, inventoryButton, pageName, reportButton, topBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
