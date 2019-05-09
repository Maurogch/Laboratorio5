public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Singleton!");

        Singleton singletonUno = Singleton.getInstance();

        Singleton singletonDos = Singleton.getInstance();

        System.out.println(singletonUno);
        System.out.println(singletonDos);
    }
}
