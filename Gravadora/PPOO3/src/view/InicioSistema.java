package view;

import persistencia.Banco;

public class InicioSistema
{
	public static void main(String[] args)
	{
		FalaSobreMusica falaMusica = new FalaSobreMusica();
		FalaSobreArtista falaArtista = new FalaSobreArtista();
		
		String tecnologia = "", tipoBanco = "";
		tecnologia = FalaGeral.escolherTecnologia();
		tipoBanco = FalaGeral.escolherTipoBanco();
		
		Banco.escolheBanco(tecnologia, tipoBanco);
		
		while (true)
		{
			int op = FalaGeral.escolheMenu();			
			if(op == 1)			
				falaArtista.opcoesMenu();			
			else if(op == 2)			
				falaMusica.opcoesMenu();		
		}
	}
}
