/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import modelo.dao.Implements.EspecieControllerImpl;
import modelo.entidades.Especie;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel extends AbstractTableModel{

    private Collection<Especie> especies;
    private Map<Integer, String> props;
    
    public EspecieTableModel(Map<Integer, String> props) throws SQLException {
        
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
        switch(columnIndex){
            case 0: break;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default: return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
