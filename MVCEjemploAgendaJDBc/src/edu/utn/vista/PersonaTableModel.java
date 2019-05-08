/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.vista;

import edu.utn.model.Persona;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author pablo
 */
public class PersonaTableModel implements TableModel {

    List<Persona> data;
    String[] titulosColumnas = {"Id","Apellido", "Nombre", "Direccion", "Ciudad","Pais"};
    String[] metodoColumnas = {"Id","Apellido", "Nombre", "Direccion", "Ciudad","Pais"};

    
    public PersonaTableModel(List<Persona> data) {
        this.setData(data);
    }
    
    public void setData(List<Persona> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return titulosColumnas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        try {
            return Class.forName("java.lang.String");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < this.getRowCount()) {
            Persona p = this.data.get(rowIndex);
            java.lang.reflect.Method method;
            try {
                method = p.getClass().getMethod("get" + metodoColumnas[columnIndex]);
                return method.invoke(p).toString();                
            } catch (Exception e) {
                return "";        
            }
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
}

