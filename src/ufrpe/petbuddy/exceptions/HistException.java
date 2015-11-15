package ufrpe.petbuddy.exceptions;

public class HistException extends Exception{

	public HistException(){
		super("Não existe nenhum item no histórico");
	}
	
}
