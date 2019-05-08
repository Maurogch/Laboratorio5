/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.model;

import edu.utn.config.AppConfig;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author pfino
 */
public abstract class PersonaModel extends Observable {
   
    public abstract List<Persona> getListaPersonas();
    public abstract void agregarPersona(Persona p);
    public abstract Persona getPersona(int id);
    public abstract void modificarPersona(Persona newPersona);
    public abstract void eliminarPersona(Persona p);
}
