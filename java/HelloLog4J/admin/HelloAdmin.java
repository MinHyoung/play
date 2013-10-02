package admin;

import org.apache.log4j.*;

public class HelloAdmin {
    static final Logger LOG = Logger.getLogger(HelloAdmin.class);

    public void logAdmin() {

        PropertyConfigurator.configure("log4j.properties");

        LOG.trace("Hello Main!");
        LOG.debug("Hello Admin!");
        LOG.info("Hello Admin!");
        LOG.warn("Hello Admin!");
        LOG.error("Hello Admin!");
        LOG.fatal("Hello Admin!");
    }
}
