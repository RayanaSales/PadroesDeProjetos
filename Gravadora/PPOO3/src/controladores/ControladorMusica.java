package controladores;

import java.util.List;
import model.Musica;
import persistencia.Banco;
import dao.MusicaDao;
import fachada.Fachada;

public class ControladorMusica
{
	MusicaDao musicaDao = null;

	public ControladorMusica()
	{
		musicaDao = Banco.getFabrica().criarMusica();
	}

	public void resolveOperacao(int operacao)
	{// Escolhe entre remover, salvar, alterar e listar.
		switch (operacao)
		{
			case 1:
				Fachada.getInstancia().pegaDadosDoCadastroMusica();
			break;
			case 2:
				Fachada.getInstancia().obterIdMusica(1);
			break;
			case 3:
				controlarListarTodos();
				Fachada.getInstancia().obterIdMusica(2);
			break;
			case 4:
				Fachada.getInstancia().obterIdMusica(4);
			break;
			case 5:
				controlarListarTodos();
				break;
		}

	}

	public void controlarInsercao(String nome, String album, String duracao)
	{
		Musica m = new Musica();
		m.setNome(nome);
		m.setAlbum(album);
		m.setDuracao(duracao);

		// ARMAZENA NO BANCO.
		String sql = "insert into musica (nome, album, duracao, id) " + "values (?,?,?,?)";
		sql = Banco.getBanco().validaSql(sql);
		musicaDao.inserir(m, sql);
		
		System.out.println("SALVEI MÚSICA!");
	}

	public void controlarRemocao(int id)
	{
		String sql = "delete from musica where album = ?";	
		sql = Banco.getBanco().validaSql(sql);
		musicaDao.remover(id, sql);
		System.out.println("REMOVI MÚSICA!");
	}

	//FALTA O ALTERAR
	public void controlarAlteracao(int id)
	{
		String sql = "select * from musica where id = ?";
		Musica m = musicaDao.buscarMusica(id, sql);
		Fachada.getInstancia().exibiMusica(m);
		String campoNovoValor = Fachada.getInstancia().pedeValorParaAlteracaoMusica();
		String array[] = new String[2]; 
		array = campoNovoValor.split(";");
		
		System.out.println("Campo  : " + array[0]);
		System.out.println("NovoValor  : " + array[1]);
		
		
			switch (array[0])
			{
				case "nome":
					m.setNome(array[1]);
					break;
				case "album":
					m.setAlbum(array[1]);
					break;
				case "duracao":
					m.setDuracao(array[1]);
					break;
				default:
				break;
			}
		
		sql = "UPDATE musica SET nome = ?, album = ?, duracao = ? WHERE id = ?";
		sql = Banco.getBanco().validaSql(sql);
		musicaDao.alterar(m, sql);
	}

	public void controlarVisualizacao(int id)
	{
		String sql = "select * from musica where id = ?";
		sql = Banco.getBanco().validaSql(sql);
		Musica m = musicaDao.buscarMusica(id, sql);
		Fachada.getInstancia().exibiMusica(m);
	}
	
	public void controlarListarTodos()
	{
		List<Musica> listaDeMusicas = musicaDao.listarTodos("select * from musica");
		Fachada.getInstancia().visualizarListarDeMusicas(listaDeMusicas);
	}
	
}
