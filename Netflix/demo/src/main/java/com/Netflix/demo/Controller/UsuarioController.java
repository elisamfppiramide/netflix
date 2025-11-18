package com.Netflix.demo.Controller;

import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.dao.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

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


}
