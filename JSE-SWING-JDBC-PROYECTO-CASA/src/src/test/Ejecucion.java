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
            600, 500, false, true);

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
        JPanel botones = new JPanel();
        botones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Botones
        JButton btnCrear = new JButton("NUEVO");
        JButton btnEditar = new JButton("EDITAR");
        JButton btnEliminar = new JButton("ELIMINAR");
        JButton btnBuscar = new JButton("BUSCAR");
        JButton btnCancelar = new JButton("CANCELAR");

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
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        mainPanel.add(botones, BorderLayout.SOUTH);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setVisible(true);

    }

    private void eliminarEspecie() throws EspecieException{
    JLabel lblSeleccion = new JLabel("SELECCIONA ESPECIE");
        JComboBox<Especie> cmbEspecies = new JComboBox<>();
        JButton elimButton = new JButton ("ELIMINAR");
        JButton cancelButton = new JButton ("CANCELAR");
        
        for (Especie e : especies) {
            cmbEspecies.addItem(e);
        }
        
        
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(1, 50 ,50));
        JPanel centerPanel = new JPanel(); 
        JPanel southPanel = new JPanel();
       
        northPanel.add(lblSeleccion);
        centerPanel.add(cmbEspecies);
        
        
        southPanel.add(elimButton);
        elimButton.addActionListener (ae ->{
            Especie e = (Especie) cmbEspecies.getSelectedItem();
            
            especies.remove(e);
            
            cmbEspecies.removeItem(e);
            
            eliminarFrame.setVisible(false);
             
              JOptionPane.showMessageDialog(null, "Se ha eliminado la especie seleccionada");
        });
        
        
        southPanel.add(cancelButton);
        
        cancelButton.addActionListener(ae ->{
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
}
