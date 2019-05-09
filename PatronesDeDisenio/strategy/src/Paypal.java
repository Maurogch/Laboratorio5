public class Paypal implements MetodoDePago {

    private String email;
    private String contraseña;

    public Paypal(String email, String pwd) {
        this.email = email;
        this.contraseña = pwd;
    }

    @Override
    public void pay(int monto) {
        System.out.println(monto + " pagado usando Paypal.");
    }
}
