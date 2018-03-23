package test;

import modelo.dao.EspecieController;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static utilidades.BaseSwing.crear;


/**
 *
 * @author Tamara
 */
public class Ejecucion {
    
    private final JFrame mainFrame = crear ("GESTIÓN DE ESPECIES",
            600, 500, false, true);
    
    private final JFrame eliminarFrame = crear("ELIMINAR ESPECIE",
            600, 500, false, true);
    
public JList <Especie> lstEspecies = new JList<>();

/*private EspecieController controllerEspecie = new EspecieController() {

        @Override
        public List<Especie> lista() throws EspecieException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejecucion().startup());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Error al cargar los driver");
            System.exit(0);
        }
        try {
            EspecieController controller = new EspecieControllerImpl();
            List<Especie> especies = controller.lista();
            for (Especie es :especies) {
            
                System.err.println (es);
            }
            
        } catch (EspecieException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void startup(){
        JPanel botones = new JPanel ();
        botones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
       
        // Botones
        JButton btnCrear = new JButton("NUEVO");
        JButton btnEditar = new JButton("EDITAR");
        JButton btnEliminar = new JButton("ELIMINAR");
        JButton btnBuscar = new JButton("BUSCAR");
        JButton btnCancelar= new JButton("CANCELAR");
        
       
        // Añadir botones 
        botones.add(btnCrear);
        botones.add(btnEditar);
       botones.add(btnEliminar);
        botones.add(btnBuscar);
        botones.add(btnCancelar);
        
        JPanel mainPanel = new JPanel(new BorderLayout(40, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
        
        mainPanel.add(new JScrollPane(lstEspecies),BorderLayout.NORTH);
        mainPanel.add(botones,BorderLayout.SOUTH);
        
        //Action Listener
        
        btnEliminar.addActionListener(ae -> {
        
            eliminarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            
            eliminarFrame.setVisible(true);
        
        });
        
        //Vista
        mainFrame.setContentPane (mainPanel);
        mainFrame.setVisible(true);
        
    
       cargarCombo();
        
       programarCombo();
        
    }
    
    private void eliminarEspecie() {
    JLabel lblSeleccion = new JLabel("SELECCIONA ESPECIE");
    
    
    
   
    
        
    }
    private void cargarCombo() {
      //List<Especie>
    }

    private void programarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
