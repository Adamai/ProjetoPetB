package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.*;
import java.util.ArrayList;

public interface IRepositorioD { 

	
	void cadastrar(Veterinario vet);
	Veterinario busca(long numid)throws IDException;
	ArrayList<Veterinario> busca() throws NullPointerException;
	void remover(long numid) throws IDException;
}
