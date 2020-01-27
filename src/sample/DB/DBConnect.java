package sample.DB;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;

public class DBConnect
{
    private static Connection conn = null; //Connection is an interface (ie we cannot instantiate it
    private static Statement statement = null; //This is also an interface
    private static ResultSet rslt = null;

    private static String url = "jdbc:derby:nodeDB;create=true";
    private static String userName = "admin";
    private static String password = "Password";

    public static void setUpNodeDB() throws Exception
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
        ResultSet request = statement.executeQuery("SELECT * FROM "+ tableName.toUpperCase() + " WHERE id=" + data.charAt(1));
        if(request.next()){
            throw new Exception("This already exists");
        }
        try{
            statement.executeUpdate("INSERT INTO " + tableName.toUpperCase() + " VALUES " + data);
        } catch(Exception e){
            throw e;
        }
    }

    public static String getName(String[] args) throws Exception
    {
        String addArgs = "";
        String stringResults = "";
        try{
            ResultSet results = statement.executeQuery("SELECT " + args[1].toUpperCase() + " FROM " + args[0].toUpperCase() + addArgs.toUpperCase());
            while(results.next()){
                stringResults += results.getString(1) + ", ";
            };
            return stringResults;
        } catch(Exception e){
            throw e;
        }

    }

    public static void deleteRowByID(String table, int id) throws Exception
    {
        try{
            int rows = statement.executeUpdate("DELETE FROM " + table.toUpperCase() + " WHERE id=" + id);
            System.out.println(rows + " rows updated");
        }catch(Exception e){
            throw e;
        }
    }

    public static void deleteTableByName(String table) throws Exception
    {
        try{
            statement.executeUpdate("DROP TABLE "+ table.toUpperCase());
        }catch(Exception e){
            throw e;
        }
    }


}
