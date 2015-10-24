package ufrpe.projetos.canil.negocio;

public class Pessoa {
	private String nome;
	private int idade;
	private int contato;
	private int donos;
	private String endereco;
	private String login;
	private String senha;
	
	public Pessoa(String nome, int idade, int contato,int donos, String endereco,String login,String senha){
		this.nome = nome;
		this.idade = idade;
		this.contato = contato;
		this.donos = donos;
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
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

	public int getDonos() {
		return donos;
	}

	public void setDonos(int donos) {
		this.donos = donos;
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
