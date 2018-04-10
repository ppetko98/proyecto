package test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import modelo.dao.Implements.NomenclaturaControllerImpl;
import modelo.dao.NomenclaturaController;
import modelo.entidades.Clase;
import modelo.entidades.Dominio;
import modelo.entidades.Familia;
import modelo.entidades.Filo;
import modelo.entidades.Genero;
import modelo.entidades.Orden;

import static utilidades.BaseSwing.crear;
import utilidades.Validacion;
import utilidades.ValidacionException;
import vista.Fondo;

/**
 *
 * @author Tamara
 * @author Tuka
 * @author Petko
 *
 */
public class Ejecucion {

    private Especie es=null;
    
    private final JFrame mainFrame = crear("GESTIÓN DE ESPECIES",
            850, 600, false, true);
    private final JFrame agregarFrame = crear("AÑADIR ESPECIE",
            600, 400, false, true);
    private final JFrame agregarFrame2 = crear("AÑADIR DATOS",
            600, 400, false, true);
    private final JFrame agregarFrame3 = crear("AÑADIR DATOS 2",600, 400, false, true);
    private final JFrame eliminarFrame = crear("ELIMINAR ESPECIE",
            600, 400, false, true);
    private final JFrame modificarFrame = crear("MODIFICAR ESPECIE",
            850, 600, false, true);
    private final JFrame modificarDatosFrame = crear("MODIFICAR DATOS DE LA ESPECIE SELECIONADA",
            850, 600, false, true);
  private final JFrame imagenFrame = crear("MODIFICAR DATOS DE LA ESPECIE SELECIONADA",
            850, 400, false, true);
    private final JFrame fastaFrame = crear("MODIFICAR DATOS DE LA ESPECIE SELECIONADA",
            850, 400, false, true);

    private final JFrame nomenclaturaFrame = crear("MODIFICAR CLASIFICACION",
            850, 600, false, true);

    private JFrame buscarFrame = null;
    private final List<Especie> especies = EspecieControllerImpl.lista;

    private final List<Dominio> dominios = NomenclaturaControllerImpl.listaDominio;
    private final List<Filo> filos = NomenclaturaControllerImpl.listaFilo;
    private final List<Clase> clases = NomenclaturaControllerImpl.listaClase;
    private final List<Familia> familias = NomenclaturaControllerImpl.listaFam;
    private final List<Orden> ordenes = NomenclaturaControllerImpl.listaO;
    private final List<Genero> generos = NomenclaturaControllerImpl.listaG;

    private Collection<Especie> especiescompletas = EspecieControllerImpl.listacompleta;

    private final String pathImg = System.getProperty("user.dir") + "\\src\\testImages\\";

