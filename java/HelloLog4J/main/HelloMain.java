package main;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

import admin.*;

public class HelloMain {
    static final Logger LOG = Logger.getLogger(HelloMain.class);

    public static void main(String[] args) {

        DOMConfigurator.configure("log4j.xml");

        LOG.trace("Hello Main!");
        LOG.debug("Hello Main!");
        LOG.info("Hello Main!");
        LOG.warn("Hello Main!");
        LOG.error("Hello Main!");
        LOG.fatal("Hello Main!");

        HelloAdmin obj = new HelloAdmin();
        obj.logAdmin();
    }
}
