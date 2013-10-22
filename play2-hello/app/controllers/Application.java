package controllers;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    /**
     * Example:
     *
     * curl -v -XPOST 'http://localhost:9000/' -H 'Content-type: application/json' -d '{"user" : "manj", "post_date" : "2009-11-15T14:12:12", "message" : "play json"}'
     */
    @BodyParser.Of(BodyParser.Json.class)
    public static Result postIndex() {
        JsonNode json = request().body().asJson();
        for (JsonNode jsonNode : json) {
            Logger.info(jsonNode.toString());
        }
//        response().setContentType("application/json");
//        return ok(json);
        ObjectNode result = Json.newObject();
        result.put("status", "ok");
        result.put("message", "hello world");
        return ok(result);
    }
}
