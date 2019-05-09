class PC extends Computadora {

    PC(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public String toString() {
        return "PC{ " +
                super.toString() +
                " }";
    }
}
