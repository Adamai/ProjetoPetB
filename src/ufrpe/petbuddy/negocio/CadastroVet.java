package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Veterinario;

import java.util.ArrayList;

public class CadastroVet {

	private IRepositorioVet repositorio;
	
	public CadastroVet(){
		this.repositorio = new RepositorioVet();
	}
	
	public void cadastrarvet(Veterinario vet){
		this.repositorio.cadastrar(vet);
	}
	
	public Veterinario buscavet(long numid) throws IDException{
		return this.repositorio.busca(numid);
	}
	
	public ArrayList<Veterinario> buscavet() throws NullPointerException{
		return this.repositorio.busca();
	}
	
	
}
