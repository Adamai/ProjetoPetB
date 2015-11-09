package ufrpe.petbuddy.dados.exceptions;

public class IDException extends Exception {

	private long numid;
	
	public IDException(long numid){
		super("N�o foi encontrado animal cadastrado com o id" + numid);
		this.numid = numid;
	}
}
