package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.RepositorioPessoas;

public class ControleLogin implements ILogin {
	
	private Usuario user;
	private RepositorioPessoas repo;
	
	public ControleLogin(){
		
	}
	
	public Usuario EfetuarLogin(String login, String senha){
		if(login != Adm.getLogin())
			return repo.buscaLogin(login, senha);
		else if(login.equals(Adm.getLogin()) && senha.equals(Adm.getSenha()))
			return ;
			
	}
	
	
	

}
