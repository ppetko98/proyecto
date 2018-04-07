package modelo.entidades;

public class Imagenes {

    private int id_imagenes;
    private String imagen;

    public Imagenes(int id_imagenes, String imagen) {
        this.id_imagenes = id_imagenes;
        this.imagen = imagen;
    }

    public Imagenes() {
    }

    public int getId_imagenes() {
        return id_imagenes;
    }

    public void setId_imagenes(int id_imagenes) {
        this.id_imagenes = id_imagenes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Imagenes{"
                + "id_imagenes=" + id_imagenes
                + ", imagen='" + imagen + '\''
                + '}';
    }
}
