package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musica
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String nome;

	@Column
	private String album;

	@Column
	private String duracao;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getAlbum()
	{
		return album;
	}

	public void setAlbum(String album)
	{
		this.album = album;
	}

	public String getDuracao()
	{
		return duracao;
	}

	public void setDuracao(String duracao)
	{
		this.duracao = duracao;
	}

	public String toString()
	{
		String s = "";

		s = "Nome: " + this.nome + " Albúm: " + this.album + " Duração: "
				+ this.duracao;

		return s;
	}
}
