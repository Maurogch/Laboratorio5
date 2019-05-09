package UTN.model;

import java.util.Objects;

public class Marca {
    private int id;
    private String nombreMarca;
    private String origen;

    public int getId() {
        return id;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return id == marca.id &&
                Objects.equals(nombreMarca, marca.nombreMarca) &&
                Objects.equals(origen, marca.origen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreMarca, origen);
    }
}
