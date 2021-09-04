package controller;

/**
 * Controller which used to transfer data to jsp pages.
 */
public class ControllerResultDto {
    /**
     * view it is name of jsp page.
     */
    private final String view;
    /**
     * redirect it is variable which responsible to redirect.
     * The start value is false
     */
    private boolean redirect = false;

    /**
     *
     * Constructor with redirect parameter
     * @param view
     * @param redirect
     */
    public ControllerResultDto(String view, boolean redirect) {
        this.view = view;
        this.redirect = redirect;
    }

    /**
     * Constructor without redirect parameter
     * @param view
     */
    public ControllerResultDto(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    /**
     * The method returns information whether redirection is necessary.
     * @return
     */
    public boolean isRedirect() {
        return redirect;
    }
}
