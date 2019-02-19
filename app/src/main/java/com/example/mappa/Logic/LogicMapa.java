package com.example.mappa.Logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mappa.DataBaseManager.DB_SQLite;
import com.example.mappa.DataBaseManager.Esquema;
import com.example.mappa.Model.Mapa;

import java.util.ArrayList;
import java.util.List;

public class LogicMapa {

    public static void insertarMapa(Context context, Mapa mapa) {
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        ContentValues content = new ContentValues();
        content.put(Esquema.Mapa.COLUMN_NAME_DESCRIPCION, mapa.getDescripcion());
        content.put(Esquema.Mapa.COLUMN_NAME_LONGITUD, mapa.getLongitud());
        content.put(Esquema.Mapa.COLUMN_NAME_LATITUD, mapa.getLatitud());
        content.put(Esquema.Mapa.COLUMN_NAME_IDCATEGORIA, mapa.getIdCategoria());
        conn.insert(Esquema.Mapa.TABLE_NAME, null, content);
        DB_SQLite.desconectar(conn);
    }
    /*public static void eliminarProducto(Context context, Producto p) {
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        String sqlWhere = Esquema.Producto.COLUMN_NAME_NOMBRE + " LIKE '" + p.getNombre() + "'";
        conn.delete(Esquema.Producto.TABLE_NAME, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static void editarProducto(Context context, Producto p) {
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        ContentValues content = new ContentValues();
        content.put(Esquema.Producto.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Producto.COLUMN_NAME_CANTIDAD, p.getCantidad());
        content.put(Esquema.Producto.COLUMN_NAME_IDSECCION, p.getIdSeccion());
        String sqlWhere = Esquema.Producto.COLUMN_NAME_NOMBRE + " LIKE '" + p.getNombre() + "'";
        conn.update(Esquema.Producto.TABLE_NAME, content, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static Producto buscarProducto(Context context, Producto p) {
        Producto elto = p;

        String[] sqlFields = {Esquema.Producto.COLUMN_NAME_ID, Esquema.Producto.COLUMN_NAME_NOMBRE, Esquema.Producto.COLUMN_NAME_CANTIDAD, Esquema.Producto.COLUMN_NAME_IDSECCION};
        String sqlWhere = Esquema.Producto.COLUMN_NAME_NOMBRE + " LIKE '" + p.getNombre() + "'";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Producto.TABLE_NAME, sqlFields, sqlWhere, null, null, null, null);

        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Producto.COLUMN_NAME_ID));
            String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Producto.COLUMN_NAME_NOMBRE));
            Integer dataCantidad = cursor.getInt(cursor.getColumnIndex(Esquema.Producto.COLUMN_NAME_CANTIDAD));
            Long dataIdSeccion = cursor.getLong(cursor.getColumnIndex(Esquema.Producto.COLUMN_NAME_IDSECCION));
            elto = new Producto(dataId, dataNombre, dataCantidad, dataIdSeccion);
        }
        cursor.close();
        DB_SQLite.desconectar(conn);

        return elto;
    }
*/
    public static List listaMapa(Context context) {
        List lst = new ArrayList<>();

        String[] sqlFields = {Esquema.Mapa.COLUMN_NAME_ID, Esquema.Mapa.COLUMN_NAME_DESCRIPCION, Esquema.Mapa.COLUMN_NAME_LONGITUD, Esquema.Mapa.COLUMN_NAME_IDCATEGORIA, Esquema.Mapa.COLUMN_NAME_LATITUD};
        String sqlWhere = "";
        String sqlOrderBy = Esquema.Mapa.COLUMN_NAME_ID + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Mapa.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lst = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Mapa.COLUMN_NAME_ID));
                Float dataLongitud = cursor.getFloat(cursor.getColumnIndex(Esquema.Mapa.COLUMN_NAME_LONGITUD));
                Float dataLatitud = cursor.getFloat(cursor.getColumnIndex(Esquema.Mapa.COLUMN_NAME_LATITUD));
                String dataDescripcion = cursor.getString(cursor.getColumnIndex(Esquema.Mapa.COLUMN_NAME_DESCRIPCION));
                Long dataIdCategoria = cursor.getLong(cursor.getColumnIndex(Esquema.Mapa.COLUMN_NAME_IDCATEGORIA));
                lst.add(new Mapa(dataId, dataDescripcion, dataLongitud, dataIdCategoria, dataLatitud ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);

        return lst;
    }
}
