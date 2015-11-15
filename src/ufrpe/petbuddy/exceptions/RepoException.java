package ufrpe.petbuddy.exceptions;

public class RepoException extends Exception {

	private String raca;
	private int num;
	private String nome;
	
	

	public RepoException(String raca, int num) {
		super("Não foi encontrado nenhum animal da raça " + raca);
		this.raca = raca;
		this.num = num;

	}
	
	public RepoException(String nome) {
		super("Não foi encontrado nenhum usuário chamado: " + nome);

	}

	public RepoException(String login, String senha) {
		super("Não foi encontrado nenhuma conta cadastrada com esses dados");

	}
	
}
