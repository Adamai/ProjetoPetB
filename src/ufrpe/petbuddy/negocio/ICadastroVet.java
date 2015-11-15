package ufrpe.petbuddy.negocio;

import java.util.ArrayList;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Veterinario;

public interface ICadastroVet {// INTERFACE DE CADASTROVET

	void cadastrar(Veterinario vet);
	Veterinario busca(long numid) throws IDException;
	ArrayList<Veterinario> busca()throws HistException;
	
}
