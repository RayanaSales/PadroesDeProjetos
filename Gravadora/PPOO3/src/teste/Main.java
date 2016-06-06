package teste;

import dao.ArtistaDao;
import persistencia.Banco;

public class Main
{
	public static void main(String[] args)
	{
		escolheTecnologiaEBanco("jpa", "mysql");
	}
	
	public static void escolheTecnologiaEBanco(String tecnologia, String tipobanco)
	{
		Banco.escolheBanco(tecnologia, tipobanco);
		
		//daq para baixo quem faz eh o controlador, e quem chama esse controlador, eh a view.		
		System.out.println("CRIEI A FÁBRICA E O BANCO! HAAAAAAAA");
		ArtistaDao artista = Banco.getFabrica().criarArtista();		
		Banco.getBanco().getConnection();	
		String sql = Banco.getBanco().validaSql("lala");				
		artista.remover(3, sql); //controlador
	}
}
