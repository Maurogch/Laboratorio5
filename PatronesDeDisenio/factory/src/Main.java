public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Factory!");

        Computadora pc = Factory.getComputadora(Tipo.PC);
        Computadora servidor = Factory.getComputadora(Tipo.SERVIDOR);

        System.out.println(pc);
        System.out.println(servidor);
    }
}
