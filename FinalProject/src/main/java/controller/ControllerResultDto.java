package controller;

public class ControllerResultDto {
    private final String view;

    public ControllerResultDto(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
