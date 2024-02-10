package iut.montreuil.infrastructure.exception;

public class InfrastructureDataException extends Exception {
    private static final long serialVersionUID = 1997753363232807009L;

    public InfrastructureDataException(final String message) {
        super(message);
    }

    public InfrastructureDataException(
            final String message, final Throwable cause) {
        super(message, cause);
    }
}
