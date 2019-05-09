class Servidor extends Computadora {

    Servidor(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public String toString() {
        return "Servidor{ " +
                super.toString() +
                " }";
    }
}
