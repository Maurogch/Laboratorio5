/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author pablo
 */
public class PersonaModelImpl extends PersonaModel {
    
    List<Persona> lista;
    static PersonaModelImpl instance;
    static AtomicInteger counter = new AtomicInteger(0);
  
    public PersonaModelImpl(){
        lista = new ArrayList<Persona>();
    }
    
    @Override 
    public List<Persona> getListaPersonas(){
        return this.lista;
    }   
    
    public static PersonaModelImpl getInstance() {
        if (instance == null) {
            instance = new PersonaModelImpl();
        } 
        return instance;
    }
    
    @Override
    public void agregarPersona(Persona p){
        p.setId(nextId());
        lista.add(p);
        setChanged();
        notifyObservers(p);
    }
    
    @Override
    public Persona getPersona(int id) {
        Iterator<Persona> it = lista.iterator();        
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.id == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void modificarPersona(Persona newPersona) {
        Persona oldPersona = this.getPersona(newPersona.id);
        int index = this.lista.indexOf(oldPersona);
        this.lista.set(index, newPersona);
        setChanged();
        notifyObservers(oldPersona);
    }    
    
    
    @Override
    public void eliminarPersona(Persona p){
       this.lista.remove(p);
       setChanged();
       notifyObservers(p);       
    }
    private static int nextId(){
        return counter.incrementAndGet();
    }
    
}
