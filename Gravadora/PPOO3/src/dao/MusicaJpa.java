package dao;
import java.util.List;
import javax.persistence.EntityManager;
import model.Musica;
import persistencia.ConexaoJpa;

public class MusicaJpa implements MusicaDao
{
	@Override
	public void inserir(Musica musica, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(musica);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Musica musica, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(musica);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musica> listarTodos(String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		// abre conexão
		em.getTransaction().begin();

		javax.persistence.Query consulta = em
				.createQuery("select musica from Musica musica");
		List<Musica> musicas = consulta.getResultList();
		return musicas;
	}

	@Override
	public Musica buscarMusica(int id, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Musica musica = em.find(Musica.class, id);
		em.getTransaction().commit();
		em.close();

		return musica;
	}

	@Override
	public void remover(int id, String sql)
	{
		Musica musica;
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		musica = em.find(Musica.class, id);
		em.remove(musica);
		em.getTransaction().commit();
		em.close();
	}

}
