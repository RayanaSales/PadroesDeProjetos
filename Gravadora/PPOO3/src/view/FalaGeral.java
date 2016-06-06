package view;

import java.util.Scanner;

public class FalaGeral
{
static Scanner input = new Scanner(System.in);
	
	public static int escolheMenu()
	{
		int op;
		System.out.println("Qual menu deseja acessar? 1-Artista 2-Música");
		
		op = input.nextInt();
		
		return op;
	}
	
	public static String escolherTecnologia()
	{
		String flag_banco =""; 
		
		System.out.println("Com qual tecnologia deseja persistir os dados? 1-Jpa 2-Jdbc");
		int op = input.nextInt();
		
		if(op == 1)
			flag_banco = "jpa";
		else if(op == 2) flag_banco = "jdbc";
		
		return flag_banco;
	}
	
	public static String escolherTipoBanco()
	{
		String flag_banco =""; 
		
		System.out.println("Com qual tipo de banco deseja persistir os dados? 1-MySql 2-PostGree");
		int op = input.nextInt();
		
		if(op == 1)
			flag_banco = "mysql";
		else if(op == 2) flag_banco = "postgree";
		
		return flag_banco;
	}
	
//	public static int opcoesMenu()
//	{
//		System.out.println("O que deseja fazer? 1-Salvar; 2-Remover; 3-Atualizar; 4-Listar");
//		return input.nextInt();
//	}
	
//	public static int pegaId()
//	{
//		System.out.println("Informe o ID :");
//		return input.nextInt();
//	}
//	
//	public static String pegaNovoValor()
//	{
//		System.out.println("Qual será o novo valor do dado selecionado?");
//		return input.nextLine();
//	}
}
