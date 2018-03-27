/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;
import src.modelo.excepciones.EspecieException;
import utilidades.Validacion;
import utilidades.ValidacionException;

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

        cbEspecie1.setText("cbEspecie1");

        cbEspecie2.setText("cbEspecie2");

        cbEspecie3.setText("cbEspecie3");

        cbEspecie4.setText("cbEspecie4");

        cbEspecie5.setText("cbEspecie5");

        cbEspecie6.setText("cbEspecie6");

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

        List<Especie> especies = EspecieControllerImpl.lista;
        Especie especiebuscada = null;

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

        String pathImg = System.getProperty("user.dir") + "\\src\\testImages\\"
                + especiebuscada.getEspecie_name() + ".png";

        ImageIcon imagen = new ImageIcon(pathImg);

        Image image = imagen.getImage().getScaledInstance(lblImagen.getSize().width, lblImagen.getSize().height, 0);

        lblImagen.setIcon(new ImageIcon(image));
        //lblImagen.setText(especiebuscada.getEspecie_name());
        lblImagen.setVisible(true);

        //SwingUtilities.updateComponentTreeUI(this);

    }//GEN-LAST:event_btnBuscarEspecieActionPerformed


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
