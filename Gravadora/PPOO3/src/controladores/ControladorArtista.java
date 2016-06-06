package controladores;
import java.util.List;

import model.Artista;
import persistencia.Banco;
import dao.ArtistaDao;
import fachada.Fachada;

public class ControladorArtista
{	
	ArtistaDao artistaDao = null;
	
	public ControladorArtista()
	{
		artistaDao = Banco.getFabrica().criarArtista();
	}
	
	public void resolveOperacao(int operacao)
	{// Escolhe entre remover, salvar, alterar e listar.
		switch (operacao)
		{
			case 1:
				Fachada.getInstancia().pegaDadosDoCadastroArtista();
				break;
			case 2:
				Fachada.getInstancia().obterIdArtista(1);
				break;
			case 3:
				controlarListarTodos();
				Fachada.getInstancia().obterIdArtista(2);
				break;
			case 4:
				Fachada.getInstancia().obterIdArtista(4);
				break;
			case 5:
				controlarListarTodos();
				break;
		}			
	}

	public void controlarInsercao(String nome, String pseudonimo, String nacionalidade, String estiloMusical,int idade)
	{
		Artista a = new Artista();
		a.setNome(nome);
		a.setPseudonimo(pseudonimo);
		a.setNacionalidade(nacionalidade);
		a.setEstiloMusical(estiloMusical);
		a.setIdade(idade);		
		
		// ARMAZENA NO BANCO.
		//Monta sql, valida, chama o metodo de inserir artistaDao					
		String sql = "insert into artista (nome, pseudonimo, nacionalidade, estilomusical, idade, id) " + "values (?,?,?,?,?,?)";		
		sql = Banco.getBanco().validaSql(sql);
		artistaDao.inserir(a, sql);
		
	}
	
	public void controlarRemocao(int id)
	{		
		String sql = "delete from artista where id = ?";
		sql = Banco.getBanco().validaSql(sql);
		artistaDao.remover(id, sql);
		
	}
	
	//FALTA O ALTERAR
	public void controlarAlteracao(int id)
	{
		
		String sql = "select * from artista where id = ?";
		Artista a = artistaDao.buscarArtista(id, sql);
		Fachada.getInstancia().exibiArtista(a);
		String campoNovoValor = Fachada.getInstancia().pedeValorParaAlteracao();
		String array[] = new String[2]; 
		array = campoNovoValor.split(";");
		
		System.out.println("Campo  : " + array[0]);
		System.out.println("NovoValor  : " + array[1]);
		
		
			switch (array[0])
			{
				case "nome":
					a.setNome(array[1]);
					break;
				case "nacionalidade":
					a.setNacionalidade(array[1]);
					break;
				case "pseudonimo":
					a.setPseudonimo(array[1]);
					break;
				case "estilomusical":
					a.setEstiloMusical(array[1]);
					break;
				case "idade":
					int idade = Integer.parseInt(array[1]); 
					a.setIdade(idade);
					System.out.println(a.getIdade());
					break;
				default:
				break;
			}
		
		sql = "UPDATE artista SET nome = ?, pseudonimo = ?, nacionalidade = ?, idade = ?, estilomusical = ? WHERE id = ?";
		sql = Banco.getBanco().validaSql(sql);
		artistaDao.alterar(a, sql);
	}
	
	public void controlarVisualizacao(int id)
	{
		String sql = "select * from artista where id = ?";
		sql = Banco.getBanco().validaSql(sql);
		Artista a = artistaDao.buscarArtista(id, sql);
		Fachada.getInstancia().exibiArtista(a);
	
	}
	
	public void controlarListarTodos()
	{
		List<Artista> listaDeArtistas = artistaDao.listarTodos("select * from artista");
		Fachada.getInstancia().visualizarListarDeArtistas(listaDeArtistas);
	}
}
