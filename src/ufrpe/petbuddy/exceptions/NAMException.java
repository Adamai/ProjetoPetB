package ufrpe.petbuddy.exceptions;

public class NAMException extends Exception{

	private String name;
	
	public NAMException(String nome){
		super("Insira um nome v�lido");
		this.name =nome;
	}
	
}
