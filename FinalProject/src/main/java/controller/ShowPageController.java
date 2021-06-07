package controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;


public class ShowPageController implements Controller {

    private final String VIEW_NANE;

    public ShowPageController(String VIEW_NANE) {
        this.VIEW_NANE = VIEW_NANE;
    }

    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        return new ControllerResultDto(VIEW_NANE);
    }

    public String value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
