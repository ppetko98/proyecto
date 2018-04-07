package test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import modelo.dao.Implements.NomenclaturaControllerImpl;
import modelo.dao.NomenclaturaController;
import modelo.entidades.Clase;
import modelo.entidades.Dominio;
import modelo.entidades.Familia;
import modelo.entidades.Filo;
import modelo.entidades.Genero;
import modelo.entidades.Orden;
import modelo.excepciones.EspecieException;
import static utilidades.BaseDatos.URL;

import static utilidades.BaseSwing.crear;
import utilidades.Validacion;
import utilidades.ValidacionException;
//import utilidades.VentanaPrincipal;

/**
 *
 * @author Tamara
 */
public class Pruebas_diseño extends JFrame{

    public Image imagenFondo;
    public URL fondo;
    Panel p;

    public Pruebas_diseño() {
        this.setBounds(0,0,850,600);
        this.setTitle("GESTIÓN BASE DE DATOS");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        fondo = this.getClass().getResource("src/testImages/fondo swing.jpg");
        imagenFondo= new ImageIcon(fondo).getImage();
        
        Container contenedor = getContentPane();
        contenedor.add(p);
    }
    
   /* public JPanel panel = new JPanel(){
    g.drawImage(imagenFondo,0,0,getWidth(), getHeight(),this);
    public void paintComponent(Graphics q){
        g.drawImage(imagenFondo, 0,0,getWidth(), getHeight(),this);
    }
    };*/
    
    
    
   
    
    

    private final String pathImg = System.getProperty("user.dir") + "\\src\\testImages\\";

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pruebas_diseño().startup());
    }
    private void startup() {

       
        ImageIcon logo = new ImageIcon(pathImg + "fondo swing.jpg");

        JLabel imagen = new JLabel(logo);

        

        



    }
}

    
