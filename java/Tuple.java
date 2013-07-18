import java.util.Arrays;
import java.util.Collection;

/**
 * Generic Tuple class for returning multiple objects
 *
 * @param <T1> the type of the first object
 * @param <T2> the type of the second object
 */
public class Tuple<T1, T2> {
    public T1 first;
    public T2 second;

    public Tuple(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        new Tuple<String, Integer>("Hello", 5);
        new Tuple<Collection<String>, String>(Arrays.asList("Hello", "World"), "!");
    }
}
