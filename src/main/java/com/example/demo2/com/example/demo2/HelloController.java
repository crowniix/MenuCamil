package com.example.demo2;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    Stage stage;
    Scene scene;
    Parent root;


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane scenePane;


    public void switchToSceneMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToSceneAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


        @FXML
        void exit(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(exitButton.getScene().getWindow());
            alert.setTitle("Quit");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to leave ?");

            Image icon = new Image(getClass().getResourceAsStream("assets/ah2.png"));
            ImageView imageView = new ImageView(icon);
            imageView.setFitWidth(64);
            imageView.setFitHeight(64);

            alert.setGraphic(imageView);

            if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Le jeux à bien été quitter !");
            stage.close();
            }
        }

}

