package view;

import java.util.List;

import fachada.Fachada;
import model.Musica;

public class FalaSobreMusica extends FalaGeral
{
	
	public  void pegaDadosCadastroMusica()
	{
		String nome, album, duracao;
		
		System.out.println("Informe o nome");
		nome = input.next();
		
		System.out.println("Informe o álbum");
		album = input.next();
		
		System.out.println("Informe a duração");
		duracao = input.next();
		
		Fachada.getInstancia().inserirMusica(nome, album, duracao);		
	}
	
	
	public static void opcaoSelecionada(Musica info)
	{
		System.out.println("Você selecionou: " + info.getNome());
	}
	
	public static int alterarMusica()
	{
		System.out
		.println("Qual dado deseja alterar? 1-Nome 2-Álbum 3-Duração ");
		return input.nextInt();
	}
	
	public void opcoesMenu()
	{
		System.out.println("O que deseja fazer? 1 - Salvar; 2 - Remover; 3 - Atualizar; 4 - Listar uma música 5 - Listar todas");
		Fachada.getInstancia().realizaOperacaoMusica(input.nextInt());
	}
	
	public void pegaId(int i)
	{
		System.out.println("Informe o ID :");
		switch (i)
		{
			case 1:
				Fachada.getInstancia().removerMusica(input.nextInt());
				break;
			case 2:
				Fachada.getInstancia().pedeIdParaAlteracaoMusica(input.nextInt());
				break;
			case 3:
				break;
			case 4:
				Fachada.getInstancia().visualizaMusica(input.nextInt());
				break;
			default:
			break;
		}
		
	}
	
	public static String pegaNovoValor()
	{
		System.out.println("Qual será o novo valor do dado selecionado?");
		return input.nextLine();
	}
	
	public void listarMusicas(List<Musica> listaDeMusicas)
	{
		for (Musica musica : listaDeMusicas)
		{
			System.out.println("ID : " + musica.getId() + " *** Nome :  " + musica.getNome() );
		}
	}

	public void listarMusica(Musica musica)
	{
		System.out.println("***************** MUSICA ********************");
		System.out.println("Nome : " + musica.getNome());
		System.out.println("Album : " + musica.getAlbum());
		System.out.println("Duração : " + musica.getDuracao());
		System.out.println("Id : " + musica.getId());
	}

	public String pedeDadosParaAlteracaoMusica()
	{
		System.out.println("Qual informação deseja alterar?");
		String campoNovoValor  = input.nextLine() + ";";
		campoNovoValor  = input.nextLine() + ";";
		System.out.println("Qual será o novo valor?");
		campoNovoValor += input.nextLine();
		
		return campoNovoValor;
		
	}
	
}
