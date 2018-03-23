package src.modelo.entidades;

import java.util.Date;

public class Clase {

    private int id_clase;
    private String clase_name, autor;
    private String descripcion, References;
    private Date last_update;

    public Clase(int id_clase, String clase_name, String autor, String descripcion, String references, Date last_update) {
        this.id_clase = id_clase;
        this.clase_name = clase_name;
        this.autor = autor;
        this.descripcion = descripcion;
        References = references;
        this.last_update = last_update;
    }

    public Clase() {
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getClase_name() {
        return clase_name;
    }

    public void setClase_name(String clase_name) {
        this.clase_name = clase_name;
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

    public String getReferences() {
        return References;
    }

    public void setReferences(String references) {
        References = references;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id_clase=" + id_clase +
                ", clase_name='" + clase_name + '\'' +
                ", autor='" + autor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", References='" + References + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
