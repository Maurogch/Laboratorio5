package UTN.model;

import java.util.Arrays;
import java.util.Objects;

public class Auto {
    private int id;
    private Marca marca;
    private int anio;
    private String modelo;
    private Titular[] titulares;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id &&
                anio == auto.anio &&
                Objects.equals(marca, auto.marca) &&
                Objects.equals(modelo, auto.modelo) &&
                Arrays.equals(titulares, auto.titulares);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, marca, anio, modelo);
        result = 31 * result + Arrays.hashCode(titulares);
        return result;
    }
}
