package exceptions;

import java.util.InputMismatchException;

public class valorInvalidoException extends InputMismatchException {
    private static final String barras = "\n===========================\n";
    public valorInvalidoException(String message) {
        super(barras+message+barras);
    }
}
