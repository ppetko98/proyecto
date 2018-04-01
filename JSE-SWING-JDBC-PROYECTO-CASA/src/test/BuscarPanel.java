/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.CBPropiedad;
import modelo.entidades.Especie;
import modelo.entidades.Genetica;
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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textBuscarEspecie.setText("Buscar Especie...");
        textBuscarEspecie.setToolTipText("");
        add(textBuscarEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 52, 161, -1));

        jScrollPane1.setVisible(false);
        jScrollPane1.setViewportView(treeEspecie);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 185, 246, 203));

        btnBuscarEspecie.setText("Buscar");
        btnBuscarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEspecieActionPerformed(evt);
            }
        });
        add(btnBuscarEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 51, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setAutoscrolls(true);

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
        tablaEspecie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaEspecie.setFocusable(false);
        tablaEspecie.setGridColor(new java.awt.Color(255, 255, 255));
        tablaEspecie.setRowSelectionAllowed(false);
        tablaEspecie.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(tablaEspecie);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 185, -1, 203));

        cbEspecie1.setText("Autor");
        cbEspecie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecie1ActionPerformed(evt);
            }
        });
        add(cbEspecie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 105, -1, -1));

        cbEspecie2.setText("Ecologia");
        add(cbEspecie2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 128, -1, -1));

        cbEspecie3.setText("Referencias");
        add(cbEspecie3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 151, -1, -1));

        cbEspecie4.setText("Secuencia");
        add(cbEspecie4, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 105, -1, -1));

        cbEspecie5.setText("Longitud");
        cbEspecie5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecie5ActionPerformed(evt);
            }
        });
        add(cbEspecie5, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 128, -1, -1));

        cbEspecie6.setText("Topología");
        add(cbEspecie6, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 151, -1, -1));
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 24, 200, 150));

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
        Genetica genetica = null;

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
        PriorityQueue<CBPropiedad> props = new PriorityQueue<>(comparator);

        try {
            Validacion.validarCadena(textBuscarEspecie, true, "Buscar Especie");
            boolean found = false;

            for (Especie e : especies) {
                if (!found && e.getEspecie_name().equals(especieString)) {
                    especiebuscada = e;
                    genetica = new Genetica();
                    genetica.setId_secuencia(e.getId_secuencia());
                    found = true;
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

        
        try {
            
            treeEspecie.setModel(new DefaultTreeModel(arbolEspecie(especiebuscada)));
            treeEspecie.setShowsRootHandles(true);
            treeEspecie.setExpandsSelectedPaths(true);
            treeEspecie.setToggleClickCount(1);
            
            //jScrollPane1.setSize(treeEspecie.getSize().width,treeEspecie.getSize().height);
            jScrollPane1.setVisible(true);
            treeEspecie.setVisible(true);
     
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        int id = especiebuscada.getId_especie();
        ResultSet rs = null;
        //List<String> propiedades = new ArrayList<>(9);
        //Map<Integer, String> props = new TreeMap<>();

        CBPropiedad descripcion = new CBPropiedad("descripcion", 1, BaseDatos.SELECT_DESCRIPCION + id);
        CBPropiedad metabolismo = new CBPropiedad("metabolismo", 2, BaseDatos.SELECT_METABOLISMO + id);
        CBPropiedad secuencia = new CBPropiedad("secuencia", 3, BaseDatos.SELECT_SECUENCIA + id);

        try {
            rs = BaseDatos.executeQuery(BaseDatos.SELECT_TABLA, id);
            if (rs.next()) {
                especiebuscada.setDescripcion(rs.getString(1));
                //propiedades.add(0,"Descripcion");
                //props.put(0, "Descripcion");
                especiebuscada.setMetabolismo(rs.getString(2));
                //propiedades.add(1,"Metabolismo");
                //props.put(1,"Metabolismo");
                genetica.setFasta(rs.getString(3));
                //propiedades.add(2,"Fasta");
                //props.put(2,"Fasta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        props.add(descripcion);
        props.add(metabolismo);
        props.add(secuencia);

        //CHECKBOX PARA LA TABLA
        if (cbEspecie1.isSelected()) {
            CBPropiedad autor = new CBPropiedad("autor", 4, BaseDatos.SELECT_AUTOR + id);
            props.add(autor);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_AUTOR, id);
                if (rs.next()) {
                    especiebuscada.setAutor(rs.getString(1));
                    //propiedades.add(3,"Autor");
                    //props.put(3,"Autor");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cbEspecie2.isSelected()) {
            CBPropiedad ecologia = new CBPropiedad("ecologia", 5, BaseDatos.SELECT_ECOLOGIA + id);
            props.add(ecologia);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_ECOLOGIA, id);
                if (rs.next()) {
                    especiebuscada.setEcologia(rs.getString(1));
                    //propiedades.add(4,"Ecologia");
                    //props.put(4,"Ecologia");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cbEspecie3.isSelected()) {
            CBPropiedad references = new CBPropiedad("references", 6, BaseDatos.SELECT_REFERENCES + id);
            props.add(references);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_REFERENCES, id);
                if (rs.next()) {
                    especiebuscada.setReferences(rs.getString(1));
                    //propiedades.add(5,"References");
                    //props.put(5,"References");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cbEspecie4.isSelected()) {
            CBPropiedad es_genomico_plasmido = new CBPropiedad("es_genomico_plasmido", 7, BaseDatos.SELECT_ES_GENOMICO_PLASMIDO + id);
            props.add(es_genomico_plasmido);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_ES_GENOMICO_PLASMIDO, id);
                if (rs.next()) {
                    genetica.setEs_genomico_plasmido(rs.getBoolean(1));
                    //propiedades.add(6,"es_genomico_plasmido");
                    //props.put(6,"es_genomico_plasmido");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cbEspecie5.isSelected()) {
            CBPropiedad longitud = new CBPropiedad("longitud", 8, BaseDatos.SELECT_LONGITUD + id);
            props.add(longitud);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_LONGITUD, id);
                if (rs.next()) {
                    genetica.setLongitud(rs.getInt(1));
                    //propiedades.add(7,"Longitud");
                    //props.put(7,"Longitud");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cbEspecie6.isSelected()) {
            CBPropiedad topologia = new CBPropiedad("topologia", 9, BaseDatos.SELECT_TOPOLOGIA + id);
            props.add(topologia);

            try {
                rs = BaseDatos.executeQuery(BaseDatos.SELECT_TOPOLOGIA, id);
                if (rs.next()) {
                    genetica.setTopologia(rs.getString(1));
                    //propiedades.add(8, "Topologia");
                    //props.put(8, "Topologia");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        try {
            TableModel modelo = new EspecieTableModel(props, especiebuscada, genetica);
            tablaEspecie.setModel(modelo);
            tablaEspecie.setRowHeight(tablaEspecie.getSize().height);
            TableColumnModel column = tablaEspecie.getColumnModel();
            Enumeration<TableColumn> columns = column.getColumns();
            while (columns.hasMoreElements()) {
                columns.nextElement().setMinWidth(110);
            }
            tablaEspecie.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jScrollPane2.setVisible(true);  
            tablaEspecie.setVisible(true);
            //jScrollPane2.setEnabled(false);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarEspecieActionPerformed

    private void cbEspecie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecie1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecie1ActionPerformed

    private void cbEspecie5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecie5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecie5ActionPerformed

    private DefaultMutableTreeNode arbolEspecie (Especie e) throws SQLException{
        int id_especie = e.getId_especie();
        ResultSet rs = BaseDatos.executeQuery(BaseDatos.SELECT_ARBOL, id_especie);
        DefaultMutableTreeNode dominioRoot = new DefaultMutableTreeNode();
        if (rs.next()) {
            String dominio = rs.getString(1);
            String filo = rs.getString(2);
            String clase = rs.getString(3);
            String orden = rs.getString(4);
            String familia = rs.getString(5);
            String genero = rs.getString(6);
            String especie = rs.getString(7);
            
            dominioRoot=new DefaultMutableTreeNode(dominio,true);
            DefaultMutableTreeNode filoNode=new DefaultMutableTreeNode(filo,true);
            DefaultMutableTreeNode claseNode=new DefaultMutableTreeNode(clase,true);
            DefaultMutableTreeNode ordenNode=new DefaultMutableTreeNode(orden,true);
            DefaultMutableTreeNode familiaNode=new DefaultMutableTreeNode(familia,true);
            DefaultMutableTreeNode generoNode=new DefaultMutableTreeNode(genero,true);
            DefaultMutableTreeNode especieLeaf=new DefaultMutableTreeNode(especie,false);
            
            dominioRoot.add(filoNode);
            filoNode.add(claseNode);
            claseNode.add(ordenNode);
            ordenNode.add(familiaNode);
            familiaNode.add(generoNode);
            generoNode.add(especieLeaf);
        }
        return dominioRoot;
    }

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
