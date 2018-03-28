/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.Implements;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.GeneroController;

import modelo.entidades.Genero;
import utilidades.BaseDatos;

/**
 *
 * @author Tuka Manel
 */
public class GeneroControllerImpl implements GeneroController{
    public static List<Genero> listagenero = new ArrayList<>();

    @Override
    public List<Genero> listagenero() throws SQLException {
        
          if (listagenero.isEmpty()) {

            Connection connection = null;
 try {
                
                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ESPECIE);

                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    do {
                        int id_genero = rs.getInt("id_genero");
                      
                        String genero_name = rs.getString("genero_name");

                        Genero objeto = new Genero(id_genero, genero_name);

                        listagenero().add(objeto);

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

        return listagenero;
    }
    
    
}
