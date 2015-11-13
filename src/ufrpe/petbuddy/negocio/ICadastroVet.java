package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.Veterinario;

public interface ICadastroVet {// INTERFACE DE CADASTROVET

	void cadastrar(Veterinario vet);
	Veterinario busca(long numid) throws NullPointerException;
	ArrayList<Veterinario> busca() throws NullPointerException;
	
}
