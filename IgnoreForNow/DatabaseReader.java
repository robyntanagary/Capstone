/**
 * Class representing a DataBase reader.
 * @author Tana Feyt (FYTTAN001), Gary Lu (LXXWEN005) Robyn Mckenzie (MCKROB018)
 */
import java.sql.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

public class DatabaseReader
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/MatricUniDB";
    private static final String USERNAME = "dbReader";
    private static final String PASSWORD = "dbReader";
    private static Connection connection = null;
    private static Statement statement = null;
    
    /**
     * Method runs query and returns a result set.
     * @param query Query to run.
     * @return Returns ResultSet obtained from running query.
     */
    private static ResultSet runQuery(String query)
    {
        ResultSet temp = null;
        try
        {
            statement = connection.createStatement();
            temp =  statement.executeQuery(query);
        }
        catch (SQLException se)
        {
            se.printStackTrace();    
        }
        return temp;   
    }
    

    /**
     * Method runs query and returns a result set.
     * @param update_query Query to update table.
     * @return Returns the number of updated rows from running query.
     */
    private static int runUpdate(String update_query)
    {
        int temp = 0;
        try
        {
            statement = connection.createStatement();
            temp =  statement.executeUpdate(update_query);
        }
        catch (SQLException se)
        {
            se.printStackTrace();    
        }
        return temp;   
    }

    
    /**
     * Main method provides a text interface for user to access data from database.
     * @param args n/a to program.
     */
    public static void main(String [] args)
    {
        try
        {
            try
            {
                Class.forName(DRIVER);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
	    runQuery("SET SQL_SAFE_UPDATES=0");

        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        
        finally
        {
            try
            {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }    
        }
    }
}
