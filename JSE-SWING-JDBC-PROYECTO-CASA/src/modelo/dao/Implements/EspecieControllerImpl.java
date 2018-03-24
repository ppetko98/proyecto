
package src.modelo.dao.Implements;

import com.mysql.jdbc.Connection;
import src.modelo.dao.EspecieController;
import src.modelo.entidades.Especie;
import src.modelo.excepciones.EspecieException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EspecieControllerImpl implements EspecieController {

    private static List<Especie> lista = new ArrayList<>();
    
    @Override
    public List<Especie> lista() throws EspecieException {
        if(lista.isEmpty()) {
        Connection connection = null;
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/biologia", 
						"root", "root");//root
            
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT e.id_especie, g.genero_name, e.especie_name\n" +
"FROM nomenclatura n INNER JOIN genero g \n" +
"ON n.id_genero = g.id_genero\n" +
"INNER JOIN especie e\n" +
"ON n.id_especie = e.id_especie");
            
            if(rs.next()){
            do{
                int id_especie = rs.getInt("id_especie");
                String especie_name = rs.getString("especie_name");
                String genero = rs.getString("genero");
                
                Especie objeto = new Especie(id_especie, especie_name, genero_name);
                
                lista.add(objeto);
                
            }while (rs.next());
                    
            }else{
            throw new EspecieException ("No data available in table");
            }
            
                     
            
        }catch (SQLException ex) {
				throw new EspecieException(ex.getMessage(), ex);
        } finally{
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new EspecieException (ex.getMessage(), ex);
            }
        }
        }
    }
        return lista;
   
}
}
