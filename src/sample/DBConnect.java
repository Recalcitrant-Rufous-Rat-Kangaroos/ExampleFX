package sample;

import java.sql.*;

public class DBConnect
{
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rslt = null;

    public static void setUpDB() throws Exception
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            throw e;
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:derby:testDB;create=true");
            stmt = conn.createStatement();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    public static void createSampleTable()  throws Exception
    {
        try
        {
            stmt.execute("CREATE TABLE students(" +
                    "identification int," +
                    "name VARCHAR(100)," +
                    "age int)");
        }
        catch(SQLException e)
        {

            if(e.getErrorCode() == 30000){} else
            {
                e.printStackTrace();
                throw e;
            }
        }

        try
        {
          //  stmt.execute("SELECT * FROM students");
            stmt.executeUpdate("INSERT INTO students VALUES (1, 'billy', 15)");
//            rslt = stmt.getGeneratedKeys();
//            for(int i = 0; rslt.next(); i++)
//            {
//                System.out.println(rslt.getInt(i));
//            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public static String yoink() throws Exception{
        try{
            stmt.executeQuery("SELECT name FROM students");
            rslt = stmt.getGeneratedKeys();
            return rslt.toString();
        } catch(Exception e){
            throw e;
            //throw new Exception("It didn't work");
        }
    }

}
