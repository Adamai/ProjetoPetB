package ufrpe.projetos.canil.gui;

import java.util.Scanner;

import ufrpe.projetos.canil.negocio.Cachorro;
import ufrpe.projetos.canil.negocio.CadastroCachorro;
import ufrpe.projetos.canil.negocio.CadastroPessoa;
import ufrpe.projetos.canil.negocio.*;
import ufrpe.projetos.canil.*;

public class Teste {

public static void main(String[] args){
		
	int controlador = 1;
	
	CadastroPessoa cadastrop = new CadastroPessoa();
	CadastroCachorro cadastroc = new CadastroCachorro();
	System.out.println("Bem vindo ao Pet Buddy");
	
while(controlador !=0){	
	
	System.out.println("O Que deseja fazer?");
	System.out.println("1 - Cadastro de Cliente");
	System.out.println("2 - Cadastro de cães");
	System.out.println("3 - Acessar cães");
	
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
		
		
		System.out.println("Digite o nome do cão");
		nome = scan.next();
		
		
		System.out.println("Digite a raça do cão");
		raca = scan.next();
		
		System.out.println("Informe o peso");
		peso = scan.nextDouble();
		
		System.out.println("Informe a idade");
		idade = scan.nextInt();
	
		Cachorro c = new Cachorro(nome,raca,peso,idade,"saudavel","calmo");
		cadastroc.cadastrar(c);
		System.out.println("Cadastro realizado com sucesso");
		System.out.print("\n");
	}
	
	
	if(escolha == 3){
		Scanner scan2 = new Scanner(System.in);
		
		String bug;
		String raca;
		System.out.println("Digite a raca do cachorro q está procurando");
		raca = scan2.nextLine();
		Cachorro c[] = cadastroc.busca(raca);
		int aux = cadastroc.busca(raca).length;
		for(int i=0;i<aux;i++){
			System.out.println(c[i].toString());
		}
		System.out.print("\n");
		
			}
					
		
		}//FIM WHILE
	
	}
}
