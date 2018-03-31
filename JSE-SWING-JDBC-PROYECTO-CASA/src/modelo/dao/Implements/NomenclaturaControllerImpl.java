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
import modelo.dao.NomenclaturaController;
import modelo.entidades.Clase;
import modelo.entidades.Dominio;
import modelo.entidades.Familia;
import modelo.entidades.Filo;
import modelo.entidades.Genero;
import modelo.entidades.Orden;
import modelo.excepciones.EspecieException;
import utilidades.BaseDatos;

public class NomenclaturaControllerImpl implements NomenclaturaController {

    public static List<Dominio> listaDominio = new ArrayList<>();
    public static List<Filo> listaFilo = new ArrayList<>();
     public static List<Clase> listaClase = new ArrayList<>();
      public static List<Familia> listaFam = new ArrayList<>();
       public static List<Orden> listaO = new ArrayList<>();
        public static List<Genero> listaG = new ArrayList<>();

   

   
    @Override
    public List<Dominio> listaDominio() throws SQLException {
        if (listaDominio.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_DOMINIO);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String dominio_name = rs.getString("dominio_name");

                        Dominio objeto = new Dominio (dominio_name);

                        listaDominio.add(objeto);

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

        return listaDominio;
    }

    @Override
    public List<Filo> listaFilo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clase> listaClase() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orden> listaOrden() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Familia> listaFamilia() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genero> listaGenero() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}