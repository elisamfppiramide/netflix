package com.Netflix.demo.dao.peliculas;

import com.Netflix.demo.clases.Pelicula;
import com.Netflix.demo.clases.Usuario;
import com.Netflix.demo.conexion.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPeliculasMySQL implements DAOPeliculas{

    @Override
    public List<Pelicula> getPeliculas(Usuario usuario) {
        String query = "select * from pelicula where usuario = ?";
        List<Pelicula> peliculas = new ArrayList<>();

        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, usuario.getNombreUsuario());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pelicula pelicula = new Pelicula(rs.getString("nombre"), rs.getInt("duracion"));
                peliculas.add(pelicula);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return peliculas;
    }

    @Override
    public void addPelicula(Usuario usuario, Pelicula pelicula) {
        String query = "insert into pelicula values (?, ?, ?)";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, pelicula.getNombre());
            ps.setInt(2, pelicula.getDuracion());
            ps.setString(3, usuario.getNombreUsuario());
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarPelicula(Usuario usuario, Pelicula anterior, Pelicula nueva) {
        String query = "update pelicula set nombre = ?, duracion = ? where nombre = ? and usuario = ?";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, nueva.getNombre());
            ps.setInt(2, nueva.getDuracion());
            ps.setString(3, anterior.getNombre());
            ps.setString(4, usuario.getNombreUsuario());
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void eliminarPelicula(Usuario usuario, Pelicula pelicula) {
        String query = "delete from pelicula where nombre = ? and usuario = ?";
        try{
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, pelicula.getNombre());
            ps.setString(2, usuario.getNombreUsuario());
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
