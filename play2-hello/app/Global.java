import play.Application;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings {

    @Override
    public void beforeStart(Application app) {
        Logger.info("beforeStart");
    }
    @Override
    public void onStart(Application app) {
        Logger.info("onStart");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("onStop");
    }
}