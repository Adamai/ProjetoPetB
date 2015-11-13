package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.negocio.beans.Usuario;

public class ControleLogin implements ILogin {
	

	private CadastroPessoa cadastrop;
	
	public ControleLogin(CadastroPessoa cadastrop){
		this.cadastrop = cadastrop;
	}
	
	public Usuario EfetuarLogin(String login, String senha){
		return this.cadastrop.buscausuario(login, senha);
		
	}
	
	
	

}
