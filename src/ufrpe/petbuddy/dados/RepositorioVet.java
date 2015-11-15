package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Veterinario;
import ufrpe.petbuddy.exceptions.*;

public class RepositorioVet implements IRepositorioVet {

	private ArrayList<Veterinario>veterinarios;
	
	public RepositorioVet(){
		this.veterinarios = new ArrayList<Veterinario>();
	}
	
	public void cadastrar(Veterinario vet){
		this.veterinarios.add(vet);
	}
	
	public Veterinario busca(long numid) throws IDException{
		Veterinario vet = null;
		for(int i = 0; i<veterinarios.size();i++){
			if(veterinarios.get(i).getNumid() == numid)
				vet = veterinarios.get(i);
		}
		if(vet != null)
			return vet;
		else
			throw new IDException(numid);
		
	}
	
	public ArrayList<Veterinario> busca() throws HistException{
		if(this.veterinarios.size()>0)
			return this.veterinarios;
		else
			throw new HistException();
	}
	
	
	public void remover(long numid) throws IDException{
		veterinarios.remove(this.busca(numid));
	}
	
}
