
package modelo.dao;

import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;

import java.util.List;

/**
 *
 * @author Tamara
 */
public interface EspecieController {
     List<Especie> lista() throws EspecieException;
}
