
package modelo.dao;

import java.sql.SQLException;
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
     List<Especie> lista() throws SQLException;
     Collection <Especie> coleccionCompleta() throws SQLException;
}
