package src.test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.modelo.excepciones.EspecieException;

import static src.utilidades.BaseSwing.crear;
import utilidades.VentanaPrincipal;

/**
 *
 * @author Tamara
 */
public class Ejecucion {

    private final JFrame mainFrame = crear("GESTIÓN DE ESPECIES",
            800, 600, false, true);
    private final JFrame eliminarFrame = crear("ELIMINAR ESPECIE",
            600, 400, false, true);

    private final List<Especie> especies = EspecieControllerImpl.lista;

    private EspecieController controllerEspecie = new EspecieControllerImpl();

    public static void main(String[] args) throws EspecieException {
        SwingUtilities.invokeLater(() -> new Ejecucion().startup());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar los driver");
            System.exit(0);
        }
        try {
            EspecieController controller = new EspecieControllerImpl();
            List<Especie> especies = controller.lista();
            for (Especie es : especies) {

                System.err.println(es);
            }

        } catch (EspecieException e) {
            System.err.println(e.getMessage());
        }
    }

    private void startup() {
        JPanel botones = new JPanel(new GridLayout(5, 0, 25, 25));
        botones.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
        JPanel contenido = new JPanel(new GridLayout(2, 1, 20, 20));
        contenido.setBorder(BorderFactory.createEmptyBorder(10,100, 100, 100));
        // titulo
        JLabel titulo = new JLabel("GESTION BASE DE DATOS", JLabel.NORTH_EAST);
        Font auxFont=titulo.getFont(); 
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        
        //Imagen del logo , por ejemplo 
        ImageIcon logo = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\logo angym.png");
        JLabel imagen = new JLabel(logo);
        
        
        // Botones
        ImageIcon crearImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_New_file_131897.png");
        ImageIcon editImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\edit.png");
        ImageIcon eliminarImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_Trash_empty_71063.png");
        ImageIcon buscarImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_Preview_131689.png");
        ImageIcon cancelarImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_Cancel_131742.png");

        JButton btnCrear = new JButton("AÑADIR", crearImagen);
        JButton btnEditar = new JButton("MODIFICAR", editImagen);
        JButton btnEliminar = new JButton("ELIMINAR", eliminarImagen);
        JButton btnBuscar = new JButton("BUSCAR", buscarImagen);
        JButton btnCancelar = new JButton("CANCELAR", cancelarImagen);

        // Añadir botones 
        botones.add(btnCrear);
        botones.add(btnEditar);
        botones.add(btnEliminar);
        botones.add(btnBuscar);
        botones.add(btnCancelar);

        //Action Listener
        btnEliminar.addActionListener(ae -> {
            try {
                eliminarEspecie();
            } catch (EspecieException ex) {
                Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Vista
        JPanel mainPanel = new JPanel(new BorderLayout(40, 40));
        //mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 30, 30));

        mainPanel.add(botones, BorderLayout.WEST);
        mainPanel.add(contenido, BorderLayout.EAST);

        contenido.add(titulo, BorderLayout.NORTH);
        contenido.add(imagen, BorderLayout.WEST);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void eliminarEspecie() throws EspecieException {
        JLabel lblSeleccion = new JLabel("SELECCIONA ESPECIE");
        JComboBox<Especie> cmbEspecies = new JComboBox<>();
        ImageIcon eliminarImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_Trash_empty_71063.png");
        JButton elimButton = new JButton("ELIMINAR", eliminarImagen);
        ImageIcon cancelarImagen = new ImageIcon("C:\\Users\\Tamara\\Documents\\programación\\repositorio_proyecto_programacion\\proyecto\\JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\if_Cancel_131742.png");
        JButton cancelButton = new JButton("CANCELAR", cancelarImagen);

        for (Especie e : especies) {
            cmbEspecies.addItem(e);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50, 50));
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(lblSeleccion);
        centerPanel.add(cmbEspecies);

        southPanel.add(elimButton);
        elimButton.addActionListener(ae -> {
            Especie e = (Especie) cmbEspecies.getSelectedItem();

            especies.remove(e);

            cmbEspecies.removeItem(e);

            eliminarFrame.setVisible(false);

            JOptionPane.showMessageDialog(null, "Se ha eliminado la especie seleccionada");
        });

        southPanel.add(cancelButton);

        cancelButton.addActionListener(ae -> {
            eliminarFrame.setVisible(false);
        });

        JPanel eliminarPanel = new JPanel(new GridLayout(3, 0, 20, 20));
        eliminarPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        eliminarPanel.add(northPanel, BorderLayout.NORTH);
        eliminarPanel.add(centerPanel, BorderLayout.CENTER);
        eliminarPanel.add(southPanel, BorderLayout.SOUTH);

        eliminarFrame.setContentPane(eliminarPanel);
        eliminarFrame.setVisible(true);
        eliminarFrame.setLocationByPlatform(true);
        eliminarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

}
