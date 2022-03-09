package app.ultratechies.api.exceptions;

public class TaskNotfoundException extends RuntimeException {

    public TaskNotfoundException(String message) {
        super(message);
    }
}
