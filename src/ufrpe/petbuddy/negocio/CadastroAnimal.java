package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;

import java.util.ArrayList;

public class CadastroAnimal implements ICadastroA{

private IRepositorioA repositorio;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
		
	}
	
	public void cadastrar(Animal a){
			this.repositorio.cadastrar(a);
		}

	
public ArrayList<Animal> buscaAnimais(String raca, int num){ // ADD NULL EXCEPTION
		
		if((this.repositorio.busca(raca, num)) !=null){ //ADD EXCEPTION
			ArrayList<Animal>buscados = this.repositorio.busca(raca,num);
			return buscados;
		}
		else 
			return null; // REMOVER
	}

public Animal busca(long numid){ //ADD NULL EXCEPTION
	Animal a = this.repositorio.busca(numid);
	this.repositorio.adotar(numid);
	return a;
	}

}
