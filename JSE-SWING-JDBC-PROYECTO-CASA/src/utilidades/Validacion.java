package utilidades;

import javax.swing.JTextField;

/**
 *
 * @author Tuka Manel
 */
public interface Validacion {

    public static void validarCadena(JTextField field, boolean required, String nombre) throws ValidacionException {
        String contenidoCaja = field.getText();

        if (required) {
            if (contenidoCaja.trim().length() == 0) {
                throw new ValidacionException("La caja " + nombre + " es obligatoria");
            }
        }

        if (!contenidoCaja.matches("([A-Za-zñáéíóú.+]+[\\s]*)+")) {
            throw new ValidacionException("La caja " + nombre + " ha de contener unicamente letras");
        }
    }

    public static void validarMixto(JTextField field, boolean required, String nombre) throws ValidacionException {
        String contenidoCaja = field.getText();

        if (required) {
            if (contenidoCaja.trim().length() == 0) {
                throw new ValidacionException("La caja " + nombre + " es obligatoria");
            }
        }

        if (!contenidoCaja.matches("[^@#]+")) {
            throw new ValidacionException("La caja " + nombre + " ha de contener numeros y letras");
        }
    }
}
