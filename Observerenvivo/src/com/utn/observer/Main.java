package com.utn.observer;

import com.utn.observer.controller.PersonaController;
import com.utn.observer.domain.Persona;
import com.utn.observer.model.PersonaModelo;
import com.utn.observer.model.PersonaModeloMemory;
import com.utn.observer.view.VistaPersonas;

public class Main {

    public static void main(String[] args) {

        PersonaModelo modelo = new PersonaModeloMemory();
        PersonaController controller = PersonaController.getInstance();

        VistaPersonas vista = new VistaPersonas();

        modelo.addObserver(vista);
        controller.setPersonaModelo(modelo);


        Persona german = new Persona("German", "Gianotti", "18167555", 52);

        controller.add(new Persona("Pablo", "Fino", "28167555", 23));
        controller.add(german);

        controller.remove(german);

    }
}
