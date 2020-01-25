package sample;

import javafx.stage.Stage;

public interface PageController {

    //This is the interface we use to standardize all of our controllers. They must all have a mount method
    // that will load a new FXML file to the scene (this is how we switch between scenes)

    public void mount(Stage stage);
}
