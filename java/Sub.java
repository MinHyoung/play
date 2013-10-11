public class Sub extends Super {
    final String name;

    public Sub() {
        name = "sub";
    }

    @Override
    public void print() {
        super.print();
        System.out.println(name);
    }

    public static void main(String[] args) {
        (new Sub()).print();
    }
}
