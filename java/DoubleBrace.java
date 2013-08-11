import java.util.HashSet;
import java.util.Set;

/**
 * Illustrates Double Brace Initialization
 *  See: http://www.c2.com/cgi/wiki?DoubleBraceInitialization
 */
public class DoubleBrace {

    private static final Set<String> FLAVORS1 = new HashSet<>();
    static {
        FLAVORS1.add("vanilla");
        FLAVORS1.add("strawberry");
        FLAVORS1.add("chocolate");
        FLAVORS1.add("butter pecan");
    }

    /**
     * The first brace creates a new anonymous inner class, the second declares an instance
     * initializer block that is run when the anonymous inner class is instantiated. This
     * type of initializer block is formally called an "instance initializer", because it
     * is declared within the instance scope of the class -- "static initializer" are a related
     * concept where the keyword static is placed before the brace that starts the block, and
     * which is executed at the class level as soon as the classloader completes loading the
     * class (specified at http://docs.oracle.com/javase/specs/jls/se5.0/html/classes.html#8.6)
     *
     * The initializer block can use any methods, fields and final variables available in the
     * containing scope, but one has to be wary of the fact that initializer are run before
     * constructors (but not before superclass constructors).
     *
     * This only works only for non-final classes because it creates an anonymous subclass.
     */
    private static final Set<String> FLAVORS2 = new HashSet<String>() {{
        add("vanilla");
        add("strawberry");
        add("chocolate");
        add("butter pecan");
    }};
}
