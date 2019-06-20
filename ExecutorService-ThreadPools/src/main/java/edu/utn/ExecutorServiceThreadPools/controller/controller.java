package edu.utn.ExecutorServiceThreadPools.controller;

import edu.utn.ExecutorServiceThreadPools.service.ServiceSuma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping
public class controller {
    @Autowired
    ServiceSuma serviceSuma;

    @GetMapping("suma")
    public ResponseEntity<?> getSuma(){
        CompletableFuture<Integer> valor1 = serviceSuma.metodo1();
        CompletableFuture<Integer> valor2 = serviceSuma.metodo2();

        try {
            return ResponseEntity.ok().body(valor1.join() + valor2.join());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
