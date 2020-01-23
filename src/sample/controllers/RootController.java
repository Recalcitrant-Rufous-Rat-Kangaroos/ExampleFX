package sample.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.PageController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class RootController extends Application {
    @FXML private Button myButton;
    @FXML private TextArea text;

   private static ArrayList<PageController> controllers = new ArrayList<PageController>();

    FXMLLoader loader1 = new FXMLLoader();
    FXMLLoader loader2 = new FXMLLoader();

    Stage stage;
    StackPane defaultRoot = new StackPane();
    Parent root1;
    Parent root2;

    public static void launchScene(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        SceneTwoController sceneTwo = new SceneTwoController();
        HomeSceneController homeScene = new HomeSceneController();
        controllers.add((PageController)sceneTwo);
        controllers.add((PageController)homeScene);

        primaryStage.setScene(new Scene(defaultRoot));
        homeScene.mount(primaryStage);
        primaryStage.show();

    }


//    @FXML void handleSubmitButtonAction(ActionEvent event) {
//        String data = "test";
//        try {
//            data = DBConnect.yoink();
//            System.out.println(data);
//        } catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }

    public static List<PageController> getAllControllers(){
        return controllers;
    }


}
