package ufrpe.petbuddy.exceptions;

public class RepoException extends Exception {

	private String raca;
	private int num;

	public RepoException(String raca, int num) {
		super("N�o foi encontrado nenhum animal da ra�a " + raca);
		this.raca = raca;
		this.num = num;

	}

}
