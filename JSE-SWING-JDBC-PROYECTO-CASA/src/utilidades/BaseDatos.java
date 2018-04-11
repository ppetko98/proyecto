package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.entidades.Especie;

public interface BaseDatos {

    String DRIVERS = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/biologia";
    String USUARIO = "root";
    String CLAVE = "Pa$$w0rd";

    String SELECT_ESPECIE
            = "SELECT e.id_especie, g.genero_name, e.especie_name\n"
            + "FROM nomenclatura n INNER JOIN genero g \n"
            + "ON n.id_genero = g.id_genero\n"
            + "INNER JOIN especie e\n"
            + "ON n.id_especie = e.id_especie";

    String SELECT_ESPECIE2
            = "SELECT e.id_especie, g.genero_name, e.especie_name, e.autor, e.descripcion, e.imagen, e.ecologia, e.metabolismo, e.referencias,e.id_secuencia, ge.longitud, ge.topologia,ge.es_genomico_plasmido \n"
            + "FROM nomenclatura n INNER JOIN genero g \n"
            + "ON n.id_genero = g.id_genero\n"
            + "INNER JOIN especie e\n"
            + "ON n.id_especie = e.id_especie\n"
            + "INNER JOIN genetica ge\n"
            + "ON e.id_secuencia = ge.id_secuencia";

    String SELECT_GENERO = "SELECT genero_name FROM biologia.genero";
    String SELECT_FAMILIA = "SELECT familia_name FROM biologia.familia";
    String SELECT_ORDEN = "SELECT orden_name FROM biologia.orden";
    String SELECT_CLASE = "SELECT clase_name FROM biologia.clase";
    String SELECT_FILO = "SELECT filo_name FROM biologia.filo";
    String SELECT_DOMINIO = "SELECT dominio_name FROM biologia.dominio";

    String SELECT_TABLA = "SELECT e.descripcion, e.metabolismo, g.fasta FROM especie e INNER JOIN genetica g ON e.id_secuencia = g.id_secuencia WHERE e.id_especie = ?;";

    String SELECT_DESCRIPCION = "SELECT descripcion FROM biologia.especie WHERE especie.id_especie = ?;";
    String SELECT_METABOLISMO = "SELECT metabolismo FROM biologia.especie WHERE especie.id_especie = ?;";
    String SELECT_SECUENCIA = "SELECT fasta FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ?;";

    String SELECT_AUTOR = "SELECT autor FROM especie WHERE id_especie = ?;";
    String SELECT_ECOLOGIA = "SELECT ecologia FROM especie WHERE id_especie = ?;";
    String SELECT_REFERENCES = "SELECT especie.referencias FROM especie WHERE id_especie = ?;";
    String SELECT_ES_GENOMICO_PLASMIDO = "SELECT genetica.es_genomico_plasmido  FROM genetica inner join especie on genetica.id_secuencia = especie.id_secuencia where especie.id_especie = ?;";
    String SELECT_LONGITUD = "SELECT genetica.longitud FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ?;";
    String SELECT_TOPOLOGIA = "SELECT genetica.topologia FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ?;";

    String SELECT_GENETICA = "SELECT ge.id_secuencia, ge.longitud, ge.topologia, ge.es_genomico_plasmido\n"
            + "FROM genetica ge  INNER JOIN especie e\n"
            + "ON ge.id_secuencia = e.id_secuencia WHERE ge.id_secuencia  = ?";

    String DELETE_ESPECIE = "DELETE FROM biologia.especie where id_especie = ?;";
    String UPDATE_ESPECIE = "UPDATE biologia.especie SET especie_name = ?, autor = ?, descripcion = ?, metabolismo =?, ecologia = ?,  referencias = ? where id_especie = ?";

    String UPDATE_DOMINIO = "UPDATE FROM biologia.dominio where id_dominio = ?;";
    String UPDATE_FILO = "UPDATE FROM biologia.dominio where id_dominio = ?;";
    String UPDATE_CLASE = "UPDATE FROM biologia.dominio where id_dominio = ?;";
    String UPDATE_FAMILIA = "UPDATE FROM biologia.dominio where id_dominio = ?;";
    String UPDATE_ORDEN = "UPDATE FROM biologia.dominio where id_dominio = ?;";
    String UPDATE_GENERO = "UPDATE FROM biologia.dominio where id_dominio = ?;";

    String SELECT_ARBOL = "SELECT d.dominio_name dominio, f.filo_name filo, c.clase_name clase, o.orden_name orden, fam.familia_name familia, g.genero_name genero, e.especie_name especie\n"
            + "FROM nomenclatura n INNER JOIN dominio d ON n.id_dominio=d.id_dominio\n"
            + "INNER JOIN filo f ON n.id_filo=f.id_filo\n"
            + "INNER JOIN clase c ON n.id_clase=c.id_clase\n"
            + "INNER JOIN orden o ON n.id_orden=o.id_orden\n"
            + "INNER JOIN familia fam ON n.id_familia=fam.id_familia\n"
            + "INNER JOIN genero g ON n.id_genero=g.id_genero\n"
            + "INNER JOIN especie e ON n.id_especie=e.id_especie\n"
            + "WHERE e.id_especie = ?;";

    String INSERT_ESPECIE = "INSERT INTO biologia.especie (especie_name, autor, descripcion, metabolismo, ecologia, referencias) VALUES (?,?,?,?,?,?)";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    public static ResultSet executeQuery(String sql, Integer id) throws SQLException {

        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;

    }

    public static ResultSet executeQueryps(String sql, Integer id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public static int executeUpdate(String sql, Integer id) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        int res = ps.executeUpdate();
        connection.commit();

        return res;
    }

    public static int executeUpdate2(String sql, Especie e) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, e.getEspecie_name());
        ps.setString(2, e.getAutor());
        ps.setString(3, e.getDescripcion());
        ps.setString(4, e.getMetabolismo());
        ps.setString(5, e.getEcologia());
        ps.setString(6, e.getReferences());
        ps.setInt(7, e.getId_especie());
        int res = ps.executeUpdate();
        connection.commit();

        return res;
    }
}
