/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.CBPropiedad;
import modelo.entidades.Especie;
import utilidades.BaseDatos;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel extends AbstractTableModel {

    private Collection<Especie> especies;
    private Map<Integer, CBPropiedad> props;

    public EspecieTableModel(Map<Integer, CBPropiedad> props) throws SQLException {
        especies = new EspecieControllerImpl().lista();
        this.props = props;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return props.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                try {
                    CBPropiedad prop = props.get(columnIndex + 1);
                    prop.execute();
                    ResultSet rs = prop.getRs();
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(EspecieTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 1:
                try {
                    CBPropiedad prop = props.get(columnIndex + 1);
                    prop.execute();
                    ResultSet rs = prop.getRs();
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(EspecieTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            case 2:

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: //return props.get(column+1).getPropiedad();
            case 1: //return props.get(column+1).getPropiedad();
            case 2:
                return props.get(column + 1).getPropiedad();
            default:
                return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
