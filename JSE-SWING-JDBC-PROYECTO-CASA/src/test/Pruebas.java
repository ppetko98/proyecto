/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Dimension;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import utilidades.BaseDatos;
import utilidades.BaseSwing;

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
            PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_TABLA);
            ps.setInt(1, 4);
            ResultSet rs = ps.executeQuery();
            String obj = "";
            if (rs.next()) {
                //System.out.println("Columna 1"+rs.getString(1)+"\nColumna 2"+rs.getString(2)+"\nColumna 3"+rs.getString(3).substring(0, 50));
                obj = rs.getString(1);
                scrollPanel(obj, true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void scrollPanel(String information, boolean resizable) {
        JFrame frame = new JFrame();
        JTextArea text = new JTextArea(information);
        frame.add(new JScrollPane(text));
        frame.setPreferredSize(new Dimension(400, 600));
        frame.setResizable(resizable);
        frame.setVisible(true);
    }
}
