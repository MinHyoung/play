public enum StrEnum {
    HELLO("hello"),
    WORLD("world"),
    FOO("foo"),
    BAR("bar");

    private final String name;

    private StrEnum(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        p("%d", StrEnum.HELLO.ordinal());
        p(StrEnum.HELLO.name());
        p("%s", StrEnum.HELLO);
        p("%s", StrEnum.valueOf("FOO"));
    }

    private static void p(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

}
