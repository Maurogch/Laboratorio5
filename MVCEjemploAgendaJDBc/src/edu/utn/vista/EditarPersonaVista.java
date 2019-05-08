/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.vista;

import edu.utn.controller.Controller;
import edu.utn.model.Persona;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author pfino
 */
public class EditarPersonaVista extends JFrame {

    Persona persona;
    JPanel panelTxt;
    JPanel buttonPanel;
    JTextField txtNombre = new JTextField("", WIDTH);
    JTextField txtApellido = new JTextField("", WIDTH);
    JTextField txtDireccion = new JTextField("", WIDTH);
    JTextField txtCiudad = new JTextField("", WIDTH);
    JTextField txtPais = new JTextField("", WIDTH);
    JButton btnAccept = new JButton();
    JButton btnCancel = new JButton();

    public EditarPersonaVista(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setLayout(new BorderLayout());
        panelTxt = new JPanel();
        panelTxt.setLayout(new GridLayout(5, 2));
        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panelTxt);
        
        panelTxt.add(new JLabel("Nombre"));
        panelTxt.add(txtNombre);
        panelTxt.add(new JLabel("Apellido"));
        panelTxt.add(txtApellido);
        panelTxt.add(new JLabel("Direccion"));
        panelTxt.add(txtDireccion);
        panelTxt.add(new JLabel("Ciudad"));
        panelTxt.add(txtCiudad);
        panelTxt.add(new JLabel("Pais"));
        panelTxt.add(txtPais);

        btnAccept.setText("Aceptar");
        btnCancel.setText("Cancelar");
        
        
         ActionListener actionListenerAgregar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller c = Controller.getInstance();
                c.agregarPersona(new Persona(txtNombre.getText(),txtApellido.getText(), txtDireccion.getText(), txtCiudad.getText(), txtPais.getText()));
                setVisible(false);
           }
        };

         ActionListener actionListenerModificar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller c = Controller.getInstance();
                persona.setApellido(txtApellido.getText());
                persona.setNombre(txtNombre.getText());
                persona.setDireccion(txtDireccion.getText());
                persona.setCiudad(txtCiudad.getText());
                persona.setPais(txtPais.getText());
                c.modificarPersona(persona);
                persona = null;
                setVisible(false);
           }
        };

       ActionListener actionListenerCancelar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                    setVisible(false);
           }
        }; 
        btnCancel.addActionListener(actionListenerCancelar);
        
        buttonPanel.add(btnAccept);
        buttonPanel.add(btnCancel);
        this.setLocation(0, 0);
        this.setBounds(0, 0, 320, 200);
        
        
        if (persona != null) {
            txtApellido.setText(persona.getApellido());
            txtNombre.setText(persona.getNombre());
            txtCiudad.setText(persona.getCiudad());
            txtDireccion.setText(persona.getDireccion());
            txtPais.setText(persona.getPais());
            btnAccept.addActionListener(actionListenerModificar);
        } else {
            btnAccept.addActionListener(actionListenerAgregar);
        }

    }

    public EditarPersonaVista(int id, String title) {
        super(title);
        this.persona = Controller.getInstance().getPersona(id);
        init();
    }

}
