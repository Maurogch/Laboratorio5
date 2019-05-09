public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Builder!");

        Persona john = Persona.builder()
                .nombre("John")
                .apellido("Doe")
                .edad(25)
                .build();

        Persona jane = Persona.builder()
                .nombre("Jane")
                .apellido("Doe")
                .edad(25)
                .build();

        System.out.println(john);
        System.out.println(jane);
    }
}
