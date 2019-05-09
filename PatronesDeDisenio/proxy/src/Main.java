public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Proxy!");

        Comando executor = new Proxy("Usuario", "contraseñ");
        try {
            executor.ejecutarComando("ls -ltr");
            executor.ejecutarComando(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }
    }
}
