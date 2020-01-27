package sample.controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.PageController;

import java.util.ArrayList;
import java.util.List;


public class RootController extends Application {

    //A static list of all of our controllers. These will be accessible through a getter method
   private static ArrayList<PageController> controllers = new ArrayList<PageController>();

    //This method calls the launch() function that is included in the application class. I am not sure
    // exactly what launch all does, but I am pretty sure it calls the start() method down below. Basically, we call it
    // when we want to start our application
    public void launchScene(String[] args){
        launch(args);
    }

    //start() is an overridable method from the application class (that we extend). This method I am pretty sure is called when
    // launch() is called.
    @Override
    public void start(Stage primaryStage) throws Exception{
        //sets title of primary stage (basically the title of the window
        primaryStage.setTitle("Hello World");

        //initialize our two controllers
        SceneTwoController sceneTwo = new SceneTwoController();
        HomeSceneController homeScene = new HomeSceneController();
        JohnDemo johnScene = new JohnDemo();
        //add our two controllers to the list we instantiated above. I am also explicitly casting them as PageControllers
//        controllers.add((PageController)sceneTwo);
//        controllers.add((PageController)homeScene);
//
//        //Sets the initial scene and root of the primary stage. These will be overriden momentarily
        primaryStage.setScene(new Scene(new StackPane()));
//        //calling the mount method (remember that from the PageController interface?). This will load our homeScene as the root FXML
//        homeScene.mount(primaryStage);
        //show the stage. yeah.
        johnScene.mount(primaryStage);
        primaryStage.show();

    }

    //Getter function that returns our list of controllers
    public static List<PageController> getAllControllers(){
        return controllers;
    }


}
