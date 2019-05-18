package controller;

import dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.PersonRepository;

import java.util.List;

@RequestMapping("/Persona")//cuando ejecutemos nuestro servicio, va a detectar que necesita de un servidor para funcionar. Desencadena la creacion de un servidor tomcat
@RestController // le estamos diciendo a spring que toda la clase es un controlador y que va a tener llamados a distintos servicios
public class PersonaController {
    @Autowired //inyecta lo necesario en el atributo de abajo
    private PersonRepository personRepository;

    @PostMapping("") //la combinacion de un verbo(post/get) y el mapeo.
    public void add(Persona p){

        personRepository.save(p);

    }

    @GetMapping
    public List<Persona> get(){

        return personRepository.findAll();
    }
}
