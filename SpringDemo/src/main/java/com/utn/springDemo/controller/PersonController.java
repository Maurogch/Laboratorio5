package com.utn.springDemo.controller;

import com.utn.springDemo.model.Person;
import com.utn.springDemo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/person") // Cuando ejecutemos nuestro servicio, va a detectar que necesita de un servidor para funcionar.
                           // Desencadena la creacion de un servidor tomcat
@RestController // Le estamos diciendo a spring que toda la clase es un controlador y que va a tener llamados a distintos
                // servicios (PostMapping, GetMapping, etc)
public class PersonController {
    @Autowired // Inyecta el bean necesario en el atributo
    private PersonRepository personRepository;

    @PostMapping("") // La combinacion de un verbo(post/get) y el mapeo. Ej /add seria: localhost:8080/person/add
    private void addPerson(@RequestBody Person p){
        personRepository.save(p);
    }

    @GetMapping("")
    private List<Person> getAll(){
        return personRepository.findAll();
    }
}
