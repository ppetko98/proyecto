
package modelo.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;
import java.util.List;

import java.util.List;

/**
 *
 * @author Tamara
 */
public interface EspecieController {

     
    //void delete (Especie especieCompleta, Connection connection) throws EspecieException;

     List<Especie> lista() throws SQLException;
     Collection <Especie> coleccionCompleta() throws SQLException;
    
}
