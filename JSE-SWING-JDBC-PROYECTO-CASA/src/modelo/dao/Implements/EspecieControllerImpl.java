package modelo.dao.Implements;

import com.mysql.jdbc.Connection;
import modelo.dao.EspecieController;
import modelo.entidades.Especie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import utilidades.BaseDatos;

public class EspecieControllerImpl implements EspecieController {

   public static List<Especie> lista = new ArrayList<>();
    public static Collection<Especie> listacompleta = new ArrayList<>();


   

    @Override
    public List<Especie> lista() throws SQLException {
        if (lista.isEmpty()) {

            Connection connection = null;
 try {
                
                connection = (Connection) BaseDatos.getConnection();

                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ESPECIE);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        int id_especie = rs.getInt("id_especie");
                        String especie_name = rs.getString("especie_name");
                        String genero_name = rs.getString("genero_name");

                        Especie objeto = new Especie(id_especie, especie_name, genero_name);

                        lista.add(objeto);

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

        return lista;
    }

   /* public static Connection conexion() throws SQLException {

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

    public Collection<Especie> coleccionCompleta() throws SQLException {
      
        
        if (listacompleta.isEmpty()) {

     
            Connection connection = null;
            try {
               
                connection = (Connection) BaseDatos.getConnection();
                
                connection.setAutoCommit(true);
                PreparedStatement ps = connection.prepareStatement(BaseDatos.SELECT_ESPECIE);

                ResultSet rs = ps.executeQuery();

                                Statement st = connection.createStatement();

               


                if (rs.next()) {
                    do {
                        int id_especie = rs.getInt("id_especie");
                        String especie_name = rs.getString("especie_name");
                        String genero_name = rs.getString("genero_name");

                        Especie objeto = new Especie(id_especie, especie_name, genero_name);

                        listacompleta.add(objeto);

                    } while (rs.next());

                } else {

                    throw new SQLException("No data available in table");
                }

              
            ps = connection.prepareStatement(BaseDatos.DELETE_ESPECIE);
              Collection<Especie> es = new ArrayList<>();
 for (Especie especie : es) {
      ps.executeUpdate();
 }
           
            connection.commit();
            
                       
                
            } catch (SQLException e) {
                 
                System.out.println("Error SQL. " + e.getMessage());
            }finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        
                    }
                }
            }

            System.out.println(listacompleta);//SOLO PARA PRUEBAS!!!! ELIMINAR DESPUES IMPRIME LA LISTA PARA VER SI CARGA CORRECTAMENTE LOS DATOS

        }
        return listacompleta;

    }

 



   
}
