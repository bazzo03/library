package controller;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result health() {
        return ok("Server is Up.");
    }

}
