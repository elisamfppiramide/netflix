package com.Netflix.demo.Controller;

import com.Netflix.demo.clases.Pelicula;
import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.dao.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PeliculaController {

    @GetMapping("/listaPeliculas")
    public String listaPeliculas(@RequestParam String nombreUsuario, Model model ){
        DAOFactory daoFactory = DAOFactory.getInstance();
        Usuario usuario = new Usuario(nombreUsuario);
        List<Pelicula> peliculas = daoFactory.getDaoPeliculas().getPeliculas(usuario);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("nombreUsuario", nombreUsuario);
        return "/listaPeliculas";
    }

    @GetMapping("/addPelicula")
    public String addPelicula(@RequestParam String nombreUsuario, Model model){
        model.addAttribute("nombreUsuario", nombreUsuario);
        model.addAttribute("pelicula", new Pelicula());
        return "addPelicula";
    }

    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula, @RequestParam String nombreUsuario){
        Usuario usuario = new Usuario(nombreUsuario);
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoPeliculas().addPelicula(usuario, pelicula);
        return "redirect:/listaPeliculas?nombreUsuario=" + nombreUsuario;
    }

    @PostMapping("/eliminarPelicula")
    public String eliminarPelicula(@RequestParam String nombre, @RequestParam String nombreUsuario){
        Usuario usuario = new Usuario(nombreUsuario);
        Pelicula pelicula = new Pelicula(nombre, 0);
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoPeliculas().eliminarPelicula(usuario, pelicula);

        return "redirect:/listaPeliculas?nombreUsuario=" + nombreUsuario;
    }

    @PostMapping("/actualizarPelicula")
    public String actualizarPelicula(@RequestParam String nombreAnterior, @RequestParam int duracion, @ModelAttribute Pelicula nueva, @RequestParam String nombreUsuario){
        Usuario usuario = new Usuario(nombreUsuario);
        Pelicula anterior = new Pelicula(nombreAnterior, duracion);
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoPeliculas().actualizarPelicula(usuario, anterior, nueva);

        return "redirect:/listaPeliculas?nombreUsuario=" + nombreUsuario;
    }












}
