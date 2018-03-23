
package src.modelo.dao;

import src.modelo.entidades.Especie;
import src.modelo.excepciones.EspecieException;

import java.util.List;

/**
 *
 * @author Tamara
 */
public interface EspecieController {
     List<Especie> lista() throws EspecieException;
}
