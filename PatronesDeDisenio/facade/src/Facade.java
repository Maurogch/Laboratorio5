class Facade {
    private static ServicioUno servicioUno = new ServicioUno();
    private static ServicioDos servicioDos = new ServicioDos();

    static String traerResultados() {
        // Operación muy compleja
        return servicioUno.traerRespuesta() + " y " + servicioDos.traerRespuesta();
    }
}
