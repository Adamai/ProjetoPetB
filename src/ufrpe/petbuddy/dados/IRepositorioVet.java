package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Veterinario;

import java.util.ArrayList;

public interface IRepositorioVet { 

	
	void cadastrar(Veterinario vet);
	Veterinario busca(long numid)throws IDException;
	ArrayList<Veterinario> busca() throws NullPointerException;
	void remover(long numid) throws IDException;
}
