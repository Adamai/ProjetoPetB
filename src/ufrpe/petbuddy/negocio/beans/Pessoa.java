package ufrpe.petbuddy.negocio.beans;



public class Pessoa extends Usuario {
private String login;
private String senha;
private String endereco;
	
	public Pessoa(String nome, int idade, int contato, String endereco,String login,String senha){
		super(nome, idade, contato);
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return  "Nome: " + nome+ "\nidade: " + idade + "\nendereco: " + endereco + "\ncontato: " + contato ;
	}

	
}
