public class Sub extends Super {
    final String name;

    // super class constructor always runs before subclass constructor
    // so, the overriding method in the subclass will get invoked before
    // the subclass constructor has run. If the overriding method depends
    // on the initialization performed by the subclass constructor, then
    // the method will not behave as expected
    public Sub() {
        name = "sub";
    }

    @Override
    public void print() {
        super.print();
        System.out.println(name);
    }

    @Override
    public void m() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        (new Sub()).print();
    }
}
