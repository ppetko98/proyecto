/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.SQLException;
import java.util.List;
import modelo.entidades.Clase;
import modelo.entidades.Dominio;
import modelo.entidades.Familia;
import modelo.entidades.Filo;
import modelo.entidades.Genero;
import modelo.entidades.Orden;

/**
 *
 * @author Tuka Manel
 */
public interface NomenclaturaController {

    
    
    
    List<Dominio> listaDominio() throws SQLException;
    List<Filo> listaFilo() throws SQLException;
    List<Clase> listaClase() throws SQLException;
    List<Orden> listaOrden() throws SQLException;
    List<Familia> listaFamilia() throws SQLException;
    List<Genero> listaGenero() throws SQLException;
    
}
