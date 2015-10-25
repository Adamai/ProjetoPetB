package ufrpe.projetos.canil.gui;

import java.util.Scanner;
import java.util.ArrayList;
import ufrpe.projetos.canil.negocio.*;


public class Teste {

public static void main(String[] args){
		
	int controlador = 1;
	
	CadastroPessoa cadastrop = new CadastroPessoa();
	//CadastroCachorro cadastroc = new CadastroCachorro();
	CadastroAnimal cadastro = new CadastroAnimal();
	System.out.println("Bem vindo ao Pet Buddy");
	
while(controlador !=0){	
	
	System.out.println("O Que deseja fazer?");
	System.out.println("1 - Cadastro de Cliente");
	System.out.println("2 - Cadastro de Animais");
	System.out.println("3 - Acessar Animais");
	System.out.println("4 - Adotar Animais");
	
	Scanner scan = new Scanner(System.in);
	int escolha = scan.nextInt();
	
	
	if(escolha == 1){//CADASTRO USU�RIO
		 String nome;
		 int idade;
		 int contato;
		 int donos;
		 String endereco;
		 //String login;
		 //String senha;
		 
		 System.out.println("Digite seu nome");
		 nome = scan.next();
		 System.out.println("Informe seu numero de contato");
		 contato = scan.nextInt();
		 System.out.println("informe o numero de moradores da sua casa");
		 donos = scan.nextInt();
		 System.out.println("Insira sua idade");
		 idade = scan.nextInt();
		 System.out.println("Infome seu endereco");
		 endereco = scan.next();
		 System.out.println(endereco);
		 		
		 Pessoa p = new Pessoa(nome,idade,contato, endereco,"batata","doce");
		 cadastrop.cadastrar(p);
		 
	}
	
	if(escolha==2){//CADASTRO ANIMAIS
		String nome;
		String raca;
		double peso;
		int idade;
		
		
		System.out.println("1 - Cachorro");
		System.out.println("2 - Gato");
		int escolha2 = scan.nextInt();
		
		if(escolha2 <= 1 ){
			
			System.out.println("Digite o nome do c�o");
			nome = scan.next();
		
		
			System.out.println("Digite a ra�a do c�o");
			raca = scan.next();
		
			System.out.println("Informe o peso");
			peso = scan.nextDouble();
		
			System.out.println("Informe a idade");
			idade = scan.nextInt();
	
			Animal a = new Cachorro(nome,raca,peso,idade,"saudavel","calmo");
			
			cadastro.cadastrar(a);
			System.out.println("Cadastro realizado com sucesso");
			System.out.print("\n");
		
			/*if(a instanceof Cachorro){
				Cachorro cachorro = (Cachorro) a;
				cadastroc.cadastrar(cachorro);
				System.out.println("Cadastro realizado com sucesso");
				System.out.print("\n");
			}*/
		}
			if(escolha2 >= 2){
				
				System.out.println("Digite o nome do Gato");
				nome = scan.next();
			
			
				System.out.println("Digite a ra�a do Gato");
				raca = scan.next();
			
				System.out.println("Informe o peso");
				peso = scan.nextDouble();
			
				System.out.println("Informe a idade");
				idade = scan.nextInt();
		
				Animal a = new Gato(nome,raca,peso,idade,"saudavel","calmo");
				
				cadastro.cadastrar(a);
				System.out.println("Cadastro realizado com sucesso");
				System.out.print("\n");
			}
		}
	
	
	
	if(escolha == 3){//BUSCA
		Scanner scan2 = new Scanner(System.in);
		System.out.println("1 -Cachorro");
		System.out.println("2 - Gato");
		int escolha2 = scan2.nextInt();
		
		if(escolha2 <= 1){
			String raca;
			System.out.println("Digite a raca do animal que est� procurando");
			raca = scan2.next();
			ArrayList<Animal>cachorros = cadastro.buscaCachorro(raca);
			int aux = cadastro.buscaCachorro(raca).size();
			for(int i=0;i<aux;i++){
				System.out.println(cachorros.get(i));
			}
			System.out.print("\n");
			
		}
		
		if(escolha2 >= 2){
			String raca;
			System.out.println("Digite a raca do animal que est� procurando");
			raca = scan2.next();
			ArrayList<Animal>gatos = cadastro.buscaGato(raca);
			int aux = cadastro.buscaGato(raca).size();
			for(int i=0;i<aux;i++){
				System.out.println(gatos.get(i).toString());
			}
			System.out.print("\n");
			
		}
		
		
			}
	
	if(escolha == 4){//ADO�AO
		//listar animais com o nome inserido e seus dados com um numero para ser inserido ao lado
		//ex: procuro Ringo, vai aparecer:
		//1 - Iggy  Peso: tal, status: tal
		//2 - Iggy  Peso: tal, status: tal
		// O usuario insere o numero respectivo ao que quer adotar e confirma a escolha
		Scanner scan2 = new Scanner(System.in);
		System.out.println("1 -Cachorro");
		System.out.println("2 - Gato");
		int escolha2 = scan2.nextInt();
		
		if(escolha2 <= 1){
			String nome;
			System.out.println("Digite o nome do animal que est� procurando");
			nome = scan2.next();
			Animal c = cadastro.adotar(nome);
			System.out.println(c);
			Pessoa p = new Pessoa("Johny Joestar", 15, 40028922, "Rua dos bobos n� 0", "Pipoca", "1234");
			Adocao a = new Adocao(c, p);
			if(c.isAdotado() == true)
				System.out.print("Ado��o realizada com sucesso em: " +a.getData());
			}
			System.out.print("\n");
			
		
		
		if(escolha2 >= 2){
			String raca;
			System.out.println("Digite a raca do animal que est� procurando");
			raca = scan2.next();
			ArrayList<Animal>gatos = cadastro.buscaGato(raca);
			int aux = cadastro.buscaGato(raca).size();
			for(int i=0;i<aux;i++){
				System.out.println(gatos.get(i).toString());
			}
			System.out.print("\n");
			
		    }	
		
		
		}
					
		
		}//FIM WHILE
	
	}
}
