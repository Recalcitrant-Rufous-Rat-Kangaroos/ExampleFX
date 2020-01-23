package sample.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import sample.PageController;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneTwoController implements PageController, Initializable {
    Parent root;
    @FXML private Button navButton;
    @FXML private Button submit;
    @FXML private Text textFlow;
    @FXML private TextArea textArea;



    @Override
    public void mount(Stage stage) {
        try{
            root = FXMLLoader.load(getClass().getResource("../scenes/SceneTwo.fxml"));
            stage.getScene().setRoot(root);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        navButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)navButton.getScene().getWindow();
                RootController.getAllControllers().get(1).mount(stage);
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(textArea.getParagraphs().toString() != ""){
                    textArea.getParagraphs().forEach(t -> textFlow.setText(textFlow.getText().concat(t.toString())));
                }
            }
        });
    }
}
