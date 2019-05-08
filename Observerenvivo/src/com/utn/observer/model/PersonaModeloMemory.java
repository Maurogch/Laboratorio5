package com.utn.observer.model;

import com.utn.observer.domain.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaModeloMemory extends PersonaModelo {


    List<Persona> listaPersonas = new ArrayList<>();

    public void add(Persona p) {
        listaPersonas.add(p);
        setChanged();
        notifyObservers("Se agrego un dato");
    }


    public void update(Persona persona, Persona newPersona) {
        int x = listaPersonas.indexOf(persona);
        listaPersonas.set(x, newPersona);
        setChanged();
        notifyObservers("Se modifico un dato");
    }

    public void remove(Persona p) {
        int x = listaPersonas.indexOf(p);
        listaPersonas.remove(p);
        setChanged();
        notifyObservers("Se elimino un dato");
    }


    public List<Persona> getAll() {
        return listaPersonas;
    }
}
