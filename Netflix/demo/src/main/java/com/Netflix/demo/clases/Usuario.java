package com.Netflix.demo.clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombreUsuario;
    private List<Pelicula> peliculas;

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.peliculas = new ArrayList<>();
    }

    public Usuario(){}

    public void add(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


}
