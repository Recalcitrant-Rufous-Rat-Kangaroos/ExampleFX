package sample;

import sample.controllers.RootController;

public class Main {



    public static void main(String[] args) {
        System.out.println("xx");
        //Do not worry about the DB stuff right now
        try{DBConnect.setUpDB();}catch(Exception e){e.printStackTrace();};
        try{DBConnect.createTable("aliens", "(species VARCHAR(100), age int)");}catch(Exception e){e.printStackTrace();};
        try{DBConnect.addRow("aliens", "('romulan', 25)");}catch(Exception e){e.printStackTrace();};
        try{System.out.println(DBConnect.getName(3));}catch(Exception e){e.printStackTrace();};


        //Initialize new scene using the root controller class we made
        RootController stage = new RootController();
        System.out.println("John");
        System.out.println("John2");
        System.out.println("John3");

        //Run launchScene method we created in the root controller class
        stage.launchScene(args);
    }
}
