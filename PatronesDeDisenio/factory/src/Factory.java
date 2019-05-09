class Factory {
    static Computadora getComputadora(Tipo tipo) {
        if (tipo.equals(Tipo.PC)) {
            return new PC("16.0 GB", "1 TB", "3.5 GHz");
        } else if (tipo.equals(Tipo.SERVIDOR)) {
            return new Servidor("32.0 GB", "10 TB", "4.0 GHz");
        }

        return null;
    }
}
