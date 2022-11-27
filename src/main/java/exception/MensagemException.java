package exception;

import java.util.function.Supplier;

public class MensagemException extends RuntimeException{

    public MensagemException(String message) {
        super(message);
    }

}
