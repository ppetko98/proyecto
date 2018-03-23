
package src.modelo.entidades;

public class Especie {
    private  int id_especie;
    private  String especie_name;
    private  String genero;
    private  String autor;
    private String descripcion;
    private int imagen;
    private String metabolismo;
    private String ecologia;
    private String references;
    private int id_secuencia;

    public Especie() {
    }
    
    

    public Especie(int id_especie, String especie_name, String autor, String descripcion, int imagen, String metabolismo, String ecologia, String references, int id_secuencia) {
        this.id_especie = id_especie;
        this.especie_name = especie_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.metabolismo = metabolismo;
        this.ecologia = ecologia;
        this.references = references;
        this.id_secuencia = id_secuencia;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public String getEspecie_name() {
        return especie_name;
    }

    public void setEspecie_name(String especie_name) {
        this.especie_name = especie_name;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMetabolismo() {
        return metabolismo;
    }

    public void setMetabolismo(String metabolismo) {
        this.metabolismo = metabolismo;
    }

    public String getEcologia() {
        return ecologia;
    }

    public void setEcologia(String ecologia) {
        this.ecologia = ecologia;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public int getId_secuencia() {
        return id_secuencia;
    }

    public void setId_secuencia(int id_secuencia) {
        this.id_secuencia = id_secuencia;
    }

    

    @Override
    public String toString() {
        return  id_especie + " " + genero + " " + especie_name ;
    }
    
    
    
    
}
