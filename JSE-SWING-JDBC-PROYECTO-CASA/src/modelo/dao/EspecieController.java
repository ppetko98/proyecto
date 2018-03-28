
package modelo.dao;

import java.sql.Connection;
import java.util.Collection;
import modelo.entidades.Especie;
import src.modelo.excepciones.EspecieException;
import java.util.List;

import java.util.List;

/**
 *
 * @author Tamara
 */
public interface EspecieController {
     List<Especie> lista() throws EspecieException;
     Collection <Especie> coleccionCompleta() throws EspecieException;
    //void delete (Especie especieCompleta, Connection connection) throws EspecieException;
}
