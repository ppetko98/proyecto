package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;

import java.util.List;
import modelo.entidades.Genetica;
import utilidades.BaseDatos;

/**
 *
 * @author Tamara
 */
public interface EspecieController {

   
    List<Especie> lista() throws SQLException;

    Collection<Especie> coleccionCompleta() throws SQLException;
    
    List<Genetica> listaGenetica() throws SQLException;

    static void delete(Especie e) throws EspecieException, SQLException {
        int id = e.getId_especie();
        BaseDatos.executeUpdate(BaseDatos.DELETE_ESPECIE, id);
    }

    static void update(Especie e) throws EspecieException, SQLException {
        int id = e.getId_especie();
        BaseDatos.executeUpdate(BaseDatos.UPDATE_ESPECIE, id);
    }
    
    static int crearEspecie(Especie e) throws  EspecieException, SQLException{
        
        Connection conexion = BaseDatos.getConnection();
        
        PreparedStatement consulta_a_realizar= conexion.prepareStatement(
        "INSERT INTO biologia.especie (especie_name, autor, descripcion, metabolismo, ecologia, referencias) VALUES (?,?,?,?,?,?)");
        
        consulta_a_realizar.setString(1, e.getEspecie_name());
        consulta_a_realizar.setString(2, e.getAutor());
        consulta_a_realizar.setString(3, e.getDescripcion());
        consulta_a_realizar.setString(4, e.getMetabolismo());
        consulta_a_realizar.setString(5, e.getEcologia());
        consulta_a_realizar.setString(6, e.getReferences());
        
        int resultadoOperacion = consulta_a_realizar.executeUpdate();
        
        return resultadoOperacion;
        
    }
}