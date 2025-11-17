package com.Netflix.demo.dao.peliculas;

import com.Netflix.demo.clases.Pelicula;
import com.Netflix.demo.clases.Usuario;

import java.util.List;

public interface DAOPeliculas {
    List<Pelicula> getPeliculas(Usuario usuario);
    void addPelicula(Usuario usuario, Pelicula pelicula);
    void actualizarPelicula(Usuario usuario, Pelicula anterior, Pelicula nueva);
    void eliminarPelicula(Usuario usuario, Pelicula pelicula);
}
