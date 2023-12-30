package com.example.inventory_mate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddInventoryActivity extends AppCompatActivity {

    EditText itemNameEditText, skuEditText, quantityEditText, priceEditText, supplierEditText;
    Button addInventoryButton;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);

        // Obtener referencias a los elementos de la interfaz de usuario
        itemNameEditText = findViewById(R.id.item_name);
        skuEditText = findViewById(R.id.sku);
        quantityEditText = findViewById(R.id.quantity);
        priceEditText = findViewById(R.id.price);
        supplierEditText = findViewById(R.id.supplier);
        addInventoryButton = findViewById(R.id.add_inventory_button);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Configurar el evento onClick para el botón de agregar inventario
        addInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos de texto
                String itemName = itemNameEditText.getText().toString().trim();
                String sku = skuEditText.getText().toString().trim();
                int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
                double price = Double.parseDouble(priceEditText.getText().toString().trim());
                String supplier = supplierEditText.getText().toString().trim();

                // Crear un intent con los datos del nuevo inventario
                Intent resultIntent = new Intent();
                resultIntent.putExtra("itemName", itemName);
                resultIntent.putExtra("sku", sku);
                resultIntent.putExtra("quantity", quantity);
                resultIntent.putExtra("price", price);
                resultIntent.putExtra("supplier", supplier);

                // Establecer el resultado como RESULT_OK y agregar el intent
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        // Establecer el evento de selección de elementos del menú de navegación
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Iniciar la actividad "HomeActivity"
                        startActivity(new Intent(AddInventoryActivity.this, HomeActivity.class));
                        finish();
                        return true;

                    case R.id.navigation_search:
                        // Iniciar la actividad "InventoryActivity"
                        startActivity(new Intent(AddInventoryActivity.this, InventoryActivity.class));
                        finish();
                        return true;

                    case R.id.navigation_settings:
                        // Iniciar la actividad "SettingsActivity"
                        startActivity(new Intent(AddInventoryActivity.this, SettingsActivity.class));
                        finish();
                        return true;
                }
                return false;
            }
        });
    }
}

