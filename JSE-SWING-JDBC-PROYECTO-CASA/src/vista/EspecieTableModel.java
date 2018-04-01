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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final List<String> list;
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

        for (CBPropiedad cb : propiedades) {
            System.out.println(cb.getId() + "\t" + cb.getPropiedad());
        }
        list = new ArrayList<>();
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
            case 0: //return e.getDescripcion();
            case 1: //return e.getMetabolismo();
            case 2: //return g.getFasta();
            case 3: //return e.getAutor();
            case 4: //return e.getEcologia();
            case 5: //return e.getReferences();
            case 6: //return g.isEs_genomico_plasmido();
            case 7: //return g.getLongitud();
            case 8: //return g.getTopologia();

                if (propiedades.peek() != null) {
                    try {
                        CBPropiedad prop = propiedades.poll();
                        prop.execute();
                        //columnas.add(new CBPropiedad(prop));
                        ResultSet rs = prop.getRs();
                        if (rs.next()) {
                            if (prop.getPropiedad().equals("es_genomico_plasmido")) {
                                String boole = (rs.getBoolean(1) ? "genomico" : "plasmido");
                                list.add(boole);
                                return boole;
                            } else {
                                String res = rs.getString(1);
                                list.add(res);
                                return res;
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

    public List<String> getList() {
        return list;
    }

}
