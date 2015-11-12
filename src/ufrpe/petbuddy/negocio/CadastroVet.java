package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import java.util.ArrayList;

public class CadastroVet {

	private IRepositorioD repositorio;
	
	public CadastroVet(){
		this.repositorio = new RepositorioMedicos();
	}
	
	public void cadastrar(Veterinario vet){
		this.repositorio.cadastrar(vet);
	}
	
	public Veterinario busca(long numid) throws IDException{
		return this.repositorio.busca(numid);
	}
	
	public ArrayList<Veterinario> busca() throws NullPointerException{
		return this.repositorio.busca();
	}
	
	
}
