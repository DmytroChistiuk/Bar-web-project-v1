package controller;

import entity.Weather;
import entity.WeatherData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import util.WeatherDataScanner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    private Button printButton;
    @FXML
    private Text output;
    @FXML
    private TextField SearchPage;
    @FXML
    private ImageView image;
    private Image currentImage;
    private String icon;
    private final String imageLink1 = "https://openweathermap.org/img/wn/";
    private final String imageLink2 = "@2x.png";

    public void printBtnClick() throws IOException {
        String text = SearchPage.getText();
        WeatherDataScanner weatherDataScanner = new WeatherDataScanner();
        weatherDataScanner.apiToClass(text);
        WeatherData weatherData = weatherDataScanner.apiToClass(text);
        output.setText(weatherData.toString());

        for (Weather weather : weatherData.getWeather()) {
            icon = weather.getIcon();
        }
        currentImage = new Image(imageLink1 + icon + imageLink2);
        image.setImage(currentImage);
    }

    public void initialize(URL location, ResourceBundle resources) {
        currentImage = new Image("https://klike.net/uploads/posts/2020-02/1581672938_2.jpg");
        image.setImage(currentImage);

    }
}
