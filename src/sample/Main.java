package sample;

import sample.controllers.RootController;

public class Main {



    public static void main(String[] args) {

        //Do not worry about the DB stuff right now
        try
        {
            DBConnect.setUpDB();
            DBConnect.createSampleTable();
        }
        catch(Exception e)
        {
            System.out.println("panic");
        }

        //Initialize new scene using the root controller class we made
        RootController scene = new RootController();

        //Run launchScene method we created in the root controller class
        scene.launchScene(args);
    }
}
