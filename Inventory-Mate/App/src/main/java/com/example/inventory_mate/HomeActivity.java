package com.example.inventory_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.view.View;
import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialButton inventoryButton = findViewById(R.id.inventory_button);
        MaterialButton addInventoryButton = findViewById(R.id.add_inventory_button);
        MaterialButton reportButton = findViewById(R.id.report_button);

        // Configurar el OnClickListener para el botón "Inventory"
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad "InventoryActivity"
                Intent intent = new Intent(HomeActivity.this, InventoryActivity.class);
                startActivity(intent);
            }
        });

        // Configurar el OnClickListener para el botón "Add Inventory"
        addInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad "AddInventoryActivity"
                Intent intent = new Intent(HomeActivity.this, AddInventoryActivity.class);
                startActivity(intent);
            }
        });

        // Configurar el OnClickListener para el botón "Report"
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad "ReportActivity"
                Intent intent = new Intent(HomeActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });

        // Inicializar el BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Establecer el listener para los elementos seleccionados en la navegación inferior
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Iniciar la actividad "HomeActivity"
                        startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                        return true;

                    case R.id.navigation_search:
                        // Iniciar la actividad "InventoryActivity"
                        startActivity(new Intent(HomeActivity.this, InventoryActivity.class));
                        return true;

                    case R.id.navigation_settings:
                        // Iniciar la actividad "SettingsActivity"
                        startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                        return true;
                }
                return false;
            }
        });
    }
}
