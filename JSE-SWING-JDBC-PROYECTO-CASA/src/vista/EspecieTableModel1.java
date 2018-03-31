/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import javafx.util.Pair;
import javax.swing.table.AbstractTableModel;
import modelo.entidades.Especie;
import modelo.entidades.Genetica;

/**
 *
 * @author ppetk
 */
public class EspecieTableModel1 extends AbstractTableModel {

    private Especie e;
    private Genetica g;
    private List<String> propiedades;
    private int tamaño=0;
    private Map<Integer,String> props;
    
    public EspecieTableModel1(Especie e, Genetica g, List<String> propiedades) {
        this.e = e;
        this.g = g;
        this.propiedades = new ArrayList<>(propiedades);
        for (int i = 0; i < propiedades.size();i++) {
            if (propiedades.get(i)!=null) {
                tamaño++;
            }
        }
    }

    public EspecieTableModel1(Especie e, Genetica g, Map<Integer, String> props) {
        this.e = e;
        this.g = g;
        this.props = new TreeMap<>(props);
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
            case 0: return e.getDescripcion();
            case 1: return e.getMetabolismo();
            case 2: return g.getFasta();
            case 3: return e.getAutor();
            case 4: return e.getEcologia();
            case 5: return e.getReferences();
            case 6: return g.isEs_genomico_plasmido();
            case 7: return g.getLongitud();
            case 8: return g.getTopologia();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        PriorityQueue<Pair<Integer,String>> q = new PriorityQueue<>(getComparator());
        for (Entry<Integer, String> entry : props.entrySet()) {
            Integer i = entry.getKey();
            String s = entry.getValue();
            q.add(new Pair<Integer,String>(i, s));
        }
        switch (column){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:if (q.peek() != null) {
                    return q.poll().getValue();
                }
                default: return null;
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
            case 1: return e.getClass();
            case 2: return g.getClass();
            case 3:
            case 4:
            case 5: return e.getClass();
            case 6:
            case 7:
            case 8: return g.getClass();
                default:return null;
        }
    }
    
    private Comparator getComparator(){
        Comparator<Pair<Integer,String>> comparator = new Comparator<Pair<Integer,String>>() {
                @Override
                public int compare(Pair<Integer,String> o1, Pair<Integer,String> o2) {
                    if (o1.getKey() > o2.getKey()) {
                        return 1;
                    } else if (o1.getKey()< o2.getKey()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };//comparador para priority queue
        return comparator;
    }
    
    
}
