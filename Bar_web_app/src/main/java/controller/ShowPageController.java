package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;


public class ShowPageController implements Controller {

    private final String VIEW_NAME;

    public ShowPageController(String viewName) {
        this.VIEW_NAME = viewName;
    }


    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        return new ControllerResultDto(VIEW_NAME);
    }

    public String value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
