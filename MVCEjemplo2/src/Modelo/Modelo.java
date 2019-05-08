/*
 * Modelo.java
 *
 * Created on 9 de junio de 2006, 18:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Modelo;

import java.util.Observable;

/**
 *
 * @author root
 */
public class Modelo extends Observable
{
    private  String dato;
    
    /** Creates a new instance of Modelo */
    public Modelo()
    {
    }
    
    public void setDato(String dato)
    {
        this.dato = dato;
        setChanged();
        notifyObservers(dato);
    }
    
    public String getDato()
    {
        return dato;
    }
}
