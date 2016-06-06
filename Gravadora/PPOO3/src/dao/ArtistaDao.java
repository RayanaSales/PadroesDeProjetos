package dao;

import java.util.List;

import model.Artista;

public interface ArtistaDao
{
	public void inserir(Artista artista, String sql);
	
	public void alterar(Artista artista, String sql); // PODE SOBRE ALTERAÇÕES
	
	public List<Artista> listarTodos(String sql);
	
	public Artista buscarArtista(int id, String sql);
	
	public void remover(int id, String sql);	
}
