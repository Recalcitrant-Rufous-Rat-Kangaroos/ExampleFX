package sample;

import sample.DB.DBConnect;
import sample.controllers.RootController;

public class Main {

    static String[] query = {"nodes", "name"};

    public static void main(String[] args) {

        //Do not worry about the DB stuff right now
        try{
            DBConnect.setUpNodeDB();}catch(Exception e){e.printStackTrace();};
        try{DBConnect.createTable("nodes", "(id int, name VARCHAR(100), xcoord int, ycoord int)");}catch(Exception e){e.getMessage();};
        try{DBConnect.addRow("nodes", "(0, 'Front Door', 100, 0)");}catch(Exception e){e.printStackTrace();};
        try{String data = DBConnect.getName(query); System.out.println(data);}catch(Exception e){e.printStackTrace();};
        try{DBConnect.deleteRowByID("nodes", 0);} catch(Exception e){e.printStackTrace();}
        try{DBConnect.deleteTableByName("nodes");} catch(Exception e){e.printStackTrace();}



        //Initialize new scene using the root controller class we made
        RootController scene = new RootController();

        //Run launchScene method we created in the root controller class
        scene.launchScene(args);
    }
}
