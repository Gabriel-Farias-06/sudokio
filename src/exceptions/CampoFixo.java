package exceptions;

public class CampoFixo extends Exception {

    public CampoFixo() {
        super("Este campo tem um valor fixo, não é possível alterar");
    }
    
}
