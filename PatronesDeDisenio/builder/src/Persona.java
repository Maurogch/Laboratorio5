public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    private Persona() {
    }

    private Persona(Builder builder) {
        this.nombre = builder.getNombre();
        this.apellido = builder.getApellido();
        this.edad = builder.getEdad();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String nombre;
        private String apellido;
        private int edad;

        String getNombre() {
            return nombre;
        }

        String getApellido() {
            return apellido;
        }

        int getEdad() {
            return edad;
        }

        Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        Builder edad(int edad) {
            this.edad = edad;
            return this;
        }

        Persona build() {
            return new Persona(this);
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + this.getNombre() + '\'' +
                ", apellido='" + this.getApellido() + '\'' +
                ", edad=" + this.getEdad() +
                '}';
    }
}
