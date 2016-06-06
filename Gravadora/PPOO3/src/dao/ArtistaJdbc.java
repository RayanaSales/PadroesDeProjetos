package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Artista;
import persistencia.Banco;

public class ArtistaJdbc implements ArtistaDao
{
	@Override
	public void remover(int id, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		try
		{
			con = Banco.getBanco().getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void inserir(Artista artista, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;

		try
		{
			con = Banco.getBanco().getConnection();

			stmt = con.prepareStatement(sql);

			stmt.setString(1, artista.getNome());
			stmt.setString(2, artista.getPseudonimo());
			stmt.setString(3, artista.getNacionalidade());
			stmt.setString(4, artista.getEstiloMusical());
			stmt.setInt(5, artista.getIdade());
			stmt.setInt(6, artista.getId());

			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// FALTA IMPLEMENTAR
	@Override
	public void alterar(Artista artista, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;

		try
		{
			con = Banco.getBanco().getConnection();

			stmt = con.prepareStatement(sql);

			stmt.setString(1, artista.getNome());
			stmt.setString(2, artista.getPseudonimo());
			stmt.setString(3, artista.getNacionalidade());
			stmt.setInt(4, artista.getIdade());
			stmt.setString(5, artista.getEstiloMusical());
			stmt.setInt(6, artista.getId());

			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public List<Artista> listarTodos(String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		ArrayList<Artista> artistas = new ArrayList<Artista>();

		try
		{
			con = Banco.getBanco().getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next())
			{
				Artista artista = new Artista();

				artista.setNome(rs.getString("nome"));
				artista.setPseudonimo(rs.getString("pseudonimo"));
				artista.setNacionalidade(rs.getString("nacionalidade"));
				artista.setEstiloMusical(rs.getString("estiloMusical"));
				artista.setIdade(rs.getInt("idade"));
				artista.setId(rs.getInt("id"));

				artistas.add(artista);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return artistas;
	}

	// FALTA IMPLEMENTAR
	@Override
	public Artista buscarArtista(int id, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		Artista artista = new Artista();

		try
		{
			con = Banco.getBanco().getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
			{
				artista.setNome(rs.getString("nome"));
				artista.setPseudonimo(rs.getString("pseudonimo"));
				artista.setNacionalidade(rs.getString("nacionalidade"));
				artista.setEstiloMusical(rs.getString("estiloMusical"));
				artista.setIdade(rs.getInt("idade"));
				artista.setId(rs.getInt("id"));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return artista;
	}
}
