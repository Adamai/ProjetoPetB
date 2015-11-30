package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.*;

import java.util.ArrayList;

public class CadastroAnimal implements ICadastroAnimal{

private IRepositorioAnimais repositorio;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
		
	}
	
	public void cadastrar(Animal a){
			this.repositorio.cadastrar(a);
		}

	
public ArrayList<Animal> busca(String raca, AnimalEspecie especie) throws RepoException{ // ADD NULL EXCEPTION
		
			this.repositorio.busca(raca, especie ); 
			ArrayList<Animal>buscados = this.repositorio.busca(raca,especie);
			return buscados;
	}

public Animal busca(long numid) throws IDException{ //ADD NULL EXCEPTION
	Animal a = this.repositorio.busca(numid);
	this.repositorio.adotar(numid);
	return a;
	}

	public void atualizar(Animal c){
		this.repositorio.atualizar(c);
	}
	public ArrayList<Animal> listarAnimais() throws HistException{
		return this.repositorio.listarAnimais();
	}
	public ArrayList<Animal> buscaEspecie(AnimalEspecie especie){
		return this.repositorio.buscaEspecie(especie);
	}

}
