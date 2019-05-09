public class Proxy implements Comando {

    private boolean esAdmin;
    private Comando executor;

    public Proxy(String user, String pwd) {
        if ("Usuario".equals(user) && "contraseñ4".equals(pwd)) {
            esAdmin = true;
        }
        executor = new ComandoImpl();
    }

    @Override
    public void ejecutarComando(String comando) throws Exception {
        if (esAdmin) {
            executor.ejecutarComando(comando);
        } else {
            throw new Exception("No pudo ejecutar el comando");
        }
    }
}