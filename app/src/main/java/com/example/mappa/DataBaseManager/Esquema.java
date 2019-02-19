package com.example.mappa.DataBaseManager;

import android.provider.BaseColumns;

public class Esquema {

    public Esquema() {
    }
    public static abstract class Mapa implements BaseColumns {
        public static final String TABLE_NAME = "Mapa";

        public static final String COLUMN_NAME_ID = "idLongitud";
        public static final String COLUMN_NAME_LONGITUD = "longitud";
        public static final String COLUMN_NAME_LATITUD = "latitud";
        public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
        public static final String COLUMN_NAME_IDCATEGORIA = "idCategoria";

        public static final String COLUMN_TYPE_ID = "INTEGER";
        public static final String COLUMN_TYPE_LONGITUD= "FLOAT";
        public static final String COLUMN_TYPE_LATITUD = "FLOAT";
        public static final String COLUMN_TYPE_DESCRIPCION = "TEXT";
        public static final String COLUMN_TYPE_IDCATEGORIA = "INTEGER";
    }

}
