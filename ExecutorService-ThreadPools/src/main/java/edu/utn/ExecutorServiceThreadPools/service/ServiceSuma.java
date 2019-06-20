package edu.utn.ExecutorServiceThreadPools.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

@Service
public class ServiceSuma {
    @Async("Executor")
    public CompletableFuture<Integer> metodo1(){
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(10); //it's common to return a list here
    }

    @Async("Executor")
    public CompletableFuture<Integer> metodo2(){
        try {
            sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(5);
    }
}
