package com.Netflix.demo.dao;

import com.Netflix.demo.dao.peliculas.DAOPeliculas;
import com.Netflix.demo.dao.peliculas.DAOPeliculasMySQL;
import com.Netflix.demo.dao.usuarios.DAOUsuarios;
import com.Netflix.demo.dao.usuarios.DAOUsuariosMySQL;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOUsuarios daoUsuarios;
    private DAOPeliculas daoPeliculas;
    private DAOFactory(){}


    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOUsuarios getDaoUsuarios(){
        if(this.daoUsuarios == null){
            this.daoUsuarios = new DAOUsuariosMySQL();
        }
        return this.daoUsuarios;
    }

    public DAOPeliculas getDaoPeliculas(){
        if(this.daoPeliculas == null){
            this.daoPeliculas = new DAOPeliculasMySQL();
        }
        return this.daoPeliculas;
    }
}
