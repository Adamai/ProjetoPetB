package ufrpe.projetos.canil.negocio;

public class Pessoa extends Usuario {
	
	private String endereco;
	private String login;
	private String senha;

	
	public Pessoa(String nome, int idade, int contato, String endereco,String login,String senha){
		super(nome, idade, contato);
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
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

}
