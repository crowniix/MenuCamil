package com.example.demo2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.media.*;

import java.io.IOException;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root, 680, 705);
        stage.setTitle("Pac-Man RETRO");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        Image icon = new Image(getClass().getResourceAsStream("assets/icon2.png"));
        stage.getIcons().add(icon);
        stage.show();
        musicBackground();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }



    void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(stage.getScene().getWindow());
        alert.setTitle("Quit");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to leave ?");

        Image icon = new Image(getClass().getResourceAsStream("assets/ah2.png"));
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(64);
        imageView.setFitHeight(64);

        alert.setGraphic(imageView);

        if(alert.showAndWait().get() == ButtonType.OK){

            System.out.println("Le jeux à bien été quitter !");
            stage.close();
        }
    }
    MediaPlayer mediaPlayer;
    public void musicBackground(){
        String s = "back.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch();
    }
}