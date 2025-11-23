package com.Netflix.demo.dao.usuarios;

import com.Netflix.demo.clases.Usuario;

import java.util.List;

public interface DAOUsuarios {

    List<Usuario> getUsuarios();
    void insertarUsuario(Usuario usuario);
    void actualizarUsuario(String nombreUsuario);
    void eliminarUsuario(String nombreUsuario);

}
