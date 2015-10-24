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
	
	Scanner scan = new Scanner(System.in);
	int escolha = scan.nextInt();
	
	
	if(escolha == 1){
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
		 		
		 Pessoa p = new Pessoa(nome,idade,contato,donos,endereco,"batata","doce");
		 cadastrop.cadastrar(p);
		 
	}
	
	if(escolha==2){
		String nome;
		String raca;
		double peso;
		int idade;
		
		
		System.out.println("1 - Cachorro");
		System.out.println("2 - Gato");
		int escolha2 = scan.nextInt();
		
		if(escolha2 <= 1 ){
			
			System.out.println("Digite o nome do cão");
			nome = scan.next();
		
		
			System.out.println("Digite a raça do cão");
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
			
			
				System.out.println("Digite a raça do Gato");
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
	
	
	
	if(escolha == 3){
		Scanner scan2 = new Scanner(System.in);
		System.out.println("1 -Cachorro");
		System.out.println("2 - Gato");
		int escolha2 = scan2.nextInt();
		
		if(escolha2 <= 1){
			String raca;
			System.out.println("Digite a raca do animal que está procurando");
			raca = scan2.next();
			ArrayList<Animal>cachorros = cadastro.buscaCachorro(raca);
			int aux = cadastro.buscaCachorro(raca).size();
			for(int i=0;i<aux;i++){
				System.out.println(cachorros.get(i).toString());
			}
			System.out.print("\n");
			
		}
		
		if(escolha2 >= 2){
			String raca;
			System.out.println("Digite a raca do animal que está procurando");
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
