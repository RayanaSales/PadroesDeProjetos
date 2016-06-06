package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoPostGree extends Banco
{
	private static BancoPostGree con = null;
	
	public static Banco getInstance()
	{
		if(con == null)
			con = new BancoPostGree();
		return con;
	}

	@Override
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gravadora","root","root");
				
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
