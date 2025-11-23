package com.Netflix.demo.dao.usuarios;

import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.conexion.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuariosMySQL implements DAOUsuarios{
    @Override
    public List<Usuario> getUsuarios() {
        String query = "select * from usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario(rs.getString("nombreUsuario"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        String query = "insert into usuario(nombreUsuario) values (?)";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, usuario.getNombreUsuario());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarUsuario(String nombreUsuario) {
        String query = "update usuario set nombreUsuario = ? where nombreUsuario = ?";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setString(2, nombreUsuario);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        String query = "delete from usuario where nombreUsuario = ?";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
