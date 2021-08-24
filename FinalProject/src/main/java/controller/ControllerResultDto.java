package controller;

public class ControllerResultDto {
    private final String view;
    private boolean redirect = false;

    public ControllerResultDto(String view, boolean redirect) {
        this.view = view;
        this.redirect = redirect;
    }

    public ControllerResultDto(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public boolean isRedirect() {
        return redirect;
    }
}
