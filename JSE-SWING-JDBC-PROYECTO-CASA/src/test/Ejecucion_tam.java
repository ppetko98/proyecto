package test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.dao.Implements.GeneroControllerImpl.listagenero;
import modelo.entidades.Genero;
import modelo.excepciones.EspecieException;

import static utilidades.BaseSwing.crear;
import utilidades.Validacion;
import utilidades.ValidacionException;
//import utilidades.VentanaPrincipal;

/**
 *
 * @author Tamara
 */
public class Ejecucion_tam {

    private final JFrame mainFrame = crear("GESTIÓN DE ESPECIES",
            800, 600, false, true);
    private final JFrame agregarFrame = crear("AÑADIR ESPECIE",
            600, 400, false, true);
    private final JFrame agregarFrame2 = crear("AÑADIR GENERO",
            600, 400, false, true);
    private final JFrame agregarFrame3 = crear("LO QUE SEA",
            600, 400, false, true);
    private final JFrame eliminarFrame = crear("ELIMINAR ESPECIE",
            600, 400, false, true);
    private final JFrame modificarFrame = crear("MODIFICAR ESPECIE",
            600, 400, false, true);
    private final JFrame modificarDatosFrame = crear("MODIFICAR DATOS DE LA ESPECIE SELECIONADA",
            600, 400, false, true);
    private final JFrame nomenclaturaFrame = crear("MODIFICAR CLASIFICACION",
            600, 400, false, true);
    private final JFrame modificarSecuenciaFrame = crear("MODIFICAR GENETICA",
            600, 400, false, true);

    private final JFrame buscarFrame = crear("BUSCAR ESPECIE",
            650, 450, true, true);
    private final List<Especie> especies = EspecieControllerImpl.lista;

    private final Collection<Especie> especiescompletas = EspecieControllerImpl.listacompleta;

    private final String pathImg = System.getProperty("user.dir") + "\\src\\testImages\\";

