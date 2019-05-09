public class TarjetaDeCredito implements MetodoDePago {

    private String name;
    private String cardNumber;
    private String cvv;
    private String expiracion;

    public TarjetaDeCredito(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.expiracion = expiryDate;
    }

    @Override
    public void pay(int monto) {
        System.out.println(monto + " pagado con tarjeta de credito");
    }
}
