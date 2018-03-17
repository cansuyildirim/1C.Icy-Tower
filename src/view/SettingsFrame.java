package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.nio.file.Paths;


public class SettingsFrame{

    Button backToSettingsButton, soundSettings, characterSettings, buttonSettings;
    SoundSettingsFrame ssf;
    ButtonSettings bf;
    private Image backgroundImage;


    public SettingsFrame(Stage primaryStage) throws Exception {
        backToSettingsButton = new Button("Back to Settings");
        load(primaryStage);
    }

    private void setStageUnResizable(Stage primaryStage) {
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
    }


    public Button getBackToSettingsButton() {
        return backToSettingsButton;
    }

    public void load(Stage primaryStage){
        backgroundImage = new Image(Paths.get("images/background/backgrounds.png").toUri().toString(),true);

        //primaryStage.setFullScreen(true);
        setStageUnResizable(primaryStage);

        backToSettingsButton.setTranslateX(330);
        backToSettingsButton.setTranslateY(250);
        soundSettings = new Button("Sound Settings");
        soundSettings.setMinHeight(60);
        soundSettings.setMinWidth(120);
        soundSettings.setTranslateY(-60);
        soundSettings.setTranslateX(30);
        characterSettings = new Button( "Character Settings");
        characterSettings.setTranslateY(30);
        characterSettings.setTranslateX(30);
        characterSettings.setMinHeight(60);
        characterSettings.setMinWidth(120);
        buttonSettings = new Button("Button Settings");
        buttonSettings.setTranslateY(120);
        buttonSettings.setTranslateX(30);
        buttonSettings.setMinHeight(60);
        buttonSettings.setMinWidth(120);
        Text settings = new Text("Settings");

        settings.setFont(Font.font("Settings", FontWeight.BOLD, 40));

        settings.setTranslateX(30);
        settings.setTranslateY(-170);

        StackPane pane = new StackPane();
        pane.setMinHeight(800);
        pane.setMinWidth(600);
        pane.setLayoutX(10);

        pane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(800,600, true, true, true, true))));

        pane.getChildren().addAll(settings,backToSettingsButton,soundSettings,characterSettings,buttonSettings);

        Scene scene = new Scene(pane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        soundSettings.setOnMouseClicked(event -> {
            ssf = new SoundSettingsFrame(primaryStage);
            ssf.backToSettingsButton.setOnMouseClicked(event1 -> {
                load(primaryStage);
            });
        });

    }

}
