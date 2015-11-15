package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

public class ControleLogin implements ILogin {
	

	private CadastroPessoa cadastrop;
	
	public ControleLogin(CadastroPessoa cadastrop){
		this.cadastrop = cadastrop;
	}
	
	public Usuario EfetuarLogin(String login, String senha) throws RepoException{
		return this.cadastrop.busca(login, senha);
		
	}
	
	
	

}
