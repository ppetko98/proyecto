package modelo.entidades;

import java.util.Date;

public class Genetica {

    private int id_secuencia;
    private boolean es_genomico_plasmido;
    private int longitud;
    private String topologia;
    private Date last_update;
    private String fasta;

    public Genetica() {
    }

    public Genetica(int id_secuencia, boolean es_genomico_plasmido, int longitud, String topologia) {
        this.id_secuencia = id_secuencia;
        this.es_genomico_plasmido = es_genomico_plasmido;
        this.longitud = longitud;
        this.topologia = topologia;
    }

        
    public Genetica(int id_secuencia, boolean es_genomico_plasmido, int longitud, String topologia, Date last_update, String fasta) {
        this.id_secuencia = id_secuencia;
        this.es_genomico_plasmido = es_genomico_plasmido;
        this.longitud = longitud;
        this.topologia = topologia;
        this.last_update = last_update;
        this.fasta = fasta;
    }

    public int getId_secuencia() {
        return id_secuencia;
    }

    public void setId_secuencia(int id_secuencia) {
        this.id_secuencia = id_secuencia;
    }

    public boolean isEs_genomico_plasmido() {
        return es_genomico_plasmido;
    }

    public void setEs_genomico_plasmido(boolean es_genomico_plasmido) {
        this.es_genomico_plasmido = es_genomico_plasmido;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getTopologia() {
        return topologia;
    }

    public void setTopologia(String topologia) {
        this.topologia = topologia;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getFasta() {
        return fasta;
    }

    public void setFasta(String fasta) {
        this.fasta = fasta;
    }

    @Override
    public String toString() {
        return "Genetica{"
                + "id_secuencia=" + id_secuencia
                + ", es_genomico_plasmido=" + es_genomico_plasmido
                + ", longitud=" + longitud
                + ", topologia='" + topologia + '\''
                + ", last_update=" + last_update
                + ", fasta=" + fasta.substring(0, 10)
                + '}';
    }

}
