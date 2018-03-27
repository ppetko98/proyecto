package test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.modelo.excepciones.EspecieException;

import static utilidades.BaseSwing.crear;
import utilidades.Validacion;
import utilidades.ValidacionException;
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
     private final JFrame agregarFrame = crear("AÑADIR ESPECIE",
            600, 400, false, true);
    private final List<Especie> especies = EspecieControllerImpl.lista;
    
    private final String pathImg = System.getProperty("user.dir")+"\\src\\testImages\\";


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
        botones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        JPanel contenido = new JPanel(new GridLayout(2, 1, 20, 20));
        contenido.setBorder(BorderFactory.createEmptyBorder(10 ,100, 100, 100));
        // titulo
        JLabel titulo = new JLabel("GESTION BASE DE DATOS", JLabel.NORTH_EAST);
        Font auxFont=titulo.getFont(); 
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        
        //Imagen del logo , por ejemplo 
        ImageIcon logo = new ImageIcon(pathImg+"logo angym.png");
        
        /*
        "C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA\\src\\testImages\\logo angym.png"
        */
        JLabel imagen = new JLabel(logo);
        
        
        // Botones
        ImageIcon crearImagen = new ImageIcon(pathImg+"if_New_file_131897.png");
        
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
        
        ImageIcon editImagen = new ImageIcon(pathImg+"edit.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
        ImageIcon eliminarImagen = new ImageIcon(pathImg+"if_Trash_empty_71063.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
        ImageIcon buscarImagen = new ImageIcon(pathImg+"if_Preview_131689.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
        ImageIcon cancelarImagen = new ImageIcon(pathImg+"if_Cancel_131742.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
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
         btnCrear.addActionListener(e -> {
            crearEspecie();
             // Ocultar formulario cuando se pulse el boton de X
            agregarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Mostrar formulario
            agregarFrame.setVisible(true);
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
        ImageIcon eliminarImagen = new ImageIcon(pathImg+"if_Trash_empty_71063.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
        JButton elimButton = new JButton("ELIMINAR", eliminarImagen);
        
        ImageIcon cancelarImagen = new ImageIcon(pathImg+"if_Cancel_131742.png");
        /*
        C:\\Users\\Tamara\\Documents\\"
                + "programación\\repositorio_proyecto_programacion\\proyecto\\"
                + "JSE-SWING-JDBC-PROYECTO-CASA
        */
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
     private void crearEspecie() {

        JTextField txtNombre = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtDecripcion = new JTextField();
        JTextField txtMetabolismo = new JTextField();
        JTextField txtEcologia = new JTextField();
        JTextField txtReferences = new JTextField();

        JLabel lblNombre = new JLabel("NOMBRE", JLabel.RIGHT);
        JLabel lblAutor = new JLabel("AUTOR", JLabel.RIGHT);
        JLabel lblDescripcion = new JLabel("DESCRIPCION", JLabel.RIGHT);
        JLabel lblMetabolismo = new JLabel("METABOLISMO", JLabel.RIGHT);
        JLabel lblEcologia = new JLabel("ECOLOGIA", JLabel.RIGHT);
        JLabel lblReferences = new JLabel("REFERENCES", JLabel.RIGHT);

        JPanel datos = new JPanel();
        datos.setLayout(new GridLayout(6, 0, 40, 15));
        datos.add(lblNombre);
        datos.add(txtNombre);
        datos.add(lblAutor);
        datos.add(txtAutor);
        datos.add(lblDescripcion);
        datos.add(txtDecripcion);
        datos.add(lblMetabolismo);
        datos.add(txtMetabolismo);
        datos.add(lblEcologia);
        datos.add(txtEcologia);
        datos.add(lblReferences);
        datos.add(txtReferences);

        JButton buttonOK = new JButton("SIGUIENTE");
        JButton buttonKO = new JButton("CANCELAR");

        JPanel inferior = new JPanel();
        inferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inferior.add(buttonOK);
        buttonOK.addActionListener(ae -> {
            try {

                Validacion.validarCadena(txtNombre, true, "Nombre");
                Validacion.validarCadena(txtAutor, true, "Autor");
                Validacion.validarCadena(txtDecripcion, true, "Descripcion");
                Validacion.validarCadena(txtMetabolismo, true, "Metabolismo");
                Validacion.validarCadena(txtEcologia, true, "Ecologia");
                Validacion.validarCadena(txtReferences, true, "References");

            } catch (ValidacionException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String nombre = txtNombre.getText();
            String autor = txtAutor.getText();
            String descripcion = txtDecripcion.getText();
            String metabolismo = txtMetabolismo.getText();
            String ecologia = txtEcologia.getText();
            String references = txtReferences.getText();

            Especie es = new Especie(nombre, autor, descripcion, metabolismo,
                    ecologia, references);

            especies.add(es);

            agregarFrame.setVisible(false);

            JOptionPane.showMessageDialog(null, "Se ha creado una nueva especie");

        });
        inferior.add(buttonKO);
        buttonKO.addActionListener(ae -> {
            agregarFrame.setVisible(false);
        });
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(inferior, BorderLayout.SOUTH);
        panel.add(datos, BorderLayout.CENTER);

        agregarFrame.setContentPane(panel);
    }

}
