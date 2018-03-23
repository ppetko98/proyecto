
package modelo.dao;

import java.util.List;
import modelo.entidades.Especie;
import modelo.entidades.EspecieException;

/**
 *
 * @author Tamara
 */
public interface EspecieController {
     List<Especie> lista() throws EspecieException;
}
