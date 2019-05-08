/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.vista;

import edu.utn.controller.Controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author pablo
 */
public class ListaPersonaVista extends JFrame implements Observer {


    JTable tabla;
    JButton btnAgregar = new JButton();
    JButton btnEliminar = new JButton();
    JButton btnModificar = new JButton();
    JPanel buttonPanel = new JPanel();

    public ListaPersonaVista(String title) throws HeadlessException {
        super(title);
        this.setLayout(new BorderLayout());
        tabla = new JTable(new PersonaTableModel(Controller.getInstance().getListaPersonas()));
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(add(new JScrollPane(tabla)),BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnAgregar.setText("Agregar");
        btnModificar.setText("Modificar");
        btnEliminar.setText("Eliminar");

        
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String id = (String) tabla.getValueAt(tabla.getSelectedRow(),0);
                Controller.getInstance().eliminarPersona(Integer.parseInt(id));
           }
        };
        
        
        ActionListener actionListenerAgregar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.getInstance().showAgregarPersonaVista();
            }
        };
        
         
        ActionListener actionListenerModificar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String id = (String) tabla.getValueAt(tabla.getSelectedRow(),0);
                Controller.getInstance().showModificarPersonaVista(Integer.parseInt(id));
                
            }
        };


        btnEliminar.addActionListener(actionListener);
        btnAgregar.addActionListener(actionListenerAgregar);
        btnModificar.addActionListener(actionListenerModificar);
        
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnEliminar);
        buttonPanel.setVisible(true);

        this.setLocation(0, 0);
        this.setBounds(0, 0, 640, 480);
        this.setVisible(true);
    
    }

    @Override
    public void update(Observable o, Object arg) {
        PersonaTableModel tableModel = (PersonaTableModel) this.tabla.getModel();
        tableModel.setData(Controller.getInstance().getListaPersonas());
        this.tabla.updateUI();
    }

}
