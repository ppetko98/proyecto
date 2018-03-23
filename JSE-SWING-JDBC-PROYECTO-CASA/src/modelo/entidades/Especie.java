
package modelo.entidades;

/**
 *
 * @author Tamara
 */
public class Especie {
    private  int codigoEspecie;
    private  String nombreEspecie;
    private  String nombreGenero;

    public Especie(int codigoEspecie, String nombreEspecie, String nombreGenero) {
        this.codigoEspecie = codigoEspecie;
        this.nombreEspecie = nombreEspecie;
        this.nombreGenero = nombreGenero;
    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return  codigoEspecie + " " + nombreEspecie + " " + nombreGenero ;
    }
    
    
    
    
}
