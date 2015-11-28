package ufrpe.petbuddy.negocio.beans;

import ufrpe.petbuddy.exceptions.*;


public class Veterinario extends Usuario {
	
	private static long proximo = 1;
	private long numid;
	private long crmv;
	
	public Veterinario(String nome, int idade, long contato, long crmv) throws DadosException{
		super(nome, idade, contato);
		this.numid = proximo;
		this.crmv = crmv;
		Veterinario.AumentarProximo();
	}
	
	public static void AumentarProximo(){
		proximo = proximo + 1;
	}

	public long getNumid() {
		return numid;
	}
	public long getCrmv(){
		return crmv;
	}
	public void setCrmv(long crmv){
		this.crmv = crmv;
	}
	
}
