/**
 * A class capable of being configured
 *
 * Dependencies:
 *  Configurable
 *  Config
 */
public class Configured extends Configurable {

    public Configured(Config config) {
        super(config);
    }

    public static void main(String[] args) {
        new Configured(new Config());
    }
}
