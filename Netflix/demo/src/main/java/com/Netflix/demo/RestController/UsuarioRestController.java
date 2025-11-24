package com.Netflix.demo.RestController;

import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.dao.DAOFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    @GetMapping("/api/usuarios")
    public List<Usuario> listaUsuarios(){
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> usuarios = daoFactory.getDaoUsuarios().getUsuarios();
        return usuarios;
    }

    @PostMapping("/api/usuarios")
    public void insertarUsuario(@RequestBody Usuario usuario){
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoUsuarios().insertarUsuario(usuario);
    }

    @PutMapping("/api/usuarios/{nombreUsuario}")
    public void actualizarUsuario(@PathVariable String nombreUsuario, @RequestBody Usuario usuario){
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoUsuarios().actualizarUsuario(nombreUsuario, usuario);
    }

    @DeleteMapping("/api/usuarios/{nombreUsuario}")
    public void eliminarUsuario(@PathVariable String nombreUsuario){
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getDaoUsuarios().eliminarUsuario(nombreUsuario);
    }



}
