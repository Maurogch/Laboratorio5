public class ComandoImpl implements Comando {
    @Override
    public void ejecutarComando(String cmd) {
        System.out.println("'" + cmd + "' comando ejecutado.");
    }
}