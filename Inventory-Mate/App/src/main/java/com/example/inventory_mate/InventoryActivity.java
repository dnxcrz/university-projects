package com.example.inventory_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    private InventoryAdapter inventoryAdapter;
    private ImageButton addInventoryButton;
    private BottomNavigationView bottomNavigationView;

    private static final int ADD_INVENTORY_REQUEST_CODE = 1;

    // Método para iniciar el escáner de códigos de barras
    private void launchBarcodeScanner() {
        IntentIntegrator integrator = new IntentIntegrator(InventoryActivity.this);
        integrator.setPrompt("Escanear código de barras");
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        EditText searchBar = findViewById(R.id.search_bar);
        ImageButton scanButton = findViewById(R.id.scan_button);
        RecyclerView inventoryRecyclerView = findViewById(R.id.inventory_recyclerview);
        addInventoryButton = findViewById(R.id.add_inventory_button);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Inicializar el helper de la base de datos
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        // Agregar los elementos a la base de datos si aún no se han agregado
        if (databaseHelper.getAllInventoryItems().isEmpty()) {
            databaseHelper.addItem(new InventoryItem("iPhone 14", 300, 1200.00, "100001", "Apple"));
            databaseHelper.addItem(new InventoryItem("Samsung Galaxy S23", 300, 1100.00, "200001", "Samsung"));
            databaseHelper.addItem(new InventoryItem("iPad Pro 11 Inch", 200, 799, "100005", "Apple"));
            databaseHelper.addItem(new InventoryItem("Apple Watch Ultra", 150, 799, "100009", "Apple"));
        }

        // Obtener los elementos del inventario de la base de datos
        ArrayList<InventoryItem> items = databaseHelper.getAllInventoryItems();

        inventoryAdapter = new InventoryAdapter(items);

        // Agregar un administrador de diseño al RecyclerView
        inventoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        inventoryRecyclerView.setAdapter(inventoryAdapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inventoryAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBarcodeScanner();
            }
        });

        addInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InventoryActivity.this, AddInventoryActivity.class);
                startActivityForResult(intent, ADD_INVENTORY_REQUEST_CODE);
            }
        });

        // Establecer el listener para los elementos seleccionados en la navegación inferior
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected
                    (@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
// Iniciar HomeActivity
                        startActivity(new Intent(InventoryActivity.this, HomeActivity.class));
                        return true;
                    case R.id.navigation_search:
// Iniciar InventoryActivity
                        startActivity(new Intent(InventoryActivity.this, InventoryActivity.class));
                        return true;
                    case R.id.navigation_settings:
// Iniciar SettingsActivity
                        startActivity(new Intent(InventoryActivity.this, SettingsActivity.class));
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_INVENTORY_REQUEST_CODE && resultCode == RESULT_OK) {
            // Verificar si el resultado es de AddInventoryActivity
            if (data != null && data.hasExtra("new_item")) {
                // Obtener el nuevo elemento del inventario del intent
                InventoryItem newItem = data.getParcelableExtra("new_item");

                // Agregar el nuevo elemento a la base de datos
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                databaseHelper.addItem(newItem);

                // Obtener los elementos actualizados del inventario de la base de datos
                ArrayList<InventoryItem> items = databaseHelper.getAllInventoryItems();

                // Actualizar el RecyclerView con los nuevos datos
                inventoryAdapter.updateItems(items);
            }
        }

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Escaneo cancelado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Escaneado: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        }
    }
}