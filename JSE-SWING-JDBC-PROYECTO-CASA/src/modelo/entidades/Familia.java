package modelo.entidades;

import java.util.Date;

public class Familia {

    private int id_familia;
    private String familia_name, autor;
    private String descripcion,references;
    private Date last_update;

    public Familia(int id_familia, String familia_name, String autor, String descripcion, String references, Date last_update) {
        this.id_familia = id_familia;
        this.familia_name = familia_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.references = references;
        this.last_update = last_update;
    }

    public Familia() {
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getFamilia_name() {
        return familia_name;
    }

    public void setFamilia_name(String familia_name) {
        this.familia_name = familia_name;
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
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "id_familia=" + id_familia +
                ", familia_name='" + familia_name + '\'' +
                ", autor='" + autor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", references='" + references + '\'' +
                ", last_update=" + last_update +
                '}';
    }

}
