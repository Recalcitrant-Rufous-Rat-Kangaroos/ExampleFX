package sample;

import sample.controllers.RootController;

public class Main {



    public static void main(String[] args) {
        try
        {
            DBConnect.setUpDB();
            DBConnect.createSampleTable();
        }
        catch(Exception e)
        {
            System.out.println("panic");
        }
        RootController scene = new RootController();
        scene.launchScene(args);
    }
}
