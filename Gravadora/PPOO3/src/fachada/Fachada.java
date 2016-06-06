package fachada;

import java.util.List;

import model.Artista;
import model.Musica;
import view.FalaSobreArtista;
import view.FalaSobreMusica;
import controladores.ControladorArtista;
import controladores.ControladorMusica;

public class Fachada
{
	private static Fachada fachada = null;

	private ControladorMusica controladorMusica = null;
	private ControladorArtista controladorArtista = null;
	private FalaSobreArtista falaArtista = null;
	private FalaSobreMusica falaMusica = null;

	private Fachada()
	{
		this.controladorMusica = new ControladorMusica();
		this.controladorArtista = new ControladorArtista();
		this.falaMusica = new FalaSobreMusica();
		this.falaArtista = new FalaSobreArtista();
	}

	public static Fachada getInstancia() // SINGLETON
	{
		if (fachada == null)
			fachada = new Fachada();
		return fachada;
	}

	public void inserirArtista(String nome, String pseudonimo,
			String nacionalidade, String estiloMusical, int idade)
	{
		this.controladorArtista.controlarInsercao(nome, pseudonimo,
				nacionalidade, estiloMusical, idade);
	}

	public void pegaDadosDoCadastroArtista()
	{
		this.falaArtista.pegaDadosCadastroArtista();
	}

	public void realizaOperacaoArtista(int operacao)
	{
		this.controladorArtista.resolveOperacao(operacao);
	}

	public void obterIdArtista(int i)
	{
		falaArtista.pegaId(i);
	}

	public void removerArtista(int id)
	{
		this.controladorArtista.controlarRemocao(id);
	}

	public void visualizaArtista(int id)
	{
		controladorArtista.controlarVisualizacao(id);
	}

	public void visualizarListarDeArtistas(List<Artista> listaDeArtistas)
	{
		falaArtista.listarArtistas(listaDeArtistas); 
	}
	
	
	public void exibiArtista(Artista a)
	{
		falaArtista.listarArtista(a);
	}
	
	public void pedeIdParaAlteracao(int id)
	{
		this.controladorArtista.controlarAlteracao(id);
	}
	
	public String pedeValorParaAlteracao()
	{
		return falaArtista.pedeDadosParaAlteracao();
	}
	
	public void inserirMusica(String nome, String album, String duracao)
	{
		 this.controladorMusica.controlarInsercao(nome, album, duracao);
	}

	public void pegaDadosDoCadastroMusica()
	{
		 this.falaMusica.pegaDadosCadastroMusica();
	}

	public void realizaOperacaoMusica(int operacao)
	{
		 this.controladorMusica.resolveOperacao(operacao);
	}

	public void obterIdMusica(int i)
	{
		 falaMusica.pegaId(i);
	}

	public void removerMusica(int id)
	{
		 this.controladorMusica.controlarRemocao(id);
	}

	public void visualizaMusica(int id)
	{
		this.controladorMusica.controlarVisualizacao(id);
	}
	
	public void visualizarListarDeMusicas(List<Musica> listaDeMusicas)
	{
		falaMusica.listarMusicas(listaDeMusicas); 
	}
	
	
	public void exibiMusica(Musica m)
	{
		falaMusica.listarMusica(m);
	}

	public void pedeIdParaAlteracaoMusica(int id)
	{
		this.controladorMusica.controlarAlteracao(id);
	}

	public String pedeValorParaAlteracaoMusica()
	{
		return falaMusica.pedeDadosParaAlteracaoMusica();
	}
	

}
