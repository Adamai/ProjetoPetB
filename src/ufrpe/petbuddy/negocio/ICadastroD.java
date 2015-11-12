package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

public interface ICadastroD {// INTERFACE DE CADASTROVET

	void cadastrar(Veterinario vet);
	Veterinario busca(long numid) throws NullPointerException;
	ArrayList<Veterinario> busca() throws NullPointerException;
	
}
