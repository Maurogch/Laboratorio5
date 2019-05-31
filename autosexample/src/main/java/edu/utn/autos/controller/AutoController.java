package edu.utn.autos.controller;

import edu.utn.autos.exception.AutoNotFoundException;
import edu.utn.autos.exception.TitularNotFoundException;
import edu.utn.autos.model.Auto;
import edu.utn.autos.model.ErrorResponse;
import edu.utn.autos.service.AutoService;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;


@Data
@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AutoController {
    private final AutoService service;

    @Autowired
    public AutoController(AutoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/autos", method = RequestMethod.GET)
    public ResponseEntity<List<Auto>> getAuto(@RequestParam Integer modelo) {
        try {
            List<Auto> listaAutos = service.getAutos(modelo);

            if (listaAutos.size()==0) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.ok(listaAutos);
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/autos/{id}", method = RequestMethod.GET)
    public ResponseEntity getAutoById(@PathVariable("id") Integer id) {

        try {
            Auto a = service.getAuto(id);
            return ResponseEntity.ok(a);
        } catch (AutoNotFoundException autoNotFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message("El auto no existe").code(1).build());
        } catch (TitularNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder().message("Error de integridad").code(666).build());
        }
    }

    @RequestMapping(value = "/autos", method = RequestMethod.POST)
    public ResponseEntity<Auto> addAuto(@RequestBody Auto auto) {
        try {
            service.addAuto(auto);
            return ResponseEntity.created(new URI("http://localhost:8080/api/autos/" + auto.getId())).body(auto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
