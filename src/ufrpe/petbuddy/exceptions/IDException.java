package ufrpe.petbuddy.exceptions;

public class IDException extends Exception {

	private long numid;
	
	public IDException(long numid){
		super("N�o foi encontrado nada cadastrado com o id " + numid);
		this.numid = numid;
	}
}
