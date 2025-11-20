package com.Netflix.demo.Controller;

import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.dao.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @PostMapping("/inicio")
    public String procesarInicio(@RequestParam String nombreUsuario) {
        return "redirect:/listaPeliculas?nombreUsuario=" + nombreUsuario;
    }

    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model){
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> usuarios = daoFactory.getDaoUsuarios().getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }

    @GetMapping("/addUsuario")
    public String addUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "addUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoUsuarios().insertarUsuario(usuario);
        return "redirect:/listaPeliculas?nombreUsuario=" + usuario.getNombreUsuario();
    }


}
