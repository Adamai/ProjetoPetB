package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;

import java.util.ArrayList;

public class CadastroAnimal implements ICadastroA{

private IRepositorioA repositorio;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
		
	}
	
	public void cadastrar(Animal a){
		if(a != null ){ // incluir condição de existencia
			this.repositorio.cadastrar(a);
		}
	}
	
public ArrayList<Animal> buscaAnimais(String raca, int num){ 
		
		if((this.repositorio.busca(raca, num)) !=null){
			ArrayList<Animal>buscados = this.repositorio.busca(raca,num);
			return buscados;
		}
		else 
			return null;
	}

public Animal busca(long numid){
	Animal a = this.repositorio.busca(numid);
	this.repositorio.adotar(numid);
	return a;
	}

}
