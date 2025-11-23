package com.Netflix.demo.RestController;

import com.Netflix.demo.clases.Pelicula;
import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.dao.DAOFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaRestController {

    @GetMapping("/api/usuario/:nombreUsuario/peliculas")
    public List<Pelicula> listaPeliculas(@PathVariable String nombreUsuario){
        DAOFactory daoFactory = DAOFactory.getInstance();
        Usuario usuario = new Usuario(nombreUsuario);
        List<Pelicula> peliculas = daoFactory.getDaoPeliculas().getPeliculas(usuario);
        return peliculas;
    }

    @PostMapping("/api/usuario/:nombreUsuario/peliculas")
    public void insertarPelicula(@PathVariable String nombreUsuario, @RequestBody Pelicula pelicula){
        DAOFactory daoFactory = DAOFactory.getInstance();
        Usuario usuario = new Usuario(nombreUsuario);
        daoFactory.getDaoPeliculas().addPelicula(usuario, pelicula);
    }

    @PutMapping("/api/usuarios/:nombreUsuario/pelicula/:nombre")
    public void actualizarPelicula(@PathVariable String nombreUsuario, @PathVariable String nombre, @RequestBody Pelicula pelicula){
        DAOFactory daoFactory = DAOFactory.getInstance();
        Usuario usuario = new Usuario(nombreUsuario);
        Pelicula pelicula1 = new Pelicula(nombre, pelicula.getDuracion());
        daoFactory.getDaoPeliculas().actualizarPelicula(usuario, pelicula1,  pelicula);
    }

    @DeleteMapping("/api/usuarios/:nombreUsuario/pelicula/:nombre")
    public void eliminarPelicula(@PathVariable String nombreUsuario, @PathVariable String nombre){
        DAOFactory daoFactory = DAOFactory.getInstance();
        Usuario usuario = new Usuario(nombreUsuario);
        Pelicula pelicula = new Pelicula(nombre, 0);
        daoFactory.getDaoPeliculas().eliminarPelicula(usuario, pelicula);
    }
}
