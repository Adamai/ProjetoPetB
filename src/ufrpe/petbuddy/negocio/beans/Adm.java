package ufrpe.petbuddy.negocio.beans;
import ufrpe.petbuddy.exceptions.*;

public class Adm extends Usuario {
	
	private String login = "petbuddy";
	private String senha = "adoroanimais";
	
	public Adm() throws DadosException{
		super("adm",30,56174679);
		
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	
}
