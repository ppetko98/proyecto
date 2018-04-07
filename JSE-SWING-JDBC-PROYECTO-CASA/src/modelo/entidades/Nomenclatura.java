package modelo.entidades;

public class Nomenclatura {

    private int especie, dominio, filo, clase, orden, familia, genero;

    public Nomenclatura(int especie, int genero, int clase, int filo, int orden, int familia, int dominio) {
        this.especie = especie;
        this.genero = genero;
        this.clase = clase;
        this.filo = filo;
        this.orden = orden;
        this.familia = familia;
        this.dominio = dominio;
    }

    public Nomenclatura() {
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public int getFilo() {
        return filo;
    }

    public void setFilo(int filo) {
        this.filo = filo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public int getDominio() {
        return dominio;
    }

    public void setDominio(int dominio) {
        this.dominio = dominio;
    }

    @Override
    public String toString() {
        return "Nomenclatura{"
                + "especie=" + especie
                + ", genero=" + genero
                + ", clase=" + clase
                + ", filo=" + filo
                + ", orden=" + orden
                + ", familia=" + familia
                + ", dominio=" + dominio
                + '}';
    }
}
