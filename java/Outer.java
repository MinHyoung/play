/**
 * Member classes - classes that are defined inside other classes
 * Local classes - classes that are defined inside statement blocks
 * Anonymous classes - classes with no names
 */
public class Outer {
    // this is an anonymous class
    Object anonymous = new Object() {
    };

    // anonymous initialization block
    {
        // this is a local class
        class Local {
        }
        Local l = new Local();
    }

    public Outer() {
        // this is a local named class in a constructor
        class Local {
        }
        Local l = new Local();
    }

    public void method() {
        // this is a local named class in a method
        class Local {
        }
        Local l = new Local();
    }

    // this is a member class
    public class Inner {
    }

    Inner i = new Inner();

    public static void main(String[] args) {
        new Outer();
    }
}
