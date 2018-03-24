package src.modelo.entidades;

import java.util.Date;

public class Orden {

    private int id_orden;
    private String orden_name, autor;
    private String descripcion, references;
    private Date last_update;
    private String imagen;

    public Orden(int id_orden, String orden_name, String autor, String descripcion, String references, Date last_update, String imagen) {
        this.id_orden = id_orden;
        this.orden_name = orden_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.references = references;
        this.last_update = last_update;
        this.imagen = imagen;
    }

    public Orden() {
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public String getOrden_name() {
        return orden_name;
    }

    public void setOrden_name(String orden_name) {
        this.orden_name = orden_name;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id_orden=" + id_orden +
                ", orden_name='" + orden_name + '\'' +
                ", autor='" + autor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", references='" + references + '\'' +
                ", last_update=" + last_update +
                ", imagen='" + imagen + '\'' +
                '}';
    }

}
