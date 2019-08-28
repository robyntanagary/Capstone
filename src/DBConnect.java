import java.sql.*;

public class DBConnect
{
	static Connection con = null;
	static String dbName = "";
	static String url = "jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false" + dbName;
	static String username = "root";
	static String password = "root";
	
	public void attemptConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, username, password);
			/*PreparedStatement ps = con.prepareStatement("INSERT INTO capstonedb.academic(academicNumber) VALUES('A000007');");
			
			int status = ps.executeUpdate(); //returns int value, success >0
			if(status != 0)
			{
				System.out.println("success!");
			}*/
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
