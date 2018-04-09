package modelo.dao;

import java.sql.SQLException;
import java.util.Collection;
import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;

import java.util.List;
import utilidades.BaseDatos;

/**
 *
 * @author Tamara
 */
public interface EspecieController {

    List<Especie> lista() throws SQLException;

    Collection<Especie> coleccionCompleta() throws SQLException;
    
    

    static void delete(Especie e) throws EspecieException, SQLException {
        int id = e.getId_especie();
        BaseDatos.executeUpdate(BaseDatos.DELETE_ESPECIE, id);
    }
    
    static void update (Especie e) throws EspecieException, SQLException {
        //int id = e.getId_especie();
        //BaseDatos.executeUpdate(BaseDatos.UPDATE_ESPECIE, id);
}
}