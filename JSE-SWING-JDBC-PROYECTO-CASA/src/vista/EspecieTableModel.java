/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.table.AbstractTableModel;
import modelo.entidades.CBPropiedad;
import modelo.entidades.Especie;
import modelo.entidades.Genetica;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel extends AbstractTableModel {

    private final PriorityQueue<CBPropiedad> propiedades;
    private final PriorityQueue<CBPropiedad> columnas;
    private static List<String> list = null;
    Especie e;
    Genetica g;

    public EspecieTableModel(PriorityQueue<CBPropiedad> propiedades, Especie e, Genetica g) throws SQLException {
        this.propiedades = new PriorityQueue<>(propiedades);
        this.columnas = new PriorityQueue<>(propiedades.comparator());
        this.e = e;
        this.g = g;

        Iterator<CBPropiedad> it = propiedades.iterator();

        while (it.hasNext()) {
            columnas.add(new CBPropiedad(it.next()));
        }

        this.list = new ArrayList<>();
        cargarLista();
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(columnIndex);
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
        switch (columnIndex) {
            case 0:
            case 1:
                return e.getClass();
            case 2:
                return g.getClass();
            case 3:
            case 4:
            case 5:
                return e.getClass();
            case 6:
            case 7:
            case 8:
                return g.getClass();
            default:
                return null;
        }
    }

    public static List<String> getList() {
        return list;
    }

    private void cargarLista() throws SQLException {
        String res;
        while (propiedades.peek() != null) {
            res = null;
            CBPropiedad prop = propiedades.poll();
            prop.execute();
            ResultSet rs = prop.getRs();
            if (rs.next()) {
                if (prop.getPropiedad().equals("es_genomico_plasmido")) {
                    res = (rs.getBoolean(1) ? "genomico" : "plasmido");
                } else {
                    res = rs.getString(1);
                }
            }
            if (res != null) {
                list.add(res);
            }
        }
    }

}
