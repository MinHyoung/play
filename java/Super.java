public class Super {
    final String name;

    // Broken - constructor invokes overridable method. Constructors must
    // now invoke overridable methods, directly or indirecty
    public Super() {
        name = "super";
        m();
    }

    public void print() {
        System.out.println(name);
    }

    public void m() {

    }
}
