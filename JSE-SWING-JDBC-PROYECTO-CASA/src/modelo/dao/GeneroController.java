/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.SQLException;
import java.util.List;
import modelo.entidades.Genero;

/**
 *
 * @author Tuka Manel
 */
public interface GeneroController {

    List<Genero> listagenero() throws SQLException;
}
