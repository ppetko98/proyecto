
package modelo.entidades;

/**
 *
 * @author Tamara
 * @author ppetk
 */
public class Especie {
    private  int id_especie;
    private  String nombreEspecie;
    private  String nombreGenero;

    public Especie(int codigoEspecie, String nombreEspecie, String nombreGenero) {
        this.id_especie = codigoEspecie;
        this.nombreEspecie = nombreEspecie;
        this.nombreGenero = nombreGenero;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
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
        return  id_especie + " " + nombreEspecie + " " + nombreGenero ;
    }
    
    
    
    
}
