package exceptions;

public class CordenadasInvalidas extends Exception {

    public CordenadasInvalidas(String message) {
        super("Erro de cordenada: " + message);
    }
    
}
