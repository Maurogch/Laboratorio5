package edu.utn.model;

import java.util.HashMap;

/**
 *
 * @author pablo
 */
public class Persona {

    int id;
    String nombre;
    String apellido;
    String direccion;
    String ciudad;
    String pais;
   
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public Persona(int id, String nombre, String apellido, String direccion, String ciudad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    public Persona(String nombre, String apellido, String direccion, String ciudad, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

  

}
