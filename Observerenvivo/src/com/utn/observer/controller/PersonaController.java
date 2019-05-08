package com.utn.observer.controller;

import com.utn.observer.domain.Persona;
import com.utn.observer.model.PersonaModelo;

import java.util.Optional;

public class PersonaController {

    static PersonaController instance;
    PersonaModelo personaModelo;

    public static PersonaController getInstance() {
        instance = Optional.ofNullable(instance).orElse(new PersonaController());
        return instance;
    }

    private PersonaController() {

    }

    public void setPersonaModelo(PersonaModelo personaModelo) {
        this.personaModelo = personaModelo;
    }

    public void add(Persona p) {
        personaModelo.add(p);
    }

    public void remove(Persona p) {
        personaModelo.remove(p);
    }

    public void update(Persona oldPersona, Persona newPersona) {
        personaModelo.update(oldPersona, newPersona);
    }

}
