package modelo.dao;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import modelo.entidades.Clase;
import modelo.entidades.Dominio;
import modelo.entidades.Especie;
import modelo.entidades.Familia;
import modelo.entidades.Filo;
import modelo.entidades.Genero;
import modelo.entidades.Orden;
import modelo.excepciones.EspecieException;
import utilidades.BaseDatos;

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
    
     static void update (Especie e) throws EspecieException, SQLException {
        int id = e.getId_especie();
        BaseDatos.executeUpdate(BaseDatos.UPDATE_ESPECIE, id);
}
      static void update (Dominio d) throws EspecieException, SQLException {
        int id = d.getId_dominio();
        BaseDatos.executeUpdate(BaseDatos.UPDATE_DOMINIO, id);

}
}
