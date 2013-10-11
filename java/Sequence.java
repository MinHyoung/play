public class Sequence {
    static Sequence instance;
    static int counter;

    private Sequence() {
        instance = null;
        counter = 0;
    }

    public static synchronized Sequence getInstance() {
        if (instance == null) {
            instance = new Sequence();
        }
        return instance;
    }

    public static synchronized int getNext() {
        return ++counter;
    }
}
