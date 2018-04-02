package modelo.entidades;

import java.util.Date;

public class Filo {
    
    private int id_filo;
    private String filo_name;
    private String autor;
    private String descripcion;
    private String references;
    private Date last_update;
    private String imagen;

    public Filo() {
    }

    public Filo(String filo_name) {
        this.filo_name = filo_name;
    }

    
    public Filo(int id_filo, String filo_name, String autor, String descripcion, String references, Date last_update, String imagen) {
        this.id_filo = id_filo;
        this.filo_name = filo_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.references = references;
        this.last_update = last_update;
        this.imagen = imagen;
    }

    public int getId_filo() {
        return id_filo;
    }

    public void setId_filo(int id_filo) {
        this.id_filo = id_filo;
    }

    public String getFilo_name() {
        return filo_name;
    }

    public void setFilo_name(String filo_name) {
        this.filo_name = filo_name;
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
        return  filo_name ;
    }
    
    
    
}
