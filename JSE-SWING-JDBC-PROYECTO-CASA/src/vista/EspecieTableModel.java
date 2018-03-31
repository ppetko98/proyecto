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
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.entidades.CBPropiedad;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel extends AbstractTableModel {

    //private Map<Integer, CBPropiedad> props;
    private PriorityQueue<CBPropiedad> propiedades;
    private PriorityQueue<CBPropiedad> columnas;
    private Queue<CBPropiedad> column;
/*
    PETKO GUAPETON
    */
    public EspecieTableModel(PriorityQueue<CBPropiedad> propiedades) throws SQLException {
        this.propiedades = propiedades;
        this.columnas = new PriorityQueue<>(propiedades.comparator());
         /*
        for (Object object : propiedades.toArray()) {
            columnas.add((CBPropiedad) object);
        }
       
        Iterator<CBPropiedad> it = propiedades.iterator();
        
        while (it.hasNext()){
            columnas.add(new CBPropiedad(it.next()));
        }
       */
        
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
                if (this.propiedades.peek() != null) {
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
                }
                else
                    System.out.println("PEEK == NULL!!! ");
            default:
                System.out.print("ESTO FALLA!");
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0://return props.get(1).getPropiedad();
            case 1://return props.get(2).getPropiedad();
            case 2://return props.get(3).getPropiedad();
            case 3://return props.get(4).getPropiedad();
            case 4://return props.get(5).getPropiedad();
            case 5://return props.get(6).getPropiedad();
            case 6://return props.get(7).getPropiedad();
            case 7://return props.get(8).getPropiedad();
            case 8:/*
                if (columnas.peek() != null) {
                    return columnas.poll().getPropiedad();
                }*/
            default:
                return null;
        }
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /*
    public EspecieTableModel(Map<Integer, CBPropiedad> props) throws SQLException {
        this.props = props;
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
        };
        propiedades = new PriorityQueue(comparator);
        propiedades.addAll(this.props.values());
     
        for (CBPropiedad cb : propiedades) {
            System.out.println(cb.getId() + "\t" + cb.getPropiedad());
        }
    }
     */
}
