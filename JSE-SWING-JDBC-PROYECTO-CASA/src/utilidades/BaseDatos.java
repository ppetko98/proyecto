package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface BaseDatos {

    /*
	 * Constantes utilizadas en el ejemplo
     */
    String DRIVERS = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/biologia";
    String USUARIO = "root";
    String CLAVE = "Stoyanov98";

    String SELECT_ESPECIE
            = "SELECT e.id_especie, g.genero_name, e.especie_name\n"
            + "FROM nomenclatura n INNER JOIN genero g \n"
            + "ON n.id_genero = g.id_genero\n"
            + "INNER JOIN especie e\n"
            + "ON n.id_especie = e.id_especie";
    
    String SELECT_GENERO = "SELECT genero_name FROM biologia.genero";
    String SELECT_FAMILIA = "SELECT familia_name FROM biologia.genero";
    String SELECT_ORDEN = "SELECT orden_name FROM biologia.genero";
    String SELECT_CLASE = "SELECT clase_name FROM biologia.genero";
    String SELECT_FILO = "SELECT filo_name FROM biologia.genero";
    String SELECT_DOMINIO = "SELECT dominio_name FROM biologia.dominio";
   
           

  

    String SELECT_DESCRIPCION = "SELECT descripcion FROM biologia.especie WHERE especie.id_especie = ";
    String SELECT_METABOLISMO = "SELECT metabolismo FROM biologia.especie WHERE especie.id_especie = ";
    String SELECT_SECUENCIA = "SELECT fasta FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ";
    String SELECT_AUTOR = "SELECT autor FROM especie WHERE id_especie = ";
    String SELECT_ECOLOGIA = "SELECT ecologia FROM especie WHERE id_especie = ";
    String SELECT_REFERENCES = "SELECT especie.references FROM especie WHERE id_especie = ";
    String SELECT_ES_GENOMICO_PLASMIDO = "SELECT genetica.es_genomico_plasmido  FROM genetica inner join especie on genetica.id_secuencia = especie.id_secuencia where especie.id_especie = ";
    String SELECT_LONGITUD = "SELECT genetica.longitud FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ";
    String SELECT_TOPOLOGIA = "SELECT genetica.topologia FROM genetica INNER JOIN especie WHERE genetica.id_secuencia = especie.id_secuencia AND especie.id_especie = ";
    
    
    String DELETE_ESPECIE = "DELETE FROM biologia.especie where id_especie= ";

    /*"DELETE e.id_especie, e.especie_name, e.autor, e.descripcion, e.imagen, e.ecologia, e.metabolismo, e.references, e.id_secuencia,\n" +
"g.id_secuencia, g.es_genomico_plasmido, g.fasta, g.topologia, g.longitud, g.last_update,\n" +
"n.id_clase, n.id_dominio, n.id_especie, n.id_familia, n.id_filo, n.id_genero, n.id_orden\n" +
"FROM especie e\n" +
"INNER JOIN nomenclatura n \n" +
"ON e.id_especie = n.id_especie\n" +
"INNER JOIN genetica g\n" +
"ON e.id_secuencia = g.id_secuencia";
    
    
      "DELETE e, g, n \n"
            + "FROM especie e \n"
            + "LEFT JOIN genetica g \n"
            + "ON e.id_secuencia = g.id_secuencia\n"
            + "LEFT JOIN nomenclatura n\n"
            + "ON e.id_especie = n.id_especie"
            +"WHERE id_especie= AND id_secuencia= ";*/
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    /*
    public static Connection conexion() throws SQLException {

        JFrame conexion = crear("Conexion a base de Datos", 400, 400, false, true);
        JPanel panel = new JPanel(new FlowLayout());
        JLabel user = new JLabel("user:");
        JLabel pass = new JLabel("Password:");
        JTextField userin = new JTextField("root");
        JPasswordField passin = new JPasswordField("Pa$$w0rd");
        JButton submit = new JButton("Submit");

        panel.add(user);
        panel.add(userin);
        panel.add(pass);
        panel.add(passin);
        panel.add(submit);

        conexion.setContentPane(panel);
        conexion.setVisible(true);

        submit.addActionListener((ae) -> {

            String usuario = "root";//valor por defecto
            if (userin.getText() != null) {
                usuario = userin.getText();
            }
            String contraseña = "Pa$$w0rd";//valor por defecto
            if (passin.getPassword() != null) {
                contraseña = Arrays.toString(passin.getPassword());
            }
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/biologia",
                        usuario, contraseña);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            conexion.setVisible(false);
        });

        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/biologia");
        return connection;
    }
     */
}
