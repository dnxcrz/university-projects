package com.example.inventory_mate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_INVENTORY = "inventory";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_SKU = "sku";
    private static final String COLUMN_SUPPLIER = "supplier";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de inventario cuando se crea la base de datos
        String CREATE_TABLE_INVENTORY = "CREATE TABLE " + TABLE_INVENTORY + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_QUANTITY + " INTEGER,"
                + COLUMN_PRICE + " REAL,"
                + COLUMN_SKU + " TEXT,"
                + COLUMN_SUPPLIER + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_INVENTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar la tabla de inventario y crearla nuevamente cuando se actualiza la base de datos
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        onCreate(db);
    }

    public void addItem(InventoryItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.getItemName());
        values.put(COLUMN_QUANTITY, item.getItemQuantity());
        values.put(COLUMN_PRICE, item.getItemPrice());
        values.put(COLUMN_SKU, item.getSku());
        values.put(COLUMN_SUPPLIER, item.getSupplier());

        // Insertar un nuevo elemento de inventario en la base de datos
        db.insert(TABLE_INVENTORY, null, values);
        db.close();
    }

    public ArrayList<InventoryItem> getAllInventoryItems() {
        ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_INVENTORY, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                int quantityIndex = cursor.getColumnIndex(COLUMN_QUANTITY);
                int priceIndex = cursor.getColumnIndex(COLUMN_PRICE);
                int skuIndex = cursor.getColumnIndex(COLUMN_SKU);
                int supplierIndex = cursor.getColumnIndex(COLUMN_SUPPLIER);

                if (nameIndex != -1 && quantityIndex != -1 && priceIndex != -1 && skuIndex != -1 && supplierIndex != -1) {
                    // Obtener los valores de las columnas para cada elemento de inventario
                    String name = cursor.getString(nameIndex);
                    int quantity = cursor.getInt(quantityIndex);
                    double price = cursor.getDouble(priceIndex);
                    String sku = cursor.getString(skuIndex);
                    String supplier = cursor.getString(supplierIndex);

                    // Crear un objeto InventoryItem y agregarlo a la lista
                    InventoryItem item = new InventoryItem(name, quantity, price, sku, supplier);
                    inventoryItems.add(item);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return inventoryItems;
    }
}
