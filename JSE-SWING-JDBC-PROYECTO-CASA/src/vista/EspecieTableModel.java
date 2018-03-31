/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import modelo.entidades.CBPropiedad;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel extends AbstractTableModel {

    private PriorityQueue<CBPropiedad> propiedades;
    private PriorityQueue<CBPropiedad> columnas;

    public EspecieTableModel(PriorityQueue<CBPropiedad> propiedades) throws SQLException {
        this.propiedades = new PriorityQueue<>(propiedades);
        this.columnas = new PriorityQueue<>(propiedades.comparator());

        Iterator<CBPropiedad> it = propiedades.iterator();

        while (it.hasNext()) {
            columnas.add(new CBPropiedad(it.next()));
        }

        for (CBPropiedad cb : propiedades) {
            System.out.println(cb.getId() + "\t" + cb.getPropiedad());
        }
        
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return propiedades.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (propiedades.peek() != null) {
                    try {
                        CBPropiedad prop = propiedades.poll();
                        prop.execute();
                        //columnas.add(new CBPropiedad(prop));
                        ResultSet rs = prop.getRs();
                        if (rs.next()) {
                            if (prop.getPropiedad().equals("es_genomico_plasmido")) {
                                return (rs.getBoolean(1) ? "genomico" : "plasmido");
                            } else {
                                return rs.getString(1);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EspecieTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("PEEK == NULL!!! ");
                }
            default:
                System.out.print("ESTO FALLA!");
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (columnas.peek() != null) {
                    return columnas.poll().getPropiedad();
                }
            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: 
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: return CBPropiedad.class;
                default:return Object.class;
        }
    }
    
}
