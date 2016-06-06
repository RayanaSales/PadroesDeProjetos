package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.Banco;
import model.Musica;

public class MusicaJdbc implements MusicaDao
{
	@Override
	public void inserir(Musica musica, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		
		try
		{
			con = Banco.getBanco().getConnection();			
			stmt = con.prepareStatement(sql);			
			
			stmt.setString(1, musica.getNome());
			stmt.setString(2, musica.getAlbum());			
			stmt.setString(3, musica.getDuracao());
			stmt.setInt(4, musica.getId());
			stmt.executeUpdate();			
		}		
		catch(Exception e)
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
		catch(Exception e)
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
	
	//FALTA IMPLEMENTAR
	@Override
	public void alterar(Musica musica, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		
		try
		{
			con = Banco.getBanco().getConnection();			
			stmt = con.prepareStatement(sql);			
			
			stmt.setString(1, musica.getNome());
			stmt.setString(2, musica.getAlbum());			
			stmt.setString(3, musica.getDuracao());
			stmt.setInt(4, musica.getId());
			stmt.executeUpdate();			
		}		
		catch(Exception e)
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
	public List<Musica> listarTodos(String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		List<Musica> musicas = new ArrayList<Musica>();
		
		try
		{
			con = Banco.getBanco().getConnection();			
			
			stmt = con.prepareStatement(sql);			
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next()) 
			{
				Musica musica = new Musica();
				
				musica.setNome(rs.getString("nome"));
				musica.setAlbum(rs.getString("album"));
				musica.setDuracao(rs.getString("duracao"));
				musica.setId(rs.getInt("id"));
								
				musicas.add(musica);
			}		
		}
		catch(Exception e)
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
		
		return musicas;	
	}

	//FALTA IMPLEMENTAR
	@Override
	public Musica buscarMusica(int id, String sql)
	{
		PreparedStatement stmt = null;
		Connection con = null;
		Musica musica = new Musica();

		try
		{
			con = Banco.getBanco().getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
			{
				musica.setNome(rs.getString("nome"));
				musica.setAlbum(rs.getString("album"));
				musica.setDuracao(rs.getString("duracao"));
				musica.setId(rs.getInt("id"));
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

		return musica;
	}
}