    private EspecieController controllerEspecie = new EspecieControllerImpl();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejecucion_tam().startup());
        try {
            Class.forName("com.mysql.jdbc.Driver");

            EspecieController controller = new EspecieControllerImpl();
            Collection<Especie> especies = controller.coleccionCompleta();
            for (Especie es : especies) {

                System.err.println(es);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar los driver");
            System.exit(0);
        }
    }

    private void startup() {

        JPanel botones = new JPanel(new GridLayout(5, 0, 25, 25));
        botones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        JPanel contenido = new JPanel(new GridLayout(2, 1, 20, 20));
        contenido.setBorder(BorderFactory.createEmptyBorder(10, 100, 100, 100));
        // titulo
        JLabel titulo = new JLabel("GESTION BASE DE DATOS", JLabel.NORTH_EAST);
        Font auxFont = titulo.getFont();
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));

        //Imagen del logo , por ejemplo 
        ImageIcon logo = new ImageIcon(pathImg + "logo angym.png");

        JLabel imagen = new JLabel(logo);

        // Botones
        ImageIcon crearImagen = new ImageIcon(pathImg + "if_New_file_131897.png");

        ImageIcon editImagen = new ImageIcon(pathImg + "edit.png");

        ImageIcon eliminarImagen = new ImageIcon(pathImg + "if_Trash_empty_71063.png");

        ImageIcon buscarImagen = new ImageIcon(pathImg + "if_Preview_131689.png");

        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");

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
        btnCrear.addActionListener(e -> {
            crearEspecie();
            // Ocultar formulario cuando se pulse el boton de X
            agregarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Mostrar formulario
            agregarFrame.setVisible(true);
        });

        btnEditar.addActionListener(e -> {
            modificarEspecie();
            // Ocultar formulario cuando se pulse el boton de X
            modificarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Mostrar formulario
            modificarFrame.setVisible(true);
            modificarEspecie();
        });

        btnEliminar.addActionListener(ae -> {
            eliminarEspecie();

        });

        btnBuscar.addActionListener((ae) -> {
            buscarEspecie(buscarFrame);

        });

        btnCancelar.addActionListener((ae) -> {
            // Cierra la ventana principal, pero si no lo vamos a usar se quita el boton
            mainFrame.setVisible(false);//Esto lo pone en invisible pero NO cierra el programa

            System.exit(0);//Esto SI cierra el programa
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

    private void eliminarEspecie() {
        JLabel lblSeleccion = new JLabel("SELECCIONE ESPECIE");
        JComboBox<Especie> cmbEspecies = new JComboBox<>();

        ImageIcon eliminarImagen = new ImageIcon(pathImg + "if_Trash_empty_71063.png");
        JButton elimButton = new JButton("ELIMINAR", eliminarImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton cancelButton = new JButton("CANCELAR", cancelarImagen);

        for (Especie e : especiescompletas) {
            cmbEspecies.addItem(e);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50, 50));
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(lblSeleccion);
        centerPanel.add(cmbEspecies);

        southPanel.add(elimButton);
        elimButton.addActionListener((ActionEvent ae) -> {
            Especie e = (Especie) cmbEspecies.getSelectedItem();

            especiescompletas.remove(e);

            cmbEspecies.removeItem(e);
            
          EspecieControllerImpl nuevControllerImpl = new EspecieControllerImpl();  
            try {
                nuevControllerImpl.delete();
            } catch (EspecieException ex) {
                Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        eliminarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        eliminarFrame.setContentPane(eliminarPanel);
        eliminarFrame.setVisible(true);
        //eliminarFrame.setLocationByPlatform(true); ***NO TOCAR SALTA EXCEPCION!***
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

        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

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

            especiescompletas.add(es);

            agregarFrame.setVisible(false);
            crearGenero();
            agregarFrame2.setVisible(true);

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

    private void crearGenero() {
        JLabel lblSeleccion = new JLabel("SELECCIONE GENERO");
        JComboBox<Genero> cmbGenero = new JComboBox<>();

        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton siguenteButton = new JButton("SIGUIENTE", siguienteImagen);

        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton cancelButton = new JButton("CANCELAR", cancelarImagen);

        JPanel inferior = new JPanel();
        inferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Genero g : listagenero) {
            cmbGenero.addItem(g);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50, 50));
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(lblSeleccion);
        centerPanel.add(cmbGenero);

        southPanel.add(siguenteButton);
        siguenteButton.addActionListener(ae -> {
            Genero g = (Genero) cmbGenero.getSelectedItem();

            agregarFrame3.setVisible(true);

        });

        southPanel.add(cancelButton);

        cancelButton.addActionListener(ae -> {
            agregarFrame2.setVisible(false);
        });

        JPanel eliminarPanel = new JPanel(new GridLayout(3, 0, 20, 20));
        eliminarPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        eliminarPanel.add(northPanel, BorderLayout.NORTH);
        eliminarPanel.add(centerPanel, BorderLayout.CENTER);
        eliminarPanel.add(southPanel, BorderLayout.SOUTH);

        agregarFrame.setContentPane(eliminarPanel);
        agregarFrame.setVisible(true);
        agregarFrame.setLocationByPlatform(true);
    }

    private void buscarEspecie(JFrame frame) {
        JPanel buscarPanel = new BuscarPanel();
        frame.add(buscarPanel);
        buscarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        buscarFrame.setVisible(true);
    }

    private void modificarEspecie() {
        JLabel lblSeleccion = new JLabel("SELECCIONE LA ESPECIE QUE DESEA MODIFICAR");
        JComboBox<Especie> cmbEspecies = new JComboBox<>();

        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton siguenteButton = new JButton("SIGUIENTE", siguienteImagen);

        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton cancelButton = new JButton("CANCELAR", cancelarImagen);

        JPanel inferior = new JPanel();
        inferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Especie e : especiescompletas) {
            cmbEspecies.addItem(e);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50, 50));
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(lblSeleccion);
        centerPanel.add(cmbEspecies);

        southPanel.add(siguenteButton);
        siguenteButton.addActionListener(ae -> {
            Especie e = (Especie) cmbEspecies.getSelectedItem();

            modificarDatosEspecie();
            modificarDatosFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            modificarDatosFrame.setVisible(true);

        });

        southPanel.add(cancelButton);

        cancelButton.addActionListener(ae -> {
            modificarFrame.setVisible(false);
        });

        JPanel eliminarPanel = new JPanel(new GridLayout(3, 0, 20, 20));
        eliminarPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        eliminarPanel.add(northPanel, BorderLayout.NORTH);
        eliminarPanel.add(centerPanel, BorderLayout.CENTER);
        eliminarPanel.add(southPanel, BorderLayout.SOUTH);

        modificarFrame.setContentPane(eliminarPanel);
        modificarFrame.setVisible(true);
        modificarFrame.setLocationByPlatform(false);

    }

    private void modificarDatosEspecie() {

        JTextField txtNombre = new JTextField(JTextField.LEFT);
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

        ImageIcon prevImagen = new ImageIcon(pathImg + "if_pre_293277.png");
        JButton buttonprev = new JButton("ANTERIOR", prevImagen);
        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

        JPanel inferior = new JPanel();
        inferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inferior.add(buttonprev);
        buttonprev.addActionListener(ae -> {

            modificarDatosFrame.setVisible(false);
            modificarFrame.setVisible(true);

        });

        inferior.add(buttonOK);
        buttonOK.addActionListener(ae -> {
            inferior.add(buttonOK);

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

            especiescompletas.add(es);
            nomenclaturaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            nomenclaturaFrame.setVisible(true);

        });
        inferior.add(buttonKO);
        buttonKO.addActionListener(ae -> {
            modificarFrame.setVisible(true);
        });
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        inferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        datos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 150));

        panel.add(inferior, BorderLayout.SOUTH);
        panel.add(datos, BorderLayout.CENTER);

        modificarDatosFrame.setContentPane(panel);
    }
}