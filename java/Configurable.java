/**
 * Extend this class to make you class configurable
 */
public abstract class Configurable {
    protected Config config;

    protected Configurable(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }
}
