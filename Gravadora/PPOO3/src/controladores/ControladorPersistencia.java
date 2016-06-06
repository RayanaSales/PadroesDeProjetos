package controladores;

import persistencia.Banco;

public class ControladorPersistencia
{
	public void decidirBancoETecnologia()
	{
		String tecn = "";
		String bancoFlag = "";

		// Pergnta qual a tecnologia e o banco

		Banco.escolheBanco(tecn, bancoFlag);
	}
}
