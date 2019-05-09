public abstract class Computadora {
    private String ram;
    private String hdd;
    private String cpu;

    public Computadora(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "ram='" + this.getRam() + '\'' +
                ", hdd='" + this.getHdd() + '\'' +
                ", cpu='" + this.getCpu() + '\'' +
                '}';
    }
}