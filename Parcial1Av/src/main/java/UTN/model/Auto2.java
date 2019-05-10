package UTN.model;

import java.util.Objects;

public class Auto2 {
    private int id;
    private Titular titular;

    public Auto2(int id, Titular titular) {
        this.id = id;
        this.titular = titular;
    }

    public int getId() {
        return id;
    }

    public Titular getTitular() {
        return titular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto2 auto2 = (Auto2) o;
        return id == auto2.id &&
                Objects.equals(titular, auto2.titular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titular);
    }

    @Override
    public String toString() {
        return "Auto2{" +
                "id=" + id +
                '}';
    }
}
