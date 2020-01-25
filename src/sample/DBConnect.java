package sample;

import java.sql.*;

public class DBConnect
{
    private static Connection conn = null; //Connection is an interface (ie we cannot instantiate it
    private static Statement statement = null; //This is also an interface
    private static ResultSet rslt = null;

    private static String url = "jdbc:derby:secondDB;create=true";
    private static String userName = "admin";
    private static String password = "Password";

    public static void setUpDB() throws Exception
    {
        try
        {
            //Class.forName loads a class
            // We need to load the driver class
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(url, userName, password);
            statement = conn.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public static void createTable(String tableName, String data) throws Exception
    {
        try
        {
            DatabaseMetaData meta = conn.getMetaData();

            //When searching for strings, use the String.toUpperCase() function. Because SQL is bullshit
            ResultSet eqTables = meta.getTables(null, null, tableName.toUpperCase(), null);
            if(eqTables.next()){
                System.out.println("This table already exists");
            } else {
                statement.execute("CREATE TABLE " + tableName + data);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void addRow(String tableName, String data) throws Exception
    {
        try{
            statement.executeUpdate("INSERT INTO " + tableName.toUpperCase() + " VALUES " + data);
        } catch(Exception e){
            throw e;
        }
    }

    public static String getName(int row) throws Exception
    {
        try{
            ResultSet results = statement.executeQuery("SELECT SPECIES FROM ALIENS");
            int rowIndex = 1;
            while(results.next()){
                if(rowIndex == row){
                    return results.toString();
                }
                rowIndex++;
            }
            throw(new Exception("Species not found"));
        } catch(Exception e){
            throw e;
        }

    }

}
