public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Strategy!");

        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item(10);
        Item item2 = new Item(40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new Paypal("myemail@example.com", "mypwd"));

        cart.pay(new TarjetaDeCredito("Nombre Apellido", "1234567890123456", "786", "12/15"));
    }
}
