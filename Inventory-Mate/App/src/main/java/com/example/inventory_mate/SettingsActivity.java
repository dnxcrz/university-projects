package com.example.inventory_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotifications;
    private Button buttonSaveSettings;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Inicializar componentes de UI
        switchNotifications = findViewById(R.id.switch_notifications);
        buttonSaveSettings = findViewById(R.id.button_save_settings);

        // Cargar el estado guardado del interruptor
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean isNotificationsEnabled = sharedPreferences.getBoolean("notifications_enabled", false);
        switchNotifications.setChecked(isNotificationsEnabled);

        // Establecer el listener para la navegación de los elementos seleccionados
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Iniciar la actividad HomeActivity
                        startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
                        return true;
                    case R.id.navigation_search:
                        // Iniciar la actividad InventoryActivity
                        startActivity(new Intent(SettingsActivity.this, InventoryActivity.class));
                        return true;
                    case R.id.navigation_settings:
                        // La actividad actual ya es SettingsActivity, por lo que no es necesario iniciar una nueva actividad
                        return true;
                }
                return false;
            }
        });

        // Guardar la configuración cuando se hace clic en el botón
        buttonSaveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSettings();
            }
        });
    }

    private void saveSettings() {
        // Guardar el estado del interruptor
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("notifications_enabled", switchNotifications.isChecked());
        editor.apply();

        // Notificar al usuario que se han guardado los ajustes
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}
