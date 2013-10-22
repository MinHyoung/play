import java.util.Arrays;
import java.util.Set;

/**
 * The reflection facility, java.lang.reflect, offers programmatic access
 * to information about loaded classes.
 * <p/>
 * Given a Class instance, you can obtain Constructor, Method, and Field
 * instances representing the constructors, methods, and fields of the class
 * represented by the Class instance. These objects provide programmatic
 * access to the class's member names, field types, method signatures, and
 * so on. Moreover, Constructor, Method, and Field instances let you manipulate
 * their underlying counterparts reflectively: You can construct instances,
 * invoke methods, and access fields of the underlying class by invoking
 * methods on the Constructor, Field, and Method instances.
 */
public class Reflection {
    // Reflective instantiation with interface access
    public static void main(String[] args) {
        // Translate the class name into a class object
        Class cl = null;
        try {
            cl = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found.");
            System.exit(1);
        }
        // Instantiate the class
        Set s = null;
        try {
            s = (Set) cl.newInstance();
        } catch (IllegalAccessException e) {
            System.err.println("Class not accessible.");
            System.exit(1);
        } catch (InstantiationException e) {
            System.err.println("Class not instantiable.");
            System.exit(1);
        }
        // Exercise the set
        s.addAll(Arrays.asList(args).subList(1, args.length - 1));
        System.out.println(s);
    }
}
