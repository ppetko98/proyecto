/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.BaseDatos;

/**
 *
 * @author ppetk
 */
public class Pruebas {
    public static void main(String[] args) {
        try {
            /*
            File file = new File("");
            String path = System.getProperty("user.dir");
            
            System.out.println(path+"\\src\\testImages\\chromosomebn.png");
            */
            Connection connection = BaseDatos.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(BaseDatos.SELECT_ES_GENOMICO_PLASMIDO);
            if (rs.next()) {
                System.out.println(rs.getString(0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
