package modelo.entidades;

import java.util.Date;

public class Dominio {

    private int id_dominio;
    private String dominio_name;
    private String autor;
    private String descripcion;
    private String references;
    private int imagen;
    private Date last_update;

    public Dominio() {
    }

    public Dominio(String dominio_name) {
        this.dominio_name = dominio_name;
    }

    public Dominio(int id_dominio, String dominio_name, String autor, String descripcion, String references, int imagen, Date last_update) {
        this.id_dominio = id_dominio;
        this.dominio_name = dominio_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.references = references;
        this.imagen = imagen;
        this.last_update = last_update;
    }

    public int getId_dominio() {
        return id_dominio;
    }

    public void setId_dominio(int id_dominio) {
        this.id_dominio = id_dominio;
    }

    public String getDominio_name() {
        return dominio_name;
    }

    public void setDominio_name(String dominio_name) {
        this.dominio_name = dominio_name;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return dominio_name;
    }

}
