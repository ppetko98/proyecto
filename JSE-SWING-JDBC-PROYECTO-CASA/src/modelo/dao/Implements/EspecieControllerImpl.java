package modelo.dao.Implements;

import com.mysql.jdbc.Connection;
import modelo.dao.EspecieController;
import modelo.entidades.Especie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modelo.excepciones.EspecieException;
import utilidades.BaseDatos;

public class EspecieControllerImpl implements EspecieController {

    public static List<Especie> lista = new ArrayList<>();
    public static Collection<Especie> listacompleta = new ArrayList<>();

   

    @Override
    public List<Especie> lista() throws SQLException {
        if (lista.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ESPECIE);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        int id_especie = rs.getInt("id_especie");
                        String especie_name = rs.getString("especie_name");
                        String genero_name = rs.getString("genero_name");

                        Especie objeto = new Especie(id_especie, especie_name, genero_name);

                        lista.add(objeto);

                    } while (rs.next());

                } else {
                    throw new SQLException("No data available in table");
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        return lista;
    }

    public Collection<Especie> coleccionCompleta() throws SQLException {

        if (listacompleta.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                connection.setAutoCommit(false);
                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ESPECIE);

                ResultSet rs = ps.executeQuery();

                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        int id_especie = rs.getInt("id_especie");
                        String especie_name = rs.getString("especie_name");
                        String genero_name = rs.getString("genero_name");

                        Especie objeto = new Especie(id_especie, especie_name, genero_name);

                        listacompleta.add(objeto);

                    } while (rs.next());

                } else {

                    throw new SQLException("No data available in table");
                }

               
                connection.commit();

            } catch (SQLException e) {

                System.out.println("Error SQL. " + e.getMessage());
            } 

                   }
        return listacompleta;

    }
}

