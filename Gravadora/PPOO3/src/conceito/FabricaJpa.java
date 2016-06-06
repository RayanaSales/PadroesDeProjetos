package conceito;

import dao.ArtistaDao;
import dao.ArtistaJpa;
import dao.MusicaDao;
import dao.MusicaJpa;

public class FabricaJpa extends Fabrica
{
	@Override
	public ArtistaDao criarArtista()
	{
		return new ArtistaJpa();
	}

	@Override
	public MusicaDao criarMusica()
	{
		return new MusicaJpa();
	}	
}
