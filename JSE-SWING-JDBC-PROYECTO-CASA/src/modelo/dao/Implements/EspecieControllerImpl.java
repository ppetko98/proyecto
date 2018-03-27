package modelo.dao.Implements;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import modelo.dao.EspecieController;
import modelo.entidades.Especie;
import src.modelo.excepciones.EspecieException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utilidades.BaseSwing;
import static utilidades.BaseSwing.crear;

public class EspecieControllerImpl implements EspecieController {

    public static List<Especie> lista = new ArrayList<>();

    @Override
    public List<Especie> lista() throws EspecieException {
        if (lista.isEmpty()) {

            Connection connection = null;

            try {

                //connection = conexion();
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/biologia",
                        "root", "root");

                Statement st = connection.createStatement();

                ResultSet rs = st.executeQuery("SELECT e.id_especie, g.genero_name, e.especie_name\n"
                        + "FROM nomenclatura n INNER JOIN genero g \n"
                        + "ON n.id_genero = g.id_genero\n"
                        + "INNER JOIN especie e\n"
                        + "ON n.id_especie = e.id_especie");

                if (rs.next()) {
                    do {
                        int id_especie = rs.getInt("id_especie");
                        String especie_name = rs.getString("especie_name");
                        String genero_name = rs.getString("genero_name");

                        Especie objeto = new Especie(id_especie, especie_name, genero_name);

                        lista.add(objeto);

                    } while (rs.next());

                } else {
                    throw new EspecieException("No data available in table");
                }

            } catch (SQLException ex) {
                throw new EspecieException(ex.getMessage(), ex);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new EspecieException(ex.getMessage(), ex);
                    }
                }
            }
        }

        System.out.println(lista);//SOLO PARA PRUEBAS!!!! ELIMINAR DESPUES IMPRIME LA LISTA PARA VER SI CARGA CORRECTAMENTE LOS DATOS

        return lista;

    }

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
}
