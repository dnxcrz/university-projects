package com.example.inventory_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;
    private Button shareReportButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        recyclerView = findViewById(R.id.recycler_view);
        shareReportButton = findViewById(R.id.share_report_button);
        databaseHelper = new DatabaseHelper(this);

        // Recuperar todos los elementos de la base de datos
        List<InventoryItem> items = databaseHelper.getAllInventoryItems();

        reportAdapter = new ReportAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reportAdapter);

        shareReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File csvFile = generateCsvReport();
                if (csvFile != null) {
                    shareReport(csvFile);
                } else {
                    Toast.makeText(ReportActivity.this, "No se pudo generar el informe CSV", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private File generateCsvReport() {
        // Generar el informe CSV a partir de los elementos seleccionados
        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Item,Price,SKU,Supplier\n");

        // Recuperar los elementos seleccionados del adaptador
        List<InventoryItem> selectedItems = reportAdapter.getSelectedItems();
        for (InventoryItem item : selectedItems) {
            csvContent.append(item.getItemName())
                    .append(",")
                    .append(item.getItemPrice())
                    .append(",")
                    .append(item.getSku())
                    .append(",")
                    .append(item.getSupplier())
                    .append("\n");
        }

        // Guardar el contenido del CSV en un archivo
        try {
            File csvFile = new File(getExternalCacheDir(), "report.csv");
            FileWriter writer = new FileWriter(csvFile);
            writer.append(csvContent.toString());
            writer.flush();
            writer.close();
            return csvFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void shareReport(File csvFile) {
        // Compartir el archivo CSV utilizando Intent.ACTION_SEND
        Uri fileUri = FileProvider.getUriForFile(ReportActivity.this, BuildConfig.APPLICATION_ID + ".fileprovider", csvFile);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/csv");
        intent.putExtra(Intent.EXTRA_STREAM, fileUri);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Compartir Informe"));
        } else {
            Toast.makeText(ReportActivity.this, "No hay una aplicación disponible para compartir el informe", Toast.LENGTH_SHORT).show();
        }
    }
}
