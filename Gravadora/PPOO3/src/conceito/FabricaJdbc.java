package conceito;

import dao.ArtistaDao;
import dao.ArtistaJdbc;
import dao.MusicaDao;
import dao.MusicaJdbc;

public class FabricaJdbc extends Fabrica
{
	@Override
	public ArtistaDao criarArtista()
	{
		return new ArtistaJdbc();
	}

	@Override
	public MusicaDao criarMusica()
	{
		return new MusicaJdbc();
	}
}