    //private EspecieController controllerEspecie = new EspecieControllerImpl();
    //private NomenclaturaController controllerNomenclatura = new NomenclaturaControllerImpl();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejecucion().startup());
        try {
            Class.forName("com.mysql.jdbc.Driver");

            EspecieController econtroller = new EspecieControllerImpl();
            List<Especie> especies = econtroller.lista();
            /*for (Especie e : especies) {
             System.err.println();
             }
                        
             Era esto lo que imprimia todo en rojo */

            EspecieController controller = new EspecieControllerImpl();
            Collection<Especie> especies2 = controller.coleccionCompleta();

            NomenclaturaController ncontroller = new NomenclaturaControllerImpl();
            List<Dominio> dominios = ncontroller.listaDominio();

            NomenclaturaController filcontroller = new NomenclaturaControllerImpl();
            List<Filo> filos = filcontroller.listaFilo();

            NomenclaturaController clascontroller = new NomenclaturaControllerImpl();
            List<Clase> clases = clascontroller.listaClase();

            NomenclaturaController fcontroller = new NomenclaturaControllerImpl();
            List<Familia> familias = fcontroller.listaFamilia();

            NomenclaturaController ocontroller = new NomenclaturaControllerImpl();
            List<Orden> ordenes = ocontroller.listaOrden();

            NomenclaturaController gcontroller = new NomenclaturaControllerImpl();
            List<Genero> generos = gcontroller.listaGenero();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar los driver");
            System.exit(0);
        }
    }

    private void startup() {
        //Dejo comentao esto por si al final no os gusta lo del fondo 
        JPanel botones = new JPanel(new GridLayout(5, 0, 30, 30));
        botones.setOpaque(false);
        botones.setBorder(BorderFactory.createEmptyBorder(20, 1, 10, 10));
        //JPanel contenido = new JPanel(new GridLayout(2, 1, 20, 20));
        //contenido.setBorder(BorderFactory.createEmptyBorder(10, 100, 100, 100));
        // titulo
        //JLabel titulo = new JLabel("GESTION BASE DE DATOS", JLabel.NORTH_EAST);
        //Font auxFont = titulo.getFont();
        //titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));

        //Imagen del logo , por ejemplo 
        // ImageIcon logo = new ImageIcon(pathImg + "Imagene1.png");
        //JLabel imagen = new JLabel(logo);
        // Botones
        ImageIcon crearImagen = new ImageIcon(pathImg + "addBBDD.png");

        ImageIcon editImagen = new ImageIcon(pathImg + "editAM.png");

        ImageIcon eliminarImagen = new ImageIcon(pathImg + "if_Delete_Database_65997.png");

        ImageIcon buscarImagen = new ImageIcon(pathImg + "Find_bacteria.png");

        ImageIcon cancelarImagen = new ImageIcon(pathImg + "newClose.png");

        /*Por si queremos cambiar la posicion del texto en el boton
         btnCrear.setHorizontalTextPosition(JButton.CENTER);
         btnCrear.setVerticalTextPosition(JButton.BOTTOM);*/
        JButton btnCrear = new JButton("", crearImagen);
        btnCrear.setBorderPainted(false);
        btnCrear.setContentAreaFilled(false);
        JButton btnEditar = new JButton("", editImagen);
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        JButton btnEliminar = new JButton("", eliminarImagen);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        JButton btnBuscar = new JButton("", buscarImagen);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        JButton btnCancelar = new JButton("", cancelarImagen);

        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);

        // Añadir botones 
        //Action Listener
        btnCrear.addActionListener(e -> {
            crearEspecie();
            // Ocultar formulario cuando se pulse el boton de X
            agregarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            //agregarFrame.setLocationRelativeTo(null);
            // Mostrar formulario
            agregarFrame.setVisible(true);
        });

        btnEditar.addActionListener(e -> {
            modificarDatosEspecie();
            // Ocultar formulario cuando se pulse el boton de X
            modificarDatosFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Mostrar formulario
            modificarDatosFrame.setVisible(true);
            modificarDatosEspecie();
        });

        btnEliminar.addActionListener(ae -> {
            eliminarEspecie();

        });

        btnBuscar.addActionListener((ae) -> {
            buscarFrame = crear("BUSCAR ESPECIE",
                    760, 450, true, true);
            JPanel buscarPanel = new BuscarPanel();
            buscarEspecie(buscarPanel);
        });

        btnCancelar.addActionListener((ae) -> {
            // Cierra la ventana principal, pero si no lo vamos a usar se quita el boton
            mainFrame.setVisible(false);//Esto lo pone en invisible pero NO cierra el programa

            System.exit(0);//Esto SI cierra el programa
        });

        //Vista
        //JPanel fondo = new JPanel(new BorderLayout(40, 40));
        //mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 30, 30));
        Fondo mainPanel = new Fondo();
        mainPanel.setOpaque(false);
        mainPanel.setBackground(pathImg + "Imagene1.png");
        //pathImage,"testImages/Imagene.png");

        botones.add(btnCrear);
        botones.add(btnEditar, BorderLayout.EAST);
        botones.add(btnEliminar, BorderLayout.EAST);
        botones.add(btnBuscar, BorderLayout.EAST);
        botones.add(btnCancelar, BorderLayout.EAST);
        mainPanel.add(botones, BorderLayout.WEST);

        //mainPanel.add(contenido, BorderLayout.EAST);
        //contenido.add(titulo, BorderLayout.NORTH);
        //contenido.add(imagen, BorderLayout.WEST);
        mainFrame.setContentPane(mainPanel);
        //mainFrame.setLocationByPlatform(true);
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
        elimButton.addActionListener((ActionEvent ae) -> {
            Especie e = (Especie) cmbEspecies.getSelectedItem();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar " + e + "?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                especies.remove(e);

                cmbEspecies.removeItem(e);

                //EspecieController.delete(e);
                //EspecieControllerImpl nuevControllerImpl = new EspecieControllerImpl();
                try {
                    EspecieController.delete(e);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            eliminarFrame.setVisible(false);

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
        ImageIcon FotoImagen = new ImageIcon(pathImg + "if_image-x-generic_118887.png");
        JButton buttonImagen = new JButton("IMAGEN", FotoImagen);
        buttonImagen.setPreferredSize(new Dimension(120, 60));
        ImageIcon ADNImagen = new ImageIcon(pathImg + "if_medical_icon_10_1290983.png");
        JButton buttonFasta = new JButton("FASTA", ADNImagen);
        buttonFasta.setPreferredSize(new Dimension(120, 60));

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

            this.es = new Especie(nombre, autor, descripcion, metabolismo,
                    ecologia, references);

            especies.add(es);

            agregarFrame.setVisible(false);

            agregarFrame.setVisible(true);
            crearDatos();
        });
        inferior.add(buttonKO);

        JPanel botonesextraPanel = new JPanel();
        botonesextraPanel.setLayout(new GridLayout(2, 0, 10, 15));
        buttonImagen.addActionListener(e -> {
            String currentDirectory = System.getProperty("user.home") + "\\Documents\\";
            JFileChooser chImangen = new JFileChooser(currentDirectory);
            JFrame añadirImagen = imagenFrame;
            añadirImagen.add(chImangen);

            chImangen.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    boolean is = false;

                    if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")
                            || file.isDirectory()) {
                        is = true;
                    }
                    return is;
                }

                @Override
                public String getDescription() {
                    return "Archivo de Imagen";
                }
            });

            chImangen.setDialogTitle("Seleccionar imagen");
            int returnValue = chImangen.showOpenDialog(chImangen.getParent());
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedFilePath = chImangen.getSelectedFile().getAbsolutePath();
                String extension = selectedFilePath.substring(selectedFilePath.length() - 4, selectedFilePath.length());
                File saveFile = new File(System.getProperty("user.dir") + "\\src\\testImages\\" + txtNombre.getText() + extension);
                File imagen = new File(chImangen.getSelectedFile().getAbsolutePath());

                int res = guardarArchivo(chImangen.getSelectedFile(), saveFile);
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                } else {
                    System.out.println("No se ha cargado correctamente");
                }
            }
            añadirImagen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
        botonesextraPanel.add(buttonImagen);

        buttonFasta.addActionListener(e -> {
            String currentDirectory = System.getProperty("user.home") + "\\Documents\\";
            JFileChooser chSecuencia = new JFileChooser(currentDirectory);
            JFrame añadirFasta = fastaFrame;
            añadirFasta.add(chSecuencia);

            chSecuencia.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    boolean is = false;
                    if (file.getName().endsWith(".txt") || file.isDirectory()) {
                        is = true;
                    }
                    return is;
                }

                @Override
                public String getDescription() {
                    return ".txt";
                }
            });

            chSecuencia.setDialogTitle("Cargar Fasta");
            int returnValue = chSecuencia.showOpenDialog(chSecuencia.getParent());
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedFilePath = chSecuencia.getSelectedFile().getAbsolutePath();
                String extension = selectedFilePath.substring(selectedFilePath.length() - 4, selectedFilePath.length());
                File saveFile = new File(System.getProperty("user.dir") + "\\src\\fasta\\" + txtNombre.getText() + extension);
                int res = guardarArchivo(chSecuencia.getSelectedFile(), saveFile);
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                } else {
                    System.out.println("No se ha cargado correctamente");
                }
            }
            añadirFasta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });

        botonesextraPanel.add(buttonFasta);

        buttonKO.addActionListener(ae -> {
            agregarFrame.setVisible(false);
        });
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        botonesextraPanel.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 1));

        panel.add(inferior, BorderLayout.SOUTH);
        panel.add(datos, BorderLayout.CENTER);

        panel.add(botonesextraPanel, BorderLayout.WEST);
        agregarFrame.setContentPane(panel);
    }

    private int guardarArchivo(File in, File out) {
        int res = 0;
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "utf-8"));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
            bw.write(br.readLine());
        } catch (IOException e) {
            System.out.println(">" + e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (out.canRead()) {
            res = 1;
        }
        return res;
    }

    private void crearDatos() {

        JLabel lblSeleccion = new JLabel("SELECCIONE LOS DATOS QUE DESEA");

        JComboBox<Dominio> cmbDominios = new JComboBox<>();
        JComboBox<Clase> cmbClases = new JComboBox<>();
        JComboBox<Genero> cmbGeneros = new JComboBox<>();

        JLabel lblDominio = new JLabel("DOMINIO", JLabel.CENTER);
        JLabel lblClase = new JLabel("CLASE", JLabel.CENTER);
        JLabel lblGenero = new JLabel("GENERO", JLabel.CENTER);

        ImageIcon prevImagen = new ImageIcon(pathImg + "if_pre_293277.png");
        JButton buttonprev = new JButton("ANTERIOR", prevImagen);
        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

        for (Dominio d : dominios) {
            cmbDominios.addItem(d);
        }
        for (Clase c : clases) {
            cmbClases.addItem(c);
        }
        for (Genero g : generos) {
            cmbGeneros.addItem(g);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 20, 20));
        JPanel centerRPanel = new JPanel();
        centerRPanel.setLayout(new GridLayout(3, 0, 1, 60));
        centerRPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 30));

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northPanel.add(lblSeleccion);

        centerRPanel.add(lblDominio);
        centerRPanel.add(cmbDominios);
        centerRPanel.add(lblClase);
        centerRPanel.add(cmbClases);
        centerRPanel.add(lblGenero);
        centerRPanel.add(cmbGeneros);

