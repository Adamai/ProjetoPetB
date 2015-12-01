package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

public class ControleLogin implements ILogin {
	

	private CadastroUsuario cadastrop;
	
	public ControleLogin(CadastroUsuario cadastrop){
		this.cadastrop = cadastrop;
	}
	
	public Usuario EfetuarLogin(String login, String senha) throws RepoException{
		return this.cadastrop.busca(login, senha);
		
	}
	public boolean VerificarLogin( String login){
		return this.cadastrop.VerificarLogin(login);
	}
	
	
	

}
