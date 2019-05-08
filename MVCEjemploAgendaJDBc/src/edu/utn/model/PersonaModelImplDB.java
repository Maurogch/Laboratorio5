/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.model;

import edu.utn.persistence.PersonaMySqlPersistence;
import java.util.List;

/**
 *
 * @author pfino
 */
public class PersonaModelImplDB extends PersonaModel {

    PersonaMySqlPersistence persistence = PersonaMySqlPersistence.getInstance();
    
    
    @Override
    public List<Persona> getListaPersonas() {
        return persistence.listarPersonas();
    }

    @Override
    public void agregarPersona(Persona p) {
        persistence.agregarPersona(p);
        setChanged();
        notifyObservers();
    }

    @Override
    public Persona getPersona(int id) {
       return persistence.getPersona(id);
    }

    @Override
    public void modificarPersona(Persona newPersona) {
        persistence.modificarPersona(newPersona);
        setChanged();
        notifyObservers();
    }

    @Override
    public void eliminarPersona(Persona p) {
        persistence.eliminarPersona(p.getId());
        setChanged();
        notifyObservers();
    }
    
}
