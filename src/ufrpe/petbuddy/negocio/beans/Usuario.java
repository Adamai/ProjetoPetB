package ufrpe.petbuddy.negocio.beans;

public abstract class Usuario {
	protected int contato;
	protected String nome;
	protected int idade;

	
	public Usuario(String nome, int idade, int contato){
		this.nome = nome;
		this.idade = idade;
		this.contato = contato;

	}


	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}

	
}
