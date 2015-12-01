package ufrpe.petbuddy.exceptions;

import ufrpe.petbuddy.negocio.beans.*;

public class RepoException extends Exception {

	private String raca;
	private AnimalEspecie especie;
	private String nome;
	
	

	public RepoException(String raca, AnimalEspecie especie) {
		super("N�o foi encontrado nenhum animal da ra�a " + raca);
		this.raca = raca;
		this.especie = especie;

	}
	
	public RepoException(String nome) {
		super("N�o foi encontrado nenhum usu�rio chamado: " + nome);

	}

	public RepoException(String login, String senha) {
		super("N�o foi encontrado nenhuma conta cadastrada com esses dados");

	}
	public RepoException(){
		super("Nenhum item cadastrado");
	}
	
}
