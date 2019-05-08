/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.model;

/**
 *
 * @author pablo
 */
public class Ciudad {
    
    String nombre;
    String codigoPostal;
    
    public Ciudad (String nombre, String codigoPostal) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    @Override
    public String toString(){
        return this.nombre;
        
    }
    
}
