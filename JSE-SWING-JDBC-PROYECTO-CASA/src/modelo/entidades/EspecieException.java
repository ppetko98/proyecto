
package modelo.entidades;

/**
 *
 * @author Tamara
 */
public class EspecieException extends Exception {
    
    public EspecieException(String mensaje, Throwable error){
        super(mensaje, error);
        
    }
    
    public EspecieException(String mensaje){
        super(mensaje);
        
    }
}
