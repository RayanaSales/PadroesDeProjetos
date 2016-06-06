package dao;
import java.util.List;
import model.Musica;

public interface MusicaDao
{
	public void inserir(Musica musica, String sql);
	
	public void alterar(Musica musica, String sql); // PODE SOBRE ALTERAÇÕES
	
	public List<Musica> listarTodos(String sql);
	
	public Musica buscarMusica(int id, String sql);
	
	public void remover(int id, String sql);
}
