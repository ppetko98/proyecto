/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Image;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.CBPropiedad;
import modelo.entidades.Especie;
import modelo.excepciones.EspecieException;
import utilidades.BaseDatos;
import utilidades.Validacion;
import utilidades.ValidacionException;
import vista.EspecieTableModel;

/**
 *
 * @author ppetk
 */
public class BuscarPanel extends JPanel {

    public BuscarPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        textBuscarEspecie = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeEspecie = new javax.swing.JTree();
        btnBuscarEspecie = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEspecie = new javax.swing.JTable();
        cbEspecie1 = new javax.swing.JCheckBox();
        cbEspecie2 = new javax.swing.JCheckBox();
        cbEspecie3 = new javax.swing.JCheckBox();
        cbEspecie4 = new javax.swing.JCheckBox();
        cbEspecie5 = new javax.swing.JCheckBox();
        cbEspecie6 = new javax.swing.JCheckBox();
        lblImagen = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setRequestFocusEnabled(false);

        textBuscarEspecie.setText("Buscar Especie...");
        textBuscarEspecie.setToolTipText("");

        jScrollPane1.setViewportView(treeEspecie);

        btnBuscarEspecie.setText("Buscar");
        btnBuscarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEspecieActionPerformed(evt);
            }
        });

        jScrollPane2.setVisible(false);
        tablaEspecie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaEspecie);

        cbEspecie1.setText("Autor");
        cbEspecie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecie1ActionPerformed(evt);
            }
        });

        cbEspecie2.setText("Ecologia");

        cbEspecie3.setText("Referencias");

        cbEspecie4.setText("Secuencia");

        cbEspecie5.setText("Longitud");
        cbEspecie5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecie5ActionPerformed(evt);
            }
        });

        cbEspecie6.setText("Topología");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(textBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarEspecie)
                                .addGap(56, 56, 56))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEspecie1)
                                    .addComponent(cbEspecie2)
                                    .addComponent(cbEspecie3))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEspecie4)
                                    .addComponent(cbEspecie5)
                                    .addComponent(cbEspecie6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarEspecie)
                            .addComponent(textBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEspecie1)
                            .addComponent(cbEspecie4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEspecie2)
                            .addComponent(cbEspecie5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEspecie3)
                            .addComponent(cbEspecie6)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEspecieActionPerformed

        String especieString = textBuscarEspecie.getText();

        List<Especie> especies = null;
        try {
            especies = new EspecieControllerImpl().lista();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        Especie especiebuscada = null;
        
       // Map<Integer,CBPropiedad> props = new TreeMap<>();
        
        Comparator comparator = new Comparator<CBPropiedad>() {
            @Override
            public int compare(CBPropiedad o1, CBPropiedad o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };//comparador para priority queue
        PriorityQueue<CBPropiedad>props = new PriorityQueue<>(comparator);
        
        try {
            Validacion.validarCadena(textBuscarEspecie, true, "Buscar Especie");
            boolean found = false;
            
            for (Especie e : especies) {
                if (e.getEspecie_name().equals(especieString)) {
                    especiebuscada = e;
                    found=true;
                }
            }//foreach recorre especies
            
            if (!found) {
                throw new EspecieException("Especie no encontrada");
            }//Si NO ha encontrado la especie lanza la excepcion
        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }//Validacion de la caja de texto
        catch (EspecieException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Especie No Encontrada",
                    JOptionPane.ERROR_MESSAGE);
        }//Validacion Especie

        //SE DEBERÁ HACER CON CONSULTA SQL
        String pathImg = System.getProperty("user.dir") + "\\src\\testImages\\"
                + especiebuscada.getEspecie_name() + ".png";//direccion de las imagenes

        ImageIcon imagen = new ImageIcon(pathImg);

        Image image = imagen.getImage().getScaledInstance(lblImagen.getSize().width, lblImagen.getSize().height, 0);

        lblImagen.setIcon(new ImageIcon(image));
        lblImagen.setVisible(true);
        
        int id = especiebuscada.getId_especie();
        
        CBPropiedad descripcion = new CBPropiedad("descripcion", 1, BaseDatos.SELECT_DESCRIPCION+id);
        CBPropiedad metabolismo = new CBPropiedad("metabolismo", 2, BaseDatos.SELECT_METABOLISMO+id);
        CBPropiedad secuencia = new CBPropiedad("secuencia", 3, BaseDatos.SELECT_SECUENCIA+id);
        /*
        props.put(descripcion.getId(), descripcion);
        props.put(metabolismo.getId(), metabolismo);
        props.put(secuencia.getId(), secuencia);
       */
        props.add(descripcion);
        props.add(metabolismo);
        props.add(secuencia);
        
        //CHECKBOX PARA LA TABLA
        if (cbEspecie1.isSelected()) {
            CBPropiedad autor = new CBPropiedad("autor", 4, BaseDatos.SELECT_AUTOR+id);
            //props.put(autor.getId(), autor);
            props.add(autor);
        }
        if (cbEspecie2.isSelected()) {
            CBPropiedad ecologia = new CBPropiedad("ecologia", 5, BaseDatos.SELECT_ECOLOGIA+id);
            //props.put(ecologia.getId(), ecologia);
            props.add(ecologia);
        }if (cbEspecie3.isSelected()) {
            CBPropiedad references = new CBPropiedad("references", 6, BaseDatos.SELECT_REFERENCES+id);
            //props.put(secuencia.getId(), references);
            props.add(references);
        }if (cbEspecie4.isSelected()) {
            CBPropiedad es_genomico_plasmido = new CBPropiedad("es_genomico_plasmido", 7, BaseDatos.SELECT_ES_GENOMICO_PLASMIDO+id);
            //props.put(es_genomico_plasmido.getId(), es_genomico_plasmido);
            props.add(es_genomico_plasmido);
        }if (cbEspecie5.isSelected()) {
            CBPropiedad longitud = new CBPropiedad("longitud", 8, BaseDatos.SELECT_LONGITUD+id);
            //props.put(longitud.getId(), longitud);
            props.add(longitud);
        }if (cbEspecie6.isSelected()) {
            CBPropiedad topologia = new CBPropiedad("topologia", 9, BaseDatos.SELECT_TOPOLOGIA+id);
            //props.put(topologia.getId(), topologia);
            props.add(topologia);
        }
        
        try {
            TableModel modelo = new EspecieTableModel(props);
            tablaEspecie.setModel(modelo);
            
            jScrollPane2.setVisible(true);
            tablaEspecie.setVisible(true);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        props.clear();
    }//GEN-LAST:event_btnBuscarEspecieActionPerformed

    private void cbEspecie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecie1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecie1ActionPerformed

    private void cbEspecie5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecie5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecie5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEspecie;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbEspecie1;
    private javax.swing.JCheckBox cbEspecie2;
    private javax.swing.JCheckBox cbEspecie3;
    private javax.swing.JCheckBox cbEspecie4;
    private javax.swing.JCheckBox cbEspecie5;
    private javax.swing.JCheckBox cbEspecie6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablaEspecie;
    private javax.swing.JTextField textBuscarEspecie;
    private javax.swing.JTree treeEspecie;
    // End of variables declaration//GEN-END:variables
}
