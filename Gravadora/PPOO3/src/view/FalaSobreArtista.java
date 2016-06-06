package view;

import java.util.List;
import java.util.Scanner;

import model.Artista;
import fachada.Fachada;

public class FalaSobreArtista extends FalaGeral
{
	 Scanner input = new Scanner(System.in);	
	
	public void pegaDadosCadastroArtista()
	{
		String nome, pseudonimo, nacionalidade, estiloMusical;
		int idade;
		
		System.out.println("Informe o nome : ");
		nome = input.nextLine();
		
		System.out.println("Informe o pseudonimo : ");
		pseudonimo = input.nextLine();

		System.out.println("Informe a nacionalidade : ");
		nacionalidade = input.nextLine();

		System.out.println("Informe o estilo musical : ");
		estiloMusical = input.nextLine();
		
		System.out.println("Informe a idade : ");
		idade = input.nextInt();
		
		Fachada.getInstancia().inserirArtista(nome, pseudonimo, nacionalidade, estiloMusical, idade);
	}
	
	public void opcoesMenu()
	{
		System.out.println("O que deseja fazer? 1 - Salvar; 2 - Remover; 3 - Atualizar; 4 - Listar um artista 5 - Listar todos ");
		Fachada.getInstancia().realizaOperacaoArtista(input.nextInt());
	}
	
	public  void opcaoSelecionada(Artista info)
	{
		System.out.println("Você selecionou: " + info.getNome());
	}
	
	public  int alterarArtista()
	{
		System.out
		.println("Qual dado deseja alterar? 1-Nome 2-Pseudônimo 3-Nacionalidade 4-Estilo musical 5-Idade ");
		return input.nextInt();
	}
	
	public void pegaId(int i)
	{
		System.out.println("Informe o ID :");
		switch (i)
		{
			case 1:
				Fachada.getInstancia().removerArtista(input.nextInt());
				break;
			case 2:
				Fachada.getInstancia().pedeIdParaAlteracao(input.nextInt());
				break;
			case 3:
				break;
			case 4:
				Fachada.getInstancia().visualizaArtista(input.nextInt());
				break;
			default:
			break;
		}
		
	}
	
	public String pegaNovoValor()
	{
		System.out.println("Qual será o novo valor do dado selecionado?");
		return input.nextLine();
	}
	
	public void listarArtistas(List<Artista> listaDeArtistas)
	{
		for (Artista artista : listaDeArtistas)
		{
			System.out.println("ID : " + artista.getId() + " *** Nome :  " + artista.getNome() );
		}
	}

	public void listarArtista(Artista artista)
	{
		System.out.println("***************** ARTISTA ********************");
		System.out.println("Nome : " + artista.getNome());
		System.out.println("Pseudonimo : " + artista.getPseudonimo());
		System.out.println("Nacionalidade : " + artista.getNacionalidade());
		System.out.println("Idade : " + artista.getIdade());
		System.out.println("Estilo Musical : " + artista.getEstiloMusical());
		System.out.println("ID : " + artista.getId());
	}
	
	public String pedeDadosParaAlteracao()
	{
		System.out.println("Qual informação deseja alterar?");
		String campoNovoValor  = input.nextLine() + ";";
		campoNovoValor  = input.nextLine() + ";";
		System.out.println("Qual será o novo valor?");
		campoNovoValor += input.nextLine();
		
		return campoNovoValor;
		
	}

}
