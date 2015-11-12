package ufrpe.petbuddy.negocio;


public class Veterinario extends Usuario {
	
	private static long proximo = 1;
	private long numid;
	
	public Veterinario(String nome, int idade, int contato){
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
