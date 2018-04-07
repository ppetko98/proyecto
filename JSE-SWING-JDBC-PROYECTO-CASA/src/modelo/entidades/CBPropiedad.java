package modelo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.BaseDatos;

/**
 *
 * @author ppetk
 */
public class CBPropiedad {

    String propiedad;
    int id;
    String query;
    ResultSet rs;
    int id_especie;

    public CBPropiedad(CBPropiedad cbp) {
        this(cbp.getPropiedad(), cbp.getId(), cbp.getQuery(), cbp.getId_especie());
    }

    public CBPropiedad(String propiedad, int id, String query, int id_especie) {
        this.propiedad = propiedad;
        this.id = id;
        this.query = query;
        this.id_especie = id_especie;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSet execute() throws SQLException {
        Connection connection = BaseDatos.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_especie);
        this.rs = ps.executeQuery();
        return rs;
    }

}
