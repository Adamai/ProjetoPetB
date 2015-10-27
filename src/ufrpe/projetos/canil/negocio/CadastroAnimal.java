package ufrpe.projetos.canil.negocio;

import ufrpe.projetos.canil.dados.*;
import java.util.ArrayList;

public class CadastroAnimal {

private IRepositorio[] repositorios;
	
	public CadastroAnimal(){
		this.repositorios = new IRepositorio[2];
		this.repositorios[0] = new RepositorioAnimais();
		this.repositorios[1] = new RepositorioAdotados();
	}
	
	public void cadastrar(Animal a){
		if(a != null ){ // incluir condição de existencia
			this.repositorios[0].cadastrar(a);
		}
	}
	
public ArrayList<Animal> buscaAnimais(String raca, int num){ 
		
		if((this.repositorios[0].busca(raca, num)) !=null){
			ArrayList<Animal>buscados = this.repositorios[0].busca(raca,num);
			return buscados;
		}
		else 
			return null;
	}


//public Animal adotar(String nome){
	//Animal a = this.repositorios[].buscaAdocao(nome);
	//this.repositorios[2].cadastrar(a);
	//return a;
	//		}
}
