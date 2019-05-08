package com.utn.observer.model;

import com.utn.observer.domain.Persona;

import java.util.List;
import java.util.Observable;

public abstract class PersonaModelo extends Modelo<Persona> {

    public abstract void add(Persona p);
    public abstract void update(Persona oldPersona, Persona newPersona);
    public abstract void remove(Persona p);
    public abstract List<Persona> getAll();
}

