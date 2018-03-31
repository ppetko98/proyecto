package modelo.entidades;

import java.util.Date;

public class Genero {
    private int id_genero;
    private String genero_name;
    private String autor;
    private String descripcion;
    private String references;
    private Date last_update;

    public Genero() {
    }

    public Genero(int id_genero, String genero_name, String autor, String descripcion, String references, Date last_update) {
        this.id_genero = id_genero;
        this.genero_name = genero_name;
        this.autor = autor;
        this.descripcion = descripcion;
        this.references = references;
        this.last_update = last_update;
    }

    public Genero(int id_genero, String genero_name) {
         this.id_genero = id_genero;
        this.genero_name = genero_name;
    }

   
    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getGenero_name() {
        return genero_name;
    }

    public void setGenero_name(String genero_name) {
        this.genero_name = genero_name;
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
        return genero_name;
    }
    
    
    
    
    
    
}
