package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.exceptions.*;

public class RepositorioMedicos implements IRepositorioD {

	private ArrayList<Veterinario>veterinarios;
	
	public RepositorioMedicos(){
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
	
	public ArrayList<Veterinario> busca() throws NullPointerException{
		if(this.veterinarios.size()>0)
			return this.veterinarios;
		else
			throw new NullPointerException("Nada encontrado");
	}
	
	
	public void remover(long numid) throws IDException{
		veterinarios.remove(this.busca(numid));
	}
	
}
