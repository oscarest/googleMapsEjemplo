package com.example.mappa;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mappa.Logic.LogicMapa;
import com.example.mappa.Model.Mapa;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    Mapa m;
    Button boton1;
    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        boton1 = findViewById(R.id.button);
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);
        edit4 = findViewById(R.id.editText4);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void insertarProducto(View view) {
        String descripcion = edit1.getText().toString();
        String longitud = edit2.getText().toString();
        String categoria = edit3.getText().toString();
        String latitud = edit4.getText().toString();
            Producto p = new Producto(nombre, Integer.parseInt(cantidad), seccion);
            LogicProducto.insertarProducto(this, p);
            mostrarMensaje("El producto " + nombre + " ha sido insertado.");
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Sevilla = new LatLng(37.382830, -5.973170);
        LatLng Huelva = new LatLng(37.2663800, -6.9400400);
        LatLng datos = new LatLng(m.getLongitud(), m.getLatitud());

        //mMap.addMarker(new MarkerOptions().position(Sevilla).title("Ciudad de Sevilla").icon(BitmapDescriptorFactory.fromResource(R.drawable.mi_marcador)));
        //mMap.addMarker(new MarkerOptions().position(Sevilla).title("Ciudad de Sevilla").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        //mMap.addMarker(new MarkerOptions().position(Huelva).title("Ciudad de Huelva"));
        //List lst = LogicMapa.listaMapa(this);
        mMap.addMarker(new MarkerOptions().position(datos).title(m.getDescripcion()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sevilla));

        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);

        mMap.setOnMarkerClickListener(this);
    }
    @Override
    public boolean onMarkerClick(final Marker marker) {

        Integer clickCount = (Integer) marker.getTag();

        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this, marker.getTitle() + " ha sido pulsado " + clickCount + " veces.", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

}