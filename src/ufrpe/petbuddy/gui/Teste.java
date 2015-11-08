package ufrpe.petbuddy.gui;

import java.util.Scanner;
import java.util.ArrayList;

import ufrpe.petbuddy.negocio.*;


public class Teste {

public static void main(String[] args){
	int controlador = 1;
	
	ICadastroA cadastro = new CadastroAnimal();
	ICadastroB cadastrop = new CadastroPessoa();
	ICadastroC cadastroad = new CadastroAdocao();
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
		 int donos;
		 String endereco;
		 //String login;
		 //String senha;
			Scanner scan5 = new Scanner(System.in);
			Scanner scan6 = new Scanner(System.in);
		 System.out.println("Digite seu nome"); // ADD EXCEPTION
		 nome = scan5.nextLine();
		 System.out.println("Informe seu numero de contato"); // ADD EXCEPTION
		 contato = scan.nextInt();
		 System.out.println("Insira sua idade"); // ADD EXCEPTION 
		 idade = scan.nextInt();
		 System.out.println("Infome seu endereco"); 
		 endereco = scan6.nextLine();
		 		
		 Pessoa p = new Pessoa(nome,idade,contato, endereco,"batata","doce");
		 cadastrop.cadastrar(p);
		 System.out.println("Cadastro realizado com sucesso");
		 System.out.println(cadastrop.busca(nome)); // ADD EXCEPTION
		 
		 
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
			Scanner scan5 = new Scanner(System.in);
			Scanner scan6 = new Scanner(System.in);
			System.out.println("Digite o nome do cão");
			nome = scan5.nextLine();
		
			System.out.println("Digite a raça do cão");
			raca = scan6.nextLine();
		
			System.out.println("Informe o peso");
			peso = scan.nextDouble();
		
			System.out.println("Informe a idade");
			idade = scan5.nextLine();
	
			Animal a = new Cachorro(nome,raca,peso,idade,"saudavel","calmo");
			
			cadastro.cadastrar(a);
			System.out.println("Cadastro realizado com sucesso");
			System.out.print("\n");
		
			
		}
			if(escolha2 == 2){
				Scanner scan5 = new Scanner(System.in);
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Digite o nome do Gato");
				nome = scan5.nextLine();
			
				System.out.println("Digite a raça do Gato");
				raca = scan6.nextLine();
			
				System.out.println("Informe o peso");
				peso = scan.nextDouble();
			
				System.out.println("Informe a idade");
				idade = scan5.nextLine();
		
				Animal a = new Gato(nome,raca,peso,idade,"saudavel","calmo");
				cadastro.cadastrar(a);
				System.out.println("Cadastro realizado com sucesso");
				System.out.print("\n");
		}
			if(escolha2 >=3){
				Scanner scan5 = new Scanner(System.in);
				Scanner scan6 = new Scanner(System.in);
				Scanner scan7 = new Scanner(System.in);
				System.out.println("Digite a especie do Animal");
				String especie = scan5.nextLine();
				
				System.out.println("Digite o nome do Animal");
				nome = scan6.nextLine();			
			
				System.out.println("Digite a raça do Animal");
				raca = scan7.nextLine();
			
				System.out.println("Informe o peso");
				peso = scan.nextDouble();
			
				System.out.println("Informe a idade");
				idade = scan5.nextLine();
		
				Animal a = new Outro(nome,raca,peso,idade,"saudavel","calmo", especie);
				cadastro.cadastrar(a);
				System.out.println("Cadastro realizado com sucesso");
				System.out.print("\n");
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
			ArrayList<Animal>cachorros = cadastro.buscaAnimais(raca,escolha2); // ADD EXCEPTION
			int aux = cadastro.buscaAnimais(raca,escolha2).size();
			for(int i=0;i<aux;i++){
				System.out.println(cachorros.get(i));
			}
			System.out.print("\n");
			
		}
		
		if(escolha2 == 2){
			String raca;
			System.out.println("Digite a raca do animal que está procurando");
			raca = scan2.next();
			ArrayList<Animal>gatos = cadastro.buscaAnimais(raca,escolha2); // ADD EXCEPTION
			int aux = cadastro.buscaAnimais(raca,escolha2).size();
			for(int i=0;i<aux;i++){
				System.out.println(gatos.get(i).toString());
			}
			System.out.print("\n");
			
		}
		if(escolha2 >= 3){
			String especie;
			System.out.println("Digite a especie do animal que está procurando");
			especie = scan2.next();
			ArrayList<Animal>outros = cadastro.buscaAnimais(especie,escolha2); // ADD EXCEPTION
			int aux = cadastro.buscaAnimais(especie,escolha2).size();
			for(int i=0;i<aux;i++){
				System.out.println(outros.get(i).toString());
			}
			System.out.print("\n");
			
		}
		
		}
	
	if(escolha == 4){//ADOÇAO
		
		Scanner scan2 = new Scanner(System.in);
			long numero;
			System.out.println("Digite o id do animal que está procurando");
			numero = scan2.nextLong();
			Animal c = cadastro.busca(numero); // ADD EXCEPTION
			System.out.println(c);
			Pessoa p = new Pessoa("Johny Joestar", 15, 40028922, "Rua dos bobos nº 0", "Pipoca", "1234");
			Adocao a = new Adocao(c, p);
			if(c.isAdotado() == true)
				System.out.print("Adoção realizada com sucesso em: " +a.getData());
				cadastroad.cadastrar(a);
			}
			System.out.print("\n\n");
			
			}//FIM WHILE
	
}}

