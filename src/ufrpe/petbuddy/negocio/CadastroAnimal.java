package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Animal;

import java.util.ArrayList;

public class CadastroAnimal implements ICadastroAnimal{

private IRepositorioAnimais repositorio;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
		
	}
	
	public void cadastraranimal(Animal a){
			this.repositorio.cadastrar(a);
		}

	
public ArrayList<Animal> buscaAnimais(String raca, int num) throws RepoException{ // ADD NULL EXCEPTION
		
			this.repositorio.busca(raca, num); 
			ArrayList<Animal>buscados = this.repositorio.busca(raca,num);
			return buscados;
	}

public Animal buscaid(long numid) throws IDException{ //ADD NULL EXCEPTION
	Animal a = this.repositorio.busca(numid);
	this.repositorio.adotar(numid);
	return a;
	}

}
