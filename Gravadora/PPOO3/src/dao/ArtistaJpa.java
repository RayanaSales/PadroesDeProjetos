package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Artista;
import persistencia.ConexaoJpa;

public class ArtistaJpa implements ArtistaDao
{
	@Override
	public void remover(int id, String sql)
	{
		Artista artista;

		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		artista = em.find(Artista.class, id);
		em.remove(artista);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void inserir(Artista artista, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(artista);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Artista artista, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(artista);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> listarTodos(String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		// abre conexão
		em.getTransaction().begin();

		javax.persistence.Query consulta = em.createQuery("select artistaDao from Artista artistaDao");
		List<Artista> artistas = consulta.getResultList();
		
		return artistas;
	}

	@Override
	public Artista buscarArtista(int id, String sql)
	{
		EntityManager em = ConexaoJpa.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Artista artista = em.find(Artista.class, id);
		em.getTransaction().commit();
		em.close();

		return artista;
	}
}
