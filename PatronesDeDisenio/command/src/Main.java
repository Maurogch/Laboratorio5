import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Command!");

        List<Command> commands = new ArrayList<>();
        commands.add(new ServicioUno());
        commands.add(new ServicioDos());

        for (Command c : commands) {
            c.ejecutar();
        }
    }
}
