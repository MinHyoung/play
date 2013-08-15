public class MyException extends RuntimeException {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public static void main(String[] args) throws MyException {
        try {
            throw new MyException("my exception");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}