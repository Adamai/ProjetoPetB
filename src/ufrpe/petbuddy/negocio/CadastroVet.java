package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Veterinario;

import java.util.ArrayList;

public class CadastroVet implements ICadastroVet {

	private IRepositorioVet repositorio;
	
	public CadastroVet(){
		this.repositorio = new RepositorioVet();
	}
	
	public void cadastrar(Veterinario vet){
		this.repositorio.cadastrar(vet);
	}
	
	public Veterinario busca(long numid) throws IDException{
		return this.repositorio.busca(numid);
	}
	
	public ArrayList<Veterinario> busca() throws HistException{
		return this.repositorio.busca();
	}
	public void removerVeterinario(Veterinario v){
		 this.repositorio.removerVeterinario(v);
	}
	public void atualizarVeterinario(Veterinario v){
		this.repositorio.atualizarVeterinario(v);
	}
	
	
}
