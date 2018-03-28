package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface BaseDatos {
 

	/*
	 * Constantes utilizadas en el ejemplo
	 */
	String DRIVERS = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/biologia";
	String USUARIO = "root";
	String CLAVE = "root";


	String SELECT_ESPECIE =                          
               
        "SELECT e.id_especie, g.genero_name, e.especie_name\n"
                        + "FROM nomenclatura n INNER JOIN genero g \n"
                        + "ON n.id_genero = g.id_genero\n"
                        + "INNER JOIN especie e\n"
                        + "ON n.id_especie = e.id_especie";
                
        String DELETE_ESPECIE = "DELETE e.id_especie, e.especie_name, e.autor, e.descripcion, e.imagen, e.ecologia, e.metabolismo, e.references, e.id_secuencia,\n" +
"g.id_secuencia, g.es_genomico_plasmido, g.fasta, g.topologia, g.longitud, g.last_update,\n" +
"n.id_clase, n.id_dominio, n.id_especie, n.id_familia, n.id_filo, n.id_genero, n.id_orden\n" +
"FROM especie e\n" +
"INNER JOIN nomenclatura n \n" +
"ON e.id_especie = n.id_especie\n" +
"INNER JOIN genetica g\n" +
"ON e.id_secuencia = g.id_secuencia";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, CLAVE);
	}

}
