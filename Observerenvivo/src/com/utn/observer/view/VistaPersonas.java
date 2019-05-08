package com.utn.observer.view;

import com.utn.observer.domain.Persona;
import com.utn.observer.model.PersonaModelo;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VistaPersonas implements Observer {



    public void show(List<Persona> lista) {

        System.out.println("*********");
        lista.forEach(persona -> {
            System.out.println(
                    String.format("%s - %s - %s - %d", persona.getApellido(), persona.getNombre(), persona.getDni(), persona.getEdad())
            );
        });
        System.out.println("*********");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        PersonaModelo modelo =  (PersonaModelo) o;
        this.show(modelo.getAll());

    }
}
