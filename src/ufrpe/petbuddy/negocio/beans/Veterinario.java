package ufrpe.petbuddy.negocio.beans;

import java.io.Serializable;

import ufrpe.petbuddy.exceptions.*;


public class Veterinario extends Usuario implements Serializable {
	
	private static long proximo = 1;
	private long numid;
	
	
	public Veterinario(String nome, int idade, long contato) throws DadosException{
		super(nome, idade, contato);
		this.numid = proximo;
		Veterinario.AumentarProximo();
	}
	
	public static void AumentarProximo(){
		proximo = proximo + 1;
	}

	public long getNumid() {
		return numid;
	}
		
}
