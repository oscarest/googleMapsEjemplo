package com.example.mappa.DataBaseManager;

import com.example.mappa.DataBaseManager.Esquema.Mapa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_SQLite extends SQLiteOpenHelper {
    public static final int OPEN_MODE_READ = 1;
    public static final int OPEN_MODE_WRITE = 2;

    private static final String DATABASE_NAME = "maps.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Mapa.TABLE_NAME + " (" +
                    Mapa.COLUMN_NAME_ID + " " + Mapa.COLUMN_TYPE_ID + " PRIMARY KEY AUTOINCREMENT, " +
                    Mapa.COLUMN_NAME_LONGITUD + " " + Mapa.COLUMN_TYPE_LONGITUD + "," +
                    Mapa.COLUMN_NAME_LATITUD + " " + Mapa.COLUMN_TYPE_LATITUD +  "," +
                    Mapa.COLUMN_NAME_DESCRIPCION + " " + Mapa.COLUMN_TYPE_DESCRIPCION +  "," +
                    Mapa.COLUMN_NAME_IDCATEGORIA + " " + Mapa.COLUMN_TYPE_IDCATEGORIA + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Mapa.TABLE_NAME;

    public DB_SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public static SQLiteDatabase conectar(Context context, int open_mode) {
        DB_SQLite db = new DB_SQLite(context);
        SQLiteDatabase conn;
        if (open_mode == OPEN_MODE_READ)
            conn = db.getWritableDatabase();
        else
            conn = db.getReadableDatabase();
        return conn;
    }
    public static void desconectar(SQLiteDatabase conn) {
        conn.close();
    }


}
