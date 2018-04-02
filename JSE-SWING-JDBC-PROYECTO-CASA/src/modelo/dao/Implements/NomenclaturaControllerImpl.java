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
       if (listaFilo.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_FILO);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String filo_name = rs.getString("filo_name");

                        Filo objeto = new Filo (filo_name);

                        listaFilo.add(objeto);
                        

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

        return listaFilo;
    }

    @Override
    public List<Clase> listaClase() throws SQLException {
        if (listaClase.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_CLASE);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String clase_name = rs.getString("clase_name");

                        Clase objeto = new Clase (clase_name);

                        listaClase.add(objeto);
                        

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

        return listaClase;
    }

    @Override
    public List<Orden> listaOrden() throws SQLException {
         if (listaO.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ORDEN);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String orden_name = rs.getString("orden_name");

                        Orden objeto = new Orden (orden_name);

                        listaO.add(objeto);
                        

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

        return listaO;
    }

    @Override
    public List<Familia> listaFamilia() throws SQLException {
        if (listaFam.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_FAMILIA);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String familia_name = rs.getString("familia_name");

                        Familia objeto = new Familia (familia_name);

                        listaFam.add(objeto);
                        

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

        return listaFam;
    }

    @Override
    public List<Genero> listaGenero() throws SQLException {
      if (listaG.isEmpty()) {

            Connection connection = null;
            try {

                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_GENERO);

                ResultSet rs = ps.executeQuery();
                Statement st = connection.createStatement();

                if (rs.next()) {
                    do {
                        String genero_name = rs.getString("genero_name");

                        Genero objeto = new Genero (genero_name);

                       listaG.add(objeto);
                        

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

        return listaG;
    }

}