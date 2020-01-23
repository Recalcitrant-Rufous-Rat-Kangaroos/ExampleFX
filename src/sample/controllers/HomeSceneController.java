package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import sample.PageController;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeSceneController implements PageController, Initializable {
    Parent root;
    @FXML private Button myButton;
    @FXML private TextFlow paragraphOne;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) myButton.getScene().getWindow();
                RootController.getAllControllers().get(0).mount(stage);
            }
        });
        paragraphOne.getChildren().add(new Text("I am setting this text in the initialize method of the Home Scene Controller"));
    }

    @Override
    public void mount(Stage theStage) {
        try{
            root = FXMLLoader.load(getClass().getResource("../scenes/HomeScene.fxml"));
            theStage.getScene().setRoot(root);
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
