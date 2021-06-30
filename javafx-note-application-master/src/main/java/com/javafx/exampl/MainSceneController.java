package com.javafx.exampl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainSceneController {

    @FXML
    private Button printButton;
    @FXML
    private Text label;
    @FXML
    private TextField myTextField;

    public void printBtnClick() {
        String text = myTextField.getText();
    }


}
