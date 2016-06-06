package persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoJpa
{
	private static String PERSISTENCE_UNIT_NAME = "";
	private EntityManagerFactory factory;
	private static ConexaoJpa instance = null;

	private ConexaoJpa()
	{
		if(Banco.getBanco() instanceof BancoMySql)		
			PERSISTENCE_UNIT_NAME = "mysql";		
		else if(Banco.getBanco() instanceof BancoPostGree)
			PERSISTENCE_UNIT_NAME = "postgree";
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public EntityManagerFactory getFactory()
	{
		return factory;
	}

	public static ConexaoJpa getInstance()
	{
		if (instance == null)
		{
			instance = new ConexaoJpa();
		}
		return instance;
	}

	private void destroyFactory()
	{
		factory.close();
	}

	public static void destroyInstance()
	{
		if (instance != null)
		{
			instance.destroyFactory();
			instance = null;
		}
	}
}
