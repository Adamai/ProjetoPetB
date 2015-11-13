package ufrpe.petbuddy.gui;

import java.util.Scanner;
import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Adocao;
import ufrpe.petbuddy.negocio.beans.Animal;
import ufrpe.petbuddy.negocio.beans.Cachorro;
import ufrpe.petbuddy.negocio.beans.Gato;
import ufrpe.petbuddy.negocio.beans.Outro;
import ufrpe.petbuddy.negocio.beans.Pessoa;

import java.util.InputMismatchException;


public class Teste {

public static void main(String[] args){
	int controlador = 1;
	
	ICadastroAnimal cadastro = new CadastroAnimal();
	ICadastroPessoa cadastrop = new CadastroPessoa();
	ICadastroAdocao cadastroad = new CadastroAdocao();
	CheckEX check = new CheckEX();
	System.out.println("Bem vindo ao Pet Buddy");
	
	while(controlador !=0){	
	
	System.out.println("O Que deseja fazer?");
	System.out.println("1 - Cadastro de Cliente");
	System.out.println("2 - Cadastro de Animais");
	System.out.println("3 - Acessar Animais");
	System.out.println("4 - Adotar Animais");
	
	Scanner scan = new Scanner(System.in);
	int escolha = scan.nextInt();
	
	

	if(escolha == 1){//CADASTRO USUÁRIO

		 String nome;
		 int idade;
		 int contato;
		 String endereco;
		 //String login;
		 //String senha;
		
		 boolean control = true;
		 
		 while(control){
			 Scanner scan5 = new Scanner(System.in);
			 Scanner scan6 = new Scanner(System.in);
			 Scanner scan7 = new Scanner(System.in);
			 Scanner scan8 = new Scanner(System.in);
			 try{
			 System.out.println("Digite seu nome"); // ADD INPUT EXCEPTION SÓ LETRAS
			 nome = scan5.nextLine();
			 check.checaNome(nome);
			 System.out.println("Informe seu numero de contato"); // ADD INPUT EXCEPTION SÓ NUMEROS
			 contato = scan6.nextInt();
			 System.out.println("Insira sua idade"); // ADD INPUT EXCEPTION SÓ NUMEROS
			 idade = scan7.nextInt();
			 System.out.println("Infome seu endereco"); 
			 endereco = scan8.nextLine();
			 		
			 Pessoa p = new Pessoa(nome,idade,contato, endereco,"batata","doce");
			 cadastrop.cadastrarpessoa(p);
			 System.out.println("Cadastro realizado com sucesso");
			 System.out.println(cadastrop.buscanome(nome)); // TRY CATCH
			 control = false;
		 	}
		 catch(InputMismatchException i){
			 System.err.println("Insira somente números");
		 	}
		 catch(NAMException n){
			 System.err.println(n.getMessage());
		 	}
		 }
	}
	
	if(escolha==2){//CADASTRO ANIMAIS
		String nome;
		String raca;
		double peso;
		String idade;
		
		
		System.out.println("1 - Cachorro");
		System.out.println("2 - Gato");
		System.out.println("3 - Outro");
		int escolha2 = scan.nextInt();
		
		if(escolha2 <= 1 ){
			boolean control = true;
			while(control){
			try{
				Scanner scan5 = new Scanner(System.in);
				Scanner scan6 = new Scanner(System.in);
				Scanner scan7 = new Scanner(System.in);
				System.out.println("Digite o nome do cão"); // ADD INPUT EXCEPTION SÓ LETRAS
				nome = scan5.nextLine();
				check.checaNome(nome);
				System.out.println("Digite a raça do cão"); // ADD INPUT EXCEPTION SÓ LETRAS
				raca = scan6.nextLine();
				check.checaNome(raca);
				System.out.println("Informe o sexo do animal");
				System.out.println("1 - Fêmea\n2 - Macho");
				String sexo = null;
				int escsexo = scan7.nextInt();
				if(escsexo <= 1)
					sexo = "Fêmea";
				else
					sexo = "Macho";
			
				System.out.println("Informe o peso"); // ADD INPUT EXCEPTION SÓ NUMEROS
				peso = scan.nextDouble();
		
				System.out.println("Informe a idade"); // ADD INPUT EXCEPTION SÓ NUMEROS
				idade = scan5.nextLine();
	
				Animal a = new Cachorro(nome,raca,sexo,peso,idade,"saudavel","calmo",null);
			
				cadastro.cadastraranimal(a);
				System.out.println("Cadastro realizado com sucesso");
				System.out.print("\n");
				control = false;
			}
			catch(InputMismatchException i){
				System.err.println("Insira somente números");
			}
			catch(NAMException n){
				System.err.println(n.getMessage());
				}
			}
		}
			if(escolha2 == 2){
				try{
					Scanner scan5 = new Scanner(System.in);
					Scanner scan6 = new Scanner(System.in);
					Scanner scan7 = new Scanner(System.in);
					System.out.println("Digite o nome do Gato"); // ADD INPUT EXCEPTION SÓ LETRAS
					nome = scan5.nextLine();
					check.checaNome(nome);
					System.out.println("Digite a raça do Gato"); // ADD INPUT EXCEPTION SÓ LETRAS
					raca = scan6.nextLine();
			
					System.out.println("Informe o sexo do animal");
					System.out.println("1 - Fêmea\n2 - Macho");
					String sexo = null;
					int escsexo = scan7.nextInt();
					if(escsexo <= 1)
						sexo = "Fêmea";
					else
						sexo = "Macho";
				
					System.out.println("Informe o peso"); // ADD INPUT EXCEPTION SÓ NUMEROS
					peso = scan.nextDouble();
			
					System.out.println("Informe a idade"); // ADD INPUT EXCEPTION SÓ NUMEROS
					idade = scan5.nextLine();
		
					Animal a = new Gato(nome,raca,sexo,peso,idade,"saudavel","calmo",null);
					cadastro.cadastraranimal(a);
					System.out.println("Cadastro realizado com sucesso");
					System.out.print("\n");
				}
				catch(InputMismatchException i){
					System.err.println("Insira somente números");
				}
				catch(NAMException n){
					System.err.println(n.getMessage());
				}
			}
			if(escolha2 >=3){
				try{
					Scanner scan5 = new Scanner(System.in);
					Scanner scan6 = new Scanner(System.in);
					Scanner scan7 = new Scanner(System.in);
					Scanner scan8 = new Scanner(System.in);
					System.out.println("Digite a especie do Animal"); // ADD INPUT EXCEPTION SÓ LETRAS
					String especie = scan5.nextLine();
					check.checaNome(especie);
					System.out.println("Digite o nome do Animal"); // ADD INPUT EXCEPTION SÓ LETRAS
					nome = scan6.nextLine();			
			
					System.out.println("Digite a raça do Animal"); // ADD INPUT EXCEPTION SÓ LETRAS
					raca = scan7.nextLine();
				
					System.out.println("Informe o sexo do animal");
					System.out.println("1 - Fêmea\n2 - Macho");
					String sexo = null;
					int escsexo = scan7.nextInt();
					if(escsexo <= 1)
						sexo = "Fêmea";
					else
						sexo = "Macho";
				
			
					System.out.println("Informe o peso"); // ADD INPUT EXCEPTION SÓ NUMEROS
					peso = scan.nextDouble();
			
					System.out.println("Informe a idade"); // ADD INPUT EXCEPTION SÓ NUMEROS
					idade = scan5.nextLine();
		
					Animal a = new Outro(nome,raca,sexo,peso,idade,"saudavel","calmo", especie,null);
					cadastro.cadastraranimal(a);
					System.out.println("Cadastro realizado com sucesso");
					System.out.print("\n");
				}
					catch(InputMismatchException i){
						System.err.println("Insira somente números");
				}
					catch(NAMException n){
						System.err.println(n.getMessage());
				}
			}
			
		}
	
	if(escolha == 3){//BUSCA
		Scanner scan2 = new Scanner(System.in);
		System.out.println("1 -Cachorro");
		System.out.println("2 - Gato");
		System.out.println("3 - Outro");
		int escolha2 = scan2.nextInt();
		
		if(escolha2 <= 1){
			String raca;
			System.out.println("Digite a raca do animal que está procurando");
			raca = scan2.next();
			try{
				ArrayList<Animal>cachorros = cadastro.buscaAnimais(raca,escolha2); // TRY CATCH
				int aux = cadastro.buscaAnimais(raca,escolha2).size();
				for(int i=0;i<aux;i++){
					System.out.println(cachorros.get(i));
				}
				System.out.print("\n");
				}
			catch(RepoException rep){
				System.err.println(rep.getMessage());
				System.out.println("\n");
			}
		}
		
		if(escolha2 == 2){
			String raca;
			System.out.println("Digite a raca do animal que está procurando");
			raca = scan2.next();
			try{ 
				ArrayList<Animal>gatos = cadastro.buscaAnimais(raca,escolha2); // TRY CATCH
				int aux = cadastro.buscaAnimais(raca,escolha2).size();
				for(int i=0;i<aux;i++){
					System.out.println(gatos.get(i).toString());
				}
				System.out.print("\n");
				}
			catch(RepoException rep){
				System.err.println(rep.getMessage());
				System.out.println("\n");
			}
			
		}
		if(escolha2 >= 3){
			String especie;
			System.out.println("Digite a especie do animal que está procurando");
			especie = scan2.next();
			try{
				ArrayList<Animal>outros = cadastro.buscaAnimais(especie,escolha2); // TRY CATCH
				int aux = cadastro.buscaAnimais(especie,escolha2).size();
				for(int i=0;i<aux;i++){
					System.out.println(outros.get(i).toString());
				}
				System.out.print("\n");
			}
			catch(RepoException rep){
				System.err.println(rep.getMessage());
				System.out.println("\n");
			}
		
		}
	}
	
	if(escolha == 4){//ADOÇAO
		
		Scanner scan2 = new Scanner(System.in);
			long numero;
			System.out.println("Digite o id do animal que está procurando");
			numero = scan2.nextLong();
			try{
				Animal c = cadastro.buscaid(numero); // TRY CATCH
				System.out.println(c);
				Pessoa p = new Pessoa("Johny Joestar", 15, 40028922, "Rua dos bobos nº 0", "Pipoca", "1234");
				Adocao a = new Adocao(c, p);
				if(c.isAdotado() == true)
					System.out.print("Adoção realizada com sucesso em: " +a.getData());
					cadastroad.cadastrar(a);
				
				System.out.print("\n\n");
				}
	catch(IDException rep){
		System.err.println(rep.getMessage());
		System.out.println("\n");
		}
	
	}
			}//FIM WHILE
	
}}