//BOnton anterior
        buttonprev.addActionListener(ae -> {
            agregarFrame.setVisible(true);
            agregarFrame2.setVisible(false);
        });
        southPanel.add(buttonprev);

//BOnton siguiente
        buttonOK.addActionListener(ae -> {
            Dominio d = (Dominio) cmbDominios.getSelectedItem();
            Clase c = (Clase) cmbClases.getSelectedItem();
            Genero g = (Genero) cmbGeneros.getSelectedItem();
            agregarFrame3.setVisible(true);
            crearDatos2();
        });
        southPanel.add(buttonOK);

//Boton cancelar
        buttonKO.addActionListener((ActionEvent ae) -> {
            agregarFrame2.setVisible(false);
        });
        southPanel.add(buttonKO);

        JPanel CrearClasPanel = new JPanel(new BorderLayout(10, 10));
        CrearClasPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 50));

        CrearClasPanel.add(northPanel, BorderLayout.NORTH);
        CrearClasPanel.add(centerRPanel, BorderLayout.CENTER);
        CrearClasPanel.add(southPanel, BorderLayout.SOUTH);

        agregarFrame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        agregarFrame2.setContentPane(CrearClasPanel);
        agregarFrame2.setVisible(true);

    }

    private void crearDatos2() {

        JLabel lblSeleccion = new JLabel("SELECCIONE LOS DATOS QUE DESEA");

        JLabel lblFilo = new JLabel("FILO", JLabel.CENTER);
        JLabel lblFamilia = new JLabel("FAMILIA", JLabel.CENTER);
        JLabel lblOrden = new JLabel("ORDEN", JLabel.CENTER);

        JComboBox<Filo> cmbFilos = new JComboBox<>();
        JComboBox<Familia> cmbFamilias = new JComboBox<>();
        JComboBox<Orden> cmbOrdenes = new JComboBox<>();

        ImageIcon prevImagen = new ImageIcon(pathImg + "if_pre_293277.png");
        JButton buttonprev = new JButton("ANTERIOR", prevImagen);
        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

        for (Filo f : filos) {
            cmbFilos.addItem(f);
        }
        for (Familia fa : familias) {
            cmbFamilias.addItem(fa);
        }
        for (Orden o : ordenes) {
            cmbOrdenes.addItem(o);
        }
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 20, 20));
        JPanel centerLPanel = new JPanel();
        centerLPanel.setLayout(new GridLayout(3, 0, 2, 40));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northPanel.add(lblSeleccion);
        centerLPanel.add(lblFilo);
        centerLPanel.add(cmbFilos);
        centerLPanel.add(lblFamilia);
        centerLPanel.add(cmbFamilias);
        centerLPanel.add(lblOrden);
        centerLPanel.add(cmbOrdenes);

        //BOnton anterior
        southPanel.add(buttonprev);
        buttonprev.addActionListener(ae -> {
            agregarFrame2.setVisible(true);
            agregarFrame3.setVisible(false);
        });

        //Boton cancelar
        buttonKO.addActionListener((ActionEvent ae) -> {
            agregarFrame3.setVisible(false);

        });
        southPanel.add(buttonKO);

        buttonOK.addActionListener(ae -> {
            Filo f = (Filo) cmbFilos.getSelectedItem();
            Familia fa = (Familia) cmbFamilias.getSelectedItem();
            Orden o = (Orden) cmbOrdenes.getSelectedItem();         
            
            try {
                EspecieController controllerEspecie = new EspecieControllerImpl();
                Especie añadida = this.es;
                if (EspecieController.crearEspecie(this.es)>0) {
                      JOptionPane.showMessageDialog(null, "Especie creada correctamente");
                } else {
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage());
            }
              agregarFrame3.setVisible(false);
              agregarFrame2.setVisible(false);
              agregarFrame.setVisible(false);
        });
        southPanel.add(buttonOK);

        JPanel CrearClasPanel = new JPanel(new BorderLayout(10, 10));
        CrearClasPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 50));

        CrearClasPanel.add(northPanel, BorderLayout.NORTH);
        CrearClasPanel.add(centerLPanel, BorderLayout.CENTER);
        CrearClasPanel.add(southPanel, BorderLayout.SOUTH);

        agregarFrame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        agregarFrame3.setContentPane(CrearClasPanel);
        agregarFrame3.setVisible(true);
    }

    void buscarEspecie(JPanel buscarPanel) {

        //frame.add(buscarPanel);
        buscarFrame.setContentPane(buscarPanel);
        buscarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buscarFrame.setVisible(true);
    }

    private void modificarDatosEspecie() {

        JLabel lblSeleccion = new JLabel("SELECCIONE LA ESPECIE QUE DESEA MODIFICAR");
        JComboBox<Especie> cmbEspecies = new JComboBox<>();

        JTextField txtNombre = new JTextField(JTextField.LEFT);
        JTextField txtAutor = new JTextField();
        JTextField txtDecripcion = new JTextField();
        JTextField txtMetabolismo = new JTextField();
        JTextField txtEcologia = new JTextField();
        JTextField txtReferences = new JTextField();
       

        /*
         Añadir Accion al combo
         programar combobox
         */
        for (Especie e : especiescompletas) {
            cmbEspecies.addItem(e);
        }
        cmbEspecies.setSelectedIndex(0);

        cmbEspecies.addItemListener(new ItemListener() {

            // Recuperar elemento seleccionado
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Especie species = (Especie) ie.getItem();

                for (Especie e : especiescompletas) {

                    txtNombre.setText(e.getEspecie_name());
                    txtAutor.setText(e.getAutor());
                    txtDecripcion.setText(e.getDescripcion());
                    txtMetabolismo.setText(e.getMetabolismo());
                    txtEcologia.setText(e.getEcologia());
                    txtReferences.setText(e.getReferences());
                }
            }
        });

        
 JTextField txtTopologia = new JTextField();
        JTextField txtLongitud = new JTextField();
        JRadioButton buttonGenomico = new JRadioButton("SECUENCIA DE TIPO GENÓMICO", true);

        ImageIcon FotoImagen = new ImageIcon(pathImg + "if_image-x-generic_118887.png");
        JButton buttonImagen = new JButton("IMAGEN", FotoImagen);

        buttonImagen.setPreferredSize(new Dimension(120, 60));
        buttonImagen.addActionListener(e -> {
            
             String currentDirectory = System.getProperty("user.home") + "\\Documents\\";
            JFileChooser chImangen = new JFileChooser(currentDirectory);
            JFrame añadirImagen = imagenFrame;
            añadirImagen.add(chImangen);

            chImangen.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    boolean is = false;

                    if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")
                            || file.isDirectory()) {
                        is = true;
                    }
                    return is;
                }

                @Override
                public String getDescription() {
                    return "Archivo de Imagen";
                }
            });

            chImangen.setDialogTitle("Seleccionar imagen");
            int returnValue = chImangen.showOpenDialog(chImangen.getParent());
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedFilePath = chImangen.getSelectedFile().getAbsolutePath();
                String extension = selectedFilePath.substring(selectedFilePath.length() - 4, selectedFilePath.length());
                File saveFile = new File(System.getProperty("user.dir") + "\\src\\testImages\\" + txtNombre.getText() + extension);
                File imagen = new File(chImangen.getSelectedFile().getAbsolutePath());

                int res = guardarArchivo(chImangen.getSelectedFile(), saveFile);
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                } else {
                    System.out.println("No se ha cargado correctamente");
                }
            }
            añadirImagen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
            
            
            JFileChooser chImangen = new JFileChooser();
            
            
           /* JPanel imagenPanel = new JPanel();
            imagenPanel.add(chImangen);
            imagenFrame.setContentPane(imagenPanel);
            imagenFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            imagenFrame.setVisible(true);*/
        

        ImageIcon ADNImagen = new ImageIcon(pathImg + "if_medical_icon_10_1290983.png");
        JButton buttonFasta = new JButton("FASTA", ADNImagen);
        buttonFasta.setPreferredSize(new Dimension(120, 60));
        buttonFasta.addActionListener(e -> {
            String currentDirectory = System.getProperty("user.home") + "\\Documents\\";
            JFileChooser chSecuencia = new JFileChooser(currentDirectory);
            JFrame añadirFasta = fastaFrame;
            añadirFasta.add(chSecuencia);

            chSecuencia.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    boolean is = false;
                    if (file.getName().endsWith(".txt") || file.isDirectory()) {
                        is = true;
                    }
                    return is;
                }

                @Override
                public String getDescription() {
                    return ".txt";
                }
            });

            chSecuencia.setDialogTitle("Cargar Fasta");
            int returnValue = chSecuencia.showOpenDialog(chSecuencia.getParent());
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedFilePath = chSecuencia.getSelectedFile().getAbsolutePath();
                String extension = selectedFilePath.substring(selectedFilePath.length() - 4, selectedFilePath.length());
                File saveFile = new File(System.getProperty("user.dir") + "\\src\\fasta\\" + txtNombre.getText() + extension);
                int res = guardarArchivo(chSecuencia.getSelectedFile(), saveFile);
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                } else {
                    System.out.println("No se ha cargado correctamente");
                }
            }
            añadirFasta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
       

        JLabel lblNombre = new JLabel("NOMBRE", JLabel.RIGHT);
        JLabel lblAutor = new JLabel("AUTOR", JLabel.RIGHT);
        JLabel lblDescripcion = new JLabel("DESCRIPCION", JLabel.RIGHT);
        JLabel lblMetabolismo = new JLabel("METABOLISMO", JLabel.RIGHT);
        JLabel lblEcologia = new JLabel("ECOLOGIA", JLabel.RIGHT);
        JLabel lblReferences = new JLabel("REFERENCES", JLabel.RIGHT);

        JLabel lblLogitud = new JLabel("LONGITUD DE LA SECUENCIA ", JLabel.RIGHT);
        JLabel lblTopologia = new JLabel("TOPOLOGIA", JLabel.RIGHT);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50, 50));
        northPanel.add(lblSeleccion);
        northPanel.add(cmbEspecies);

        JPanel datos = new JPanel();
        datos.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 20));
        datos.setLayout(new GridLayout(6, 0, 10, 10));
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

        JPanel archivo = new JPanel();
        archivo.setLayout(new GridLayout(2, 0, 10, 10));
        archivo.add(lblTopologia);
        archivo.add(txtTopologia);
        archivo.add(lblLogitud);
        archivo.add(txtLongitud);

        JPanel radio = new JPanel();
        radio.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        radio.add(buttonGenomico, BorderLayout.EAST);

        JPanel botones = new JPanel();
        botones.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 1));
        botones.add(buttonImagen, BorderLayout.EAST);
        botones.add(buttonFasta, BorderLayout.WEST);

        JPanel genetica = new JPanel();
        genetica.setLayout(new GridLayout(3, 0, 10, 20));
        genetica.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 1));
        genetica.add(archivo, BorderLayout.CENTER);
        genetica.add(radio, BorderLayout.NORTH);
        genetica.add(botones, BorderLayout.SOUTH);

        //archivo.add(chImangen);
        ImageIcon prevImagen = new ImageIcon(pathImg + "if_pre_293277.png");
        JButton buttonprev = new JButton("ANTERIOR", prevImagen);
        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

        JPanel inferior = new JPanel();
        inferior.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        inferior.add(buttonprev);
        buttonprev.addActionListener(ae -> {

            modificarDatosFrame.setVisible(false);
            mainFrame.setVisible(true);

        });

        inferior.add(buttonOK);
        buttonOK.addActionListener(ae -> {

            try {

                Validacion.validarCadena(txtNombre, true, "Nombre");
                                //ME da error cuando lo cargo, lo tengo que cambiar para que damita otros caracteres
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
            
            
            Especie e = (Especie) cmbEspecies.getSelectedItem();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea modificar " + e + "?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
               
               try {
                    EspecieController.update(e);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

          
            modificarClasificacion();
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
        datos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        genetica.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 15));

        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(inferior, BorderLayout.SOUTH);
        panel.add(datos, BorderLayout.CENTER);
        panel.add(genetica, BorderLayout.WEST);

        modificarDatosFrame.setContentPane(panel);
    }

    private void modificarClasificacion() {
        JLabel lblSeleccion = new JLabel("CLASIFICACIÓN");

        JComboBox<Dominio> cmbDominios = new JComboBox<>();
        JComboBox<Filo> cmbFilos = new JComboBox<>();
        JComboBox<Clase> cmbClases = new JComboBox<>();
        JComboBox<Familia> cmbFamilias = new JComboBox<>();
        JComboBox<Orden> cmbOrdenes = new JComboBox<>();
        JComboBox<Genero> cmbGeneros = new JComboBox<>();

        JLabel lblDominio = new JLabel("DOMINIO", JLabel.LEFT);
        JLabel lblFilo = new JLabel("FILO", JLabel.LEFT);
        JLabel lblClase = new JLabel("CLASE", JLabel.LEFT);
        JLabel lblFamilia = new JLabel("FAMILIA      ", JLabel.LEFT);
        JLabel lblOrden = new JLabel("ORDEN       ", JLabel.LEFT);
        JLabel lblGenero = new JLabel("GENERO      ", JLabel.LEFT);

        ImageIcon prevImagen = new ImageIcon(pathImg + "if_pre_293277.png");
        JButton buttonprev = new JButton("ANTERIOR", prevImagen);
        ImageIcon siguienteImagen = new ImageIcon(pathImg + "if_next_293276.png");
        JButton buttonOK = new JButton("SIGUIENTE", siguienteImagen);
        ImageIcon cancelarImagen = new ImageIcon(pathImg + "if_Cancel_131742.png");
        JButton buttonKO = new JButton("CANCELAR", cancelarImagen);

        for (Dominio d : dominios) {
            cmbDominios.addItem(d);
        }

        for (Filo fi : filos) {
            cmbFilos.addItem(fi);
        }
        for (Clase c : clases) {
            cmbClases.addItem(c);
        }
        for (Familia fa : familias) {
            cmbFamilias.addItem(fa);
        }
        for (Orden o : ordenes) {
            cmbOrdenes.addItem(o);
        }
        for (Genero g : generos) {
            cmbGeneros.addItem(g);
        }

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 20, 20));
        JPanel centerRPanel = new JPanel();
        centerRPanel.setLayout(new GridLayout(3, 2, 1, 20));
        centerRPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 30, 5));
        JPanel centerLPanel = new JPanel();
        centerLPanel.setLayout(new GridLayout(3, 0, 1, 20));
        centerLPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 30, 5));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northPanel.add(lblSeleccion);

        centerLPanel.add(lblDominio);
        centerLPanel.add(cmbDominios);
        centerLPanel.add(lblFilo);
        centerLPanel.add(cmbFilos);
        centerLPanel.add(lblClase);
        centerLPanel.add(cmbClases);

        centerRPanel.add(lblFamilia);
        centerRPanel.add(cmbFamilias);
        centerRPanel.add(lblOrden);
        centerRPanel.add(cmbOrdenes);
        centerRPanel.add(lblGenero);
        centerRPanel.add(cmbGeneros);

        //BOnton anterior
        southPanel.add(buttonprev);

        buttonprev.addActionListener(ae -> {
            modificarDatosFrame.setVisible(true);
            nomenclaturaFrame.setVisible(false);
        });

        //BOnton siguiente
        southPanel.add(buttonOK);

        buttonOK.addActionListener(ae -> {
            Dominio d = (Dominio) cmbDominios.getSelectedItem();
            Filo fi = (Filo) cmbFilos.getSelectedItem();
            Clase c = (Clase) cmbClases.getSelectedItem();
            Familia fa = (Familia) cmbFamilias.getSelectedItem();
            Orden o = (Orden) cmbOrdenes.getSelectedItem();
            Genero g = (Genero) cmbGeneros.getSelectedItem();

            JOptionPane.showMessageDialog(null, "Los datos se han añadido a la Base de Datos");

        });

        //Boton cancelar
        southPanel.add(buttonKO);
        buttonKO.addActionListener((ActionEvent ae) -> {

            nomenclaturaFrame.setVisible(false);

            JOptionPane.showMessageDialog(null, "Los datos se han añadido a la Base de Datos");
        });

        JPanel modClasPanel = new JPanel(new BorderLayout(10, 10));
        modClasPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 50));

        modClasPanel.add(northPanel, BorderLayout.NORTH);
        modClasPanel.add(centerRPanel, BorderLayout.EAST);
        modClasPanel.add(centerLPanel, BorderLayout.WEST);
        modClasPanel.add(southPanel, BorderLayout.SOUTH);

        nomenclaturaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        nomenclaturaFrame.setContentPane(modClasPanel);
        nomenclaturaFrame.setVisible(true);
    }

}
