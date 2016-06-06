package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoMySql extends Banco
{
	private static BancoMySql con = null;
	
	public BancoMySql()
	{
		super();
	}
	public static BancoMySql getInstance()
	{
		if (con == null)
			con = new BancoMySql();

		return con;
	}

	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gravadora", "root", "root");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public String validaSql(String sql)
	{
		System.out.println("Transformei o sql em um comando valido para o postgree");
		return sql;
	}
}
