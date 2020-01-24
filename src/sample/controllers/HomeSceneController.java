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

    //Ok. These objects have the @FXML tag which means that when this class is instantiated the super magic code shit
    //  will go looking through your FXML you referenced and if there is an FXML object with a corrisponding fx:id, it will
    //  give the object access to the components info. Idk, basically its some bullshit sorcery that lets us controller the FXML
    //  from our comfy little java classes.
    @FXML private Button myButton;
    @FXML private TextFlow paragraphOne;


    //Does as advertized. Called when you instantiated the class and hopefully none of your @FXML properties are null at this point.
    //  Basically, this is where you want to set your event listeners
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //This is an event listener. It listens to events. Much like me listening to the Ricky Gervais golden globes opening monologue. Look it up.
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //So idk if this is the best way to switch between scenes. However, it is the first one I got to work so I am sticking with it for now.

                //Make sure the stage you are dealing with is the stage that your actual button is in. Trust me. Do it this way.
                Stage stage = (Stage) myButton.getScene().getWindow();

                //Remember that list of controllers we made back in the root controller class? Yeah? its almost like I had a plan all along.
                //  We use this to access the other controllers in this project. More specifically, we want their mount() methods. That way we can
                //  call them to let them load their FXML.
                RootController.getAllControllers().get(0).mount(stage);
            }
        });

        //IDK why I did this. I mean, I guess it isn't hurting anyone...
        paragraphOne.getChildren().add(new Text("I am setting this text in the initialize method of the Home Scene Controller"));
    }

    @Override
    public void mount(Stage stage) {
        try{
            //This loads the FXML to the root object. Then, we set the root of the scene to be equal to the object. Then we
            //  most likely get null pointer errors cause I forgot to set the controller correctly in the FXML file but whatever,
            //  at least it looks pretty (JK it actually works).
            root = FXMLLoader.load(getClass().getResource("../scenes/HomeScene.fxml"));
            stage.getScene().setRoot(root);
        } catch(Exception e){
            // I am slowly losing my shit
            System.out.println("Do a barrel roll");
            e.printStackTrace();
        }

    }
}
