package ufrpe.petbuddy.exceptions;

public class RepoException extends Exception {

	private String raca;
	private int num;
	private String nome;
	
	

	public RepoException(String raca, int num) {
		super("N�o foi encontrado nenhum animal da ra�a " + raca);
		this.raca = raca;
		this.num = num;

	}
	
	public RepoException(String nome) {
		super("N�o foi encontrado nenhum usu�rio chamado: " + nome);

	}

	public RepoException(String login, String senha) {
		super("N�o foi encontrado nenhuma conta cadastrada com esses dados");

	}
	
}
