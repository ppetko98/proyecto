/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
