package persistencia;
import java.sql.Connection;

import conceito.Fabrica;
import conceito.FabricaJdbc;
import conceito.FabricaJpa;

public abstract class Banco //ESSA EH A PONTE - escolhe a fabrica e o banco
{
	private static Banco banco =  null;
	private static Fabrica fabrica = null;
	
	protected Banco()
	{
		
	}
	
	public static Banco getBanco()
	{
		if (banco != null)
		{
			return banco;
		}
		else
		{
			System.out.println("Banco null");
			return null;
		}
	}
	
	public static Fabrica getFabrica()
	{
		if(fabrica != null)
		{
			return fabrica;
		}
		else
		{
			System.out.println("Fabrica null");
			return null;
		}
	}

	private static void escolheFabrica(String flag) // jpa ou jdbc?
	{
		if (flag.equals("jpa"))
			fabrica = new FabricaJpa();

		else if (flag.equals("jdbc"))
			fabrica = new FabricaJdbc();
	}

	public static void escolheBanco(String fabrica, String banco2)
	{
		escolheFabrica(fabrica);

		if (banco == null)
		{
			if (banco2.equals("mysql"))
				banco = new BancoMySql();
			else if (banco2.equals("postgree"))
				banco = new BancoPostGree();
		}
	}

	public abstract Connection getConnection();

	public abstract String validaSql(String sql); // esse sql validado, eh o q
													// vai ser executado, la no
													// artistajdbc
}
