package sample.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
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

    //For everything above. See HomeSceneController.

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        navButton.setOnAction(new EventHandler<ActionEvent>() {
            //Basically the exact same code we used in the HomeScene Controller
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)navButton.getScene().getWindow();
                RootController.getAllControllers().get(1).mount(stage);
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {

            //This whole mess of code is to set the text of the textFlow object (not to be confused with the TextFlow component.
            //  it was originally one of those but it was super slow and I got sorta pissed but I also was to lazy to rename the object).
            //  Anyway, basically when the submit button is pressed it checks if the textArea is empty, and if it isn't it yeets that all
            //  over to the textFlow Text object
            @Override
            public void handle(ActionEvent event) {
                if(textArea.getParagraphs().toString() != ""){

                    //The only this of note here is the sneaky little ->. This is called a lambda expression. JavaScript is
                    //  high on these currently in case you were wondering. Basically, it is an anonymous function that lets you
                    //  very compactly add a lot of functionality to some expressions like a forEach loop. Fuck it. I am not explaining
                    //  this well. Here: https://www.geeksforgeeks.org/lambda-expressions-java-8/
                    textArea.getParagraphs().forEach(t -> textFlow.setText(textFlow.getText().concat(t.toString())));
                }
            }
        });

        //Welp. That is the end of this little commenting adventure. You will probably not read these in order (or maybe at all. Maybe
        //  my sleep deprived ass is just typing to myself). If you do read them in order, you will slowly notice a general decline in mental
        //  capabilities as the exhaustion kicks in. Anyway, goodnight yall. Happy coding.
    }
}
