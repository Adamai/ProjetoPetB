package ufrpe.petbuddy.exceptions;

public class DadosException extends Exception{

	
	public DadosException(){
		super("Dados inv�lidos");
	}
	
	public DadosException(String msg){
		super(msg);
	}
	
}
