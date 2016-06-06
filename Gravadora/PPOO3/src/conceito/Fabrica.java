package conceito;

import dao.ArtistaDao;
import dao.MusicaDao;

public abstract class Fabrica
{		
	public abstract ArtistaDao criarArtista();
	
	public abstract MusicaDao criarMusica();
}
