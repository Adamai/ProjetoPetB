package ufrpe.petbuddy.exceptions;

public class RepoException extends Exception {

	private String raca;
	private int num;

	public RepoException(String raca, int num) {
		super("Não foi encontrado nenhum animal da raça " + raca);
		this.raca = raca;
		this.num = num;

	}

}
