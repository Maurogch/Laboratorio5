/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.controller;


import edu.utn.config.AppConfig;
import edu.utn.model.Persona;
import edu.utn.model.PersonaModel;
import edu.utn.model.PersonaModelImplDB;
import edu.utn.vista.EditarPersonaVista;
import edu.utn.vista.ListaPersonaVista;
import java.lang.reflect.Constructor;
import java.util.List;

/**
 *
 * @author pfino
 */
public class Controller {

    PersonaModel personaModel;
    EditarPersonaVista vistaEditar;
    ListaPersonaVista vistaListar;

    private Controller()  {
        try {
            Class c = Class.forName(AppConfig.getInstance().getConfiguration("modelo.clase"));
            Class[] types = {};
            Constructor constructor = c.getConstructor(types);
            personaModel =  (PersonaModel) constructor.newInstance(types);
        } catch(Exception e) {
            System.out.println("Imposible crear la clase modelo");
            System.exit(-1);
        }
            
    }

    static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void run() {
        vistaListar = new ListaPersonaVista("Agenda ejemplo UTN");
        personaModel.addObserver(vistaListar);
    }

    public void agregarPersona(Persona p) {
        personaModel.agregarPersona(p);
    }

    public void eliminarPersona(int id) {
        Persona p = personaModel.getPersona(id);
        personaModel.eliminarPersona(p);
    }

    public List<Persona> getListaPersonas() {
        return personaModel.getListaPersonas();
    }

    public Persona getPersona(int id) {
        return personaModel.getPersona(id);
    }

    public void showAgregarPersonaVista() {
        vistaEditar = new EditarPersonaVista(AppConfig.getInstance().getConfiguration("vista.AgregarPersona.titulo"));
        vistaEditar.setVisible(true);
    }

    
    public void showModificarPersonaVista(int id) {
        EditarPersonaVista vista = new EditarPersonaVista(id, AppConfig.getInstance().getConfiguration("vista.ModificarPersona.titulo"));
        vista.setVisible(true);
    }

    public void modificarPersona(Persona p) {
        personaModel.modificarPersona(p);
    }

}
