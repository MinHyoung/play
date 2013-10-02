public class SystemProperties {

    public static void main(String[] args) throws Exception {
        for (String propertyName : System.getProperties().stringPropertyNames()) {
            System.out.println(propertyName + " = '" + System.getProperty(propertyName) + "'");
        }
    }
}
