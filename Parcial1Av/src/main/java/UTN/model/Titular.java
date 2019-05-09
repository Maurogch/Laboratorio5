package UTN.model;

import java.util.Objects;

public class Titular {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Titular(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titular titular = (Titular) o;
        return id == titular.id &&
                Objects.equals(nombre, titular.nombre) &&
                Objects.equals(apellido, titular.apellido) &&
                Objects.equals(dni, titular.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni);
    }
}

