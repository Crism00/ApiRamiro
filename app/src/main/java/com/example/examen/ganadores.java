package com.example.examen;

public class ganadores {
    private String Nombre;
    private String Cantidad;

    public ganadores(String nombre, String cantidad) {
        Nombre = nombre;
        Cantidad = cantidad;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
