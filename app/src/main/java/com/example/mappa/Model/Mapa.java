package com.example.mappa.Model;

import java.nio.channels.FileLock;

public class Mapa {
    private Long id;
    private String descripcion;
    private Float longitud;
    private Float latitud;
    private Long idCategoria;

    public Mapa() {
        this.id = null;
        this.descripcion = "";
        this.longitud = null;
        this.latitud = null;
        this.idCategoria = null;
    }

    public Mapa(String descripcion, Float longitud, Long idCategoria, Float latitud) {
        this.id = null;
        this.descripcion = "";
        this.longitud = null;
        this.latitud = null;
        this.idCategoria = null;
    }

    public Mapa(Long id, String descripcion, Float longitud, Long idCategoria, Float latitud) {
        this.id = id;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }
    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdSeccion(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Mapa {" +
                "id=" + id +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", descripcion='" + descripcion + '\'' +
                ", idCategoria='" + idCategoria + '\'' +
                '}';
    }
}

